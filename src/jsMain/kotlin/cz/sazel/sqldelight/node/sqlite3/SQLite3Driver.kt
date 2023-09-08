package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.*
import node.sqlite3.Sqlite3
import node.sqlite3.Sqlite3.OPEN_CREATE
import node.sqlite3.Sqlite3.OPEN_READWRITE
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

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

class SQLite3Driver internal constructor(private val db: Sqlite3.Database) : SqlDriver {
    private val listeners = mutableMapOf<String, MutableSet<Query.Listener>>()
    private val statements = mutableMapOf<Int, Sqlite3.Statement>()
    private var transaction: Transaction? = null

    internal inner class Transaction(
        override val enclosingTransaction: Transacter.Transaction?,
    ) : Transacter.Transaction() {
        override fun endTransaction(successful: Boolean): QueryResult<Unit> = QueryResult.AsyncValue {
            if (enclosingTransaction == null) {
                val sql = if (successful) "END TRANSACTION" else "ROLLBACK TRANSACTION"
                suspendCoroutine<Any?> { cont ->
                    val callback: (Any?) -> Unit = {
                        if (it == null || it !is Throwable) {
                            cont.resume(it)
                        } else {
                            cont.resumeWithException(SQLite3JsException(it))
                        }
                    }
                    db.exec(sql, callback)
                }
            }
            transaction = this
        }

        /**
         * Use for tests only.
         */
        internal fun _endTransactionForTests(successful: Boolean) = endTransaction(successful)
    }

    private suspend fun createOrGetStatement(identifier: Int?, sql: String): Sqlite3.Statement {

        val preparedStatement = suspendCoroutine { cont ->
            lateinit var statement: Sqlite3.Statement
            val callback: (Any) -> Unit = {
                if (it is Throwable) {
                    cont.resumeWithException(SQLite3JsException(it))
                } else {
                    cont.resume(statement)
                }
            }
            statement = db.prepare(sql, callback)
        }

        val res = if (identifier == null) {
            preparedStatement
        } else {
            statements.getOrPut(identifier) {
                return@getOrPut preparedStatement
            }
        }
        return res
    }

    override fun execute(
        identifier: Int?, sql: String,
        parameters: Int, binders: (SqlPreparedStatement.() -> Unit)?
    ): QueryResult<Long> = QueryResult.AsyncValue {
        val statement = createOrGetStatement(identifier, sql)
        statement.bind(parameters, binders)
        suspendCoroutine { cont ->
            val callback: (Any) -> Unit = {
                if (it is Throwable) {
                    cont.resumeWithException(SQLite3JsException(it))
                } else {
                    cont.resume(Unit)
                }
            }
            statement.run(callback)
        }
        return@AsyncValue 0
    }

    override fun <R> executeQuery(
        identifier: Int?,
        sql: String,
        mapper: (SqlCursor) -> QueryResult<R>,
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ): QueryResult<R> {
        val cursor = SQLite3Cursor {
            val statement = createOrGetStatement(identifier, sql)
            statement.bind(parameters, binders)
            statement
        }
        return mapper(cursor)
    }

    override fun newTransaction(): QueryResult<Transacter.Transaction> = QueryResult.AsyncValue {
        val enclosing = transaction
        val transaction = Transaction(enclosing)
        this.transaction = transaction
        if (enclosing == null) {
            suspendCoroutine<Any?> { cont ->
                val callback: (Any?) -> Unit = {
                    if (it == null || it !is Throwable) {
                        cont.resume(it)
                    } else {
                        cont.resumeWithException(SQLite3JsException(it))
                    }
                }
                db.exec("BEGIN TRANSACTION", callback)
            }
        }

        return@AsyncValue transaction
    }

    override fun currentTransaction(): Transacter.Transaction? = transaction

    internal fun _endTransactionForTests(successful: Boolean) = transaction?._endTransactionForTests(successful)

    internal suspend fun _finalizeAllStatements() {
        statements.onEach { statement ->
            suspendCoroutine<Any?> { cont ->
                val callback: (err: Error?) -> Unit = {
                    if (it == null) {
                        cont.resume(it)
                    } else {
                        cont.resumeWithException(SQLite3JsException(it))
                    }
                }
                statement.value.finalize(callback)
            }
        }
    }

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
        db.close {
            println(it)
        }
    }

    private suspend fun Sqlite3.Statement.bind(
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ) = binders?.let {
        if (parameters > 0) {
            val bound = SQLite3PreparedStatement(parameters)
            binders(bound)
            suspendCoroutine<Any?> { cont ->
                val callback: (Any?) -> Unit = {
                    if (it == null || it !is Throwable) {
                        cont.resume(it)
                    } else {
                        cont.resumeWithException(SQLite3JsException(it))
                    }
                }
                bind(bound.parameters.toTypedArray(), callback = callback)
            }
        }
    }
}
