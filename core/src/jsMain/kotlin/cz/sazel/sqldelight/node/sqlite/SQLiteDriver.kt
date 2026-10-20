package cz.sazel.sqldelight.node.sqlite

import app.cash.sqldelight.Query
import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * Creates [schema] (if given) on this driver, used by backend modules' init functions.
 */
@InternalSQLiteDriverApi
suspend fun SQLiteDriver.withSchema(schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null): SQLiteDriver =
    this.also { schema?.create(it)?.await() }

/**
 * Asynchronous SQLDelight driver on top of a [SQLiteConnection] provided by a backend module.
 * @param beginImmediate start transactions with `BEGIN IMMEDIATE` instead of `BEGIN TRANSACTION`
 */
class SQLiteDriver(
    private val connection: SQLiteConnection,
    private val beginImmediate: Boolean = false,
) : SqlDriver {
    private val listeners = mutableMapOf<String, MutableSet<Query.Listener>>()
    private var transaction: Transaction? = null
    private var closed = false

    internal inner class Transaction(
        override val enclosingTransaction: Transaction?,
    ) : Transacter.Transaction() {
        internal val statements = mutableMapOf<Int, SQLiteStatement>()
        override fun endTransaction(successful: Boolean): QueryResult<Unit> = QueryResult.AsyncValue {
            if (enclosingTransaction == null) {
                statements.values.forEach { it.finalize() }
                statements.clear()
                connection.exec(if (successful) "END TRANSACTION" else "ROLLBACK TRANSACTION")
            }
            transaction = enclosingTransaction
        }

        /**
         * Use for tests only.
         */
        internal fun _endTransactionForTests(successful: Boolean) = endTransaction(successful)
    }

    private suspend fun createOrGetStatement(identifier: Int?, sql: String): SQLiteStatement {
        identifier?.let { transaction?.statements?.get(it) }?.let { return it }

        val preparedStatement = connection.prepare(sql)

        if (identifier != null) transaction?.statements?.put(identifier, preparedStatement)
        return preparedStatement
    }

    /**
     * Statements cached by a transaction are reused and finalized by [Transaction.endTransaction],
     * not by the caller. They are reset instead, since some backends block the connection while
     * a statement is in the middle of its rows.
     */
    private suspend fun SQLiteStatement.release() {
        if (transaction?.statements?.containsValue(this) == true) reset() else finalize()
    }

    override fun execute(
        identifier: Int?, sql: String,
        parameters: Int, binders: (SqlPreparedStatement.() -> Unit)?
    ): QueryResult<Long> = QueryResult.AsyncValue {
        val statement = createOrGetStatement(identifier, sql)
        try {
            statement.bindAll(parameters, binders)
            statement.run()
        } finally {
            statement.release()
        }
    }

    override fun <R> executeQuery(
        identifier: Int?,
        sql: String,
        mapper: (SqlCursor) -> QueryResult<R>,
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ): QueryResult<R> = QueryResult.AsyncValue {
        var statement: SQLiteStatement? = null
        val cursor = SQLiteCursor {
            createOrGetStatement(identifier, sql).also {
                statement = it
                it.bindAll(parameters, binders)
            }
        }
        try {
            mapper(cursor).await()
        } finally {
            statement?.release()
        }
    }

    override fun newTransaction(): QueryResult<Transacter.Transaction> = QueryResult.AsyncValue {
        val enclosing = transaction
        if (enclosing == null) {
            connection.exec(if (beginImmediate) "BEGIN IMMEDIATE" else "BEGIN TRANSACTION")
        }
        val transaction = Transaction(enclosing)
        this.transaction = transaction

        return@AsyncValue transaction
    }

    override fun currentTransaction(): Transacter.Transaction? = transaction

    /**
     * Use for tests only.
     */
    @InternalSQLiteDriverApi
    fun _endTransactionForTests(successful: Boolean) = transaction?._endTransactionForTests(successful)

    override fun addListener(vararg queryKeys: String, listener: Query.Listener) {
        queryKeys.forEach {
            listeners.getOrPut(it) { mutableSetOf() }.add(listener)
        }
    }

    override fun removeListener(vararg queryKeys: String, listener: Query.Listener) {
        queryKeys.forEach {
            listeners[it]?.remove(listener)
        }
    }

    override fun notifyListeners(vararg queryKeys: String) {
        queryKeys.flatMap { listeners[it].orEmpty() }
            .distinct()
            .forEach(Query.Listener::queryResultsChanged)
    }

    /**
     * Fire-and-forget: the database may still be open when this returns.
     * Use [closeSuspending] to wait for the close to complete.
     */
    override fun close() {
        if (closed) return
        closed = true
        suspend { connection.close() }.startCoroutine(Continuation(EmptyCoroutineContext) { result ->
            result.onFailure {
                closed = false
                console.error(it)
            }
        })
    }

    /**
     * Closes the database and waits for completion; throws [SQLiteJsException] on failure.
     * Idempotent, backends answer a second close with an error.
     * A failed close (e.g. unfinalized statements in sqlite3) leaves the database open and can be retried.
     */
    suspend fun closeSuspending() {
        if (closed) return
        closed = true
        try {
            connection.close()
        } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
            closed = false
            throw e
        }
    }

    private suspend fun SQLiteStatement.bindAll(
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ) {
        if (binders == null || parameters <= 0) return
        val bound = SQLitePreparedStatement(parameters)
        binders(bound)
        bind(bound.parameters)
    }
}
