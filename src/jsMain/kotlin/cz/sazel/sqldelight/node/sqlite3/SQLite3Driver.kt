package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.*
import kotlinx.coroutines.suspendCancellableCoroutine
import node.sqlite3.Sqlite3
import node.sqlite3.Sqlite3.OPEN_CREATE
import node.sqlite3.Sqlite3.OPEN_READWRITE
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun initSqlite3SqlDriver(
    filename: String, mode: Number? = null,
    schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null,
): SQLite3Driver =
    SQLite3Driver(initSqlite3Database(filename, mode ?: (OPEN_CREATE.toInt() or OPEN_READWRITE.toInt()))).withSchema(
        schema
    )

private fun initSqlite3Database(
    filename: String, mode: Number = OPEN_CREATE.toInt() or OPEN_READWRITE.toInt()
): Sqlite3.Database = Sqlite3.Database(filename, mode)

internal suspend fun SQLite3Driver.withSchema(schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null) =
    this.also { schema?.create(it)?.await() }

internal suspend fun (Sqlite3.Statement).finalizeSuspending(): Unit =
    suspendCancellableCoroutine { cont ->
        finalize { err ->
            if (err == null) cont.resume(Unit) else cont.resumeWithException(SQLite3JsException(err))
        }
    }

private suspend fun (Sqlite3.Database).execSuspending(sql: String): Unit =
    suspendCancellableCoroutine { cont ->
        exec(sql) { err ->
            if (err == null) cont.resume(Unit) else cont.resumeWithException(SQLite3JsException(err))
        }
    }

class SQLite3Driver internal constructor(private val db: Sqlite3.Database) : SqlDriver {
    private val listeners = mutableMapOf<String, MutableSet<Query.Listener>>()
    private var transaction: Transaction? = null

    internal inner class Transaction(
        override val enclosingTransaction: Transaction?,
    ) : Transacter.Transaction() {
        internal val statements = mutableMapOf<Int, Sqlite3.Statement>()
        override fun endTransaction(successful: Boolean): QueryResult<Unit> = QueryResult.AsyncValue {
            if (enclosingTransaction == null) {
                statements.values.forEach { it.finalizeSuspending() }
                statements.clear()
                db.execSuspending(if (successful) "END TRANSACTION" else "ROLLBACK TRANSACTION")
            }
            transaction = enclosingTransaction
        }

        /**
         * Use for tests only.
         */
        internal fun _endTransactionForTests(successful: Boolean) = endTransaction(successful)
    }

    private suspend fun createOrGetStatement(identifier: Int?, sql: String): Sqlite3.Statement {
        identifier?.let { transaction?.statements?.get(it) }?.let { return it }

        val preparedStatement: Sqlite3.Statement = suspendCancellableCoroutine { cont ->
            lateinit var statement: Sqlite3.Statement
            statement = db.prepare(sql) { err ->
                if (err != null) cont.resumeWithException(SQLite3JsException(err)) else cont.resume(statement)
            }
        }

        if (identifier != null) transaction?.statements?.put(identifier, preparedStatement)
        return preparedStatement
    }

    /** Statements cached by a transaction are reused and finalized by [Transaction.endTransaction], not by the caller. */
    private suspend fun Sqlite3.Statement.finalizeUnlessCached() {
        if (transaction?.statements?.containsValue(this) != true) finalizeSuspending()
    }

    override fun execute(
        identifier: Int?, sql: String,
        parameters: Int, binders: (SqlPreparedStatement.() -> Unit)?
    ): QueryResult<Long> = QueryResult.AsyncValue {
        val statement = createOrGetStatement(identifier, sql)
        try {
            statement.bind(parameters, binders)
            suspendCancellableCoroutine { cont ->
                statement.run { err ->
                    if (err == null) cont.resume(Unit) else cont.resumeWithException(SQLite3JsException(err))
                }
            }
            // node-sqlite3 sets `changes` on the statement itself right before firing the run callback
            statement.unsafeCast<Sqlite3.RunResult>().changes.toLong()
        } finally {
            statement.finalizeUnlessCached()
        }
    }

    override fun <R> executeQuery(
        identifier: Int?,
        sql: String,
        mapper: (SqlCursor) -> QueryResult<R>,
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ): QueryResult<R> = QueryResult.AsyncValue {
        var statement: Sqlite3.Statement? = null
        val cursor = SQLite3Cursor {
            createOrGetStatement(identifier, sql).also {
                statement = it
                it.bind(parameters, binders)
            }
        }
        try {
            mapper(cursor).await()
        } finally {
            statement?.finalizeUnlessCached()
        }
    }

    override fun newTransaction(): QueryResult<Transacter.Transaction> = QueryResult.AsyncValue {
        val enclosing = transaction
        val transaction = Transaction(enclosing)
        this.transaction = transaction
        if (enclosing == null) {
            db.execSuspending("BEGIN TRANSACTION")
        }

        return@AsyncValue transaction
    }

    override fun currentTransaction(): Transacter.Transaction? = transaction

    internal fun _endTransactionForTests(successful: Boolean) = transaction?._endTransactionForTests(successful)

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

    override fun close() {
        db.close { err ->
            if (err != null) println(err)
        }
    }

    private suspend fun Sqlite3.Statement.bind(
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ) {
        if (binders == null || parameters <= 0) return
        val bound = SQLite3PreparedStatement(parameters)
        binders(bound)
        suspendCancellableCoroutine { cont ->
            bind(bound.parameters.toTypedArray()) { err ->
                if (err == null) cont.resume(Unit) else cont.resumeWithException(SQLite3JsException(err))
            }
        }
    }
}
