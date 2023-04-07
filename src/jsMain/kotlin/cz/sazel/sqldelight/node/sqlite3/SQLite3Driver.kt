package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import node.sqlite3.Sqlite3
import node.sqlite3.Sqlite3.OPEN_CREATE
import node.sqlite3.Sqlite3.OPEN_READWRITE
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun initSqlite3SqlDriver(
    filename: String, mode: Number = OPEN_CREATE.toInt() or OPEN_READWRITE.toInt(),
    schema: SqlSchema? = null,
): SqlDriver = SQLite3Driver(initSqlite3Database(filename, mode)).withSchema(schema)

private fun initSqlite3Database(
    filename: String, mode: Number = OPEN_CREATE.toInt() or OPEN_READWRITE.toInt()
): Sqlite3.Database = Sqlite3.Database(filename, mode)

suspend fun SqlDriver.withSchema(schema: SqlSchema? = null): SqlDriver = this.also { schema?.create(it)?.await() }

class SQLite3Driver(private val db: Sqlite3.Database) : SqlDriver {
    private val listeners = mutableMapOf<String, MutableSet<Query.Listener>>()
    private val statements = mutableMapOf<Int, Sqlite3.Statement>()
    private var transaction: Transacter.Transaction? = null

    private inner class Transaction(
        override val enclosingTransaction: Transacter.Transaction?,
    ) : Transacter.Transaction() {
        override fun endTransaction(successful: Boolean): QueryResult<Unit> = QueryResult.AsyncValue {
            if (enclosingTransaction == null) {
                val sql = if (successful) "END TRANSACTION" else "ROLLBACK TRANSACTION"
                suspendCoroutine { cont ->
                    val callback: (Any) -> Unit = { self ->
                        if (self !is Throwable) {
                            cont.resume(self as Sqlite3.Statement)
                        } else {
                            cont.resumeWithException(SQLite3Exception(self))
                        }
                    }
                    db.run(sql, callback)
                }
            }
            transaction = enclosingTransaction
        }
    }

    private fun createOrGetStatement(identifier: Int?, sql: String): Sqlite3.Statement {
        val res = if (identifier == null) {
            println("prepare suspend identifier==null")
            db.prepare(sql)
        } else {
            statements.getOrPut(identifier) {
                println("prepare suspend getOrPut($identifier)")
                val res2 = db.prepare(sql)
                println("prepare suspend getOrPut($identifier) end")
                return@getOrPut res2
            }
//                .apply {
//                println("reset")
//                reset()
//            }
        }
        return res
    }

    override fun <R> executeQuery(identifier: Int?, sql: String, mapper: (SqlCursor) -> R, parameters: Int, binders: (SqlPreparedStatement.() -> Unit)?): QueryResult<R> =
        QueryResult.AsyncValue {
            val statement = createOrGetStatement(identifier, sql)
            statement.bind(parameters, binders)
            //TODO unfortunately it needs to fetch all rows as SqlCursor is not async friendly, this needs to be improved in future
            val rows = suspendCoroutine { cont ->
                statement.all { error, rows ->
                    if (error is Throwable) {
                        println("resuming with exception")
                        cont.resumeWithException(error)
                    } else {
                        println("rows")
                        cont.resume(rows)
                    }
                }
            }


            val cursor = SQLite3Cursor(rows)
            mapper(cursor)
        }

    override fun execute(identifier: Int?, sql: String, parameters: Int, binders: (SqlPreparedStatement.() -> Unit)?): QueryResult<Long> = QueryResult.AsyncValue {
        println("execute(\"$sql\")")
        val statement = createOrGetStatement(identifier, sql)
        statement.bind(parameters, binders)
        println("execute bound")
        suspendCoroutine { cont ->
            val callback: (Any) -> Unit = { self ->
                if (self is Throwable) {
                    cont.resumeWithException(SQLite3Exception(self))
                } else {
                    cont.resume(Unit)
                }
            }
            statement.run(callback)
        }
        println("execute run")
        return@AsyncValue 0
    }

    override fun newTransaction(): QueryResult<Transacter.Transaction> = QueryResult.AsyncValue {
        val enclosing = transaction
        val transaction = Transaction(enclosing)
        this.transaction = transaction
        if (enclosing == null) {
            suspendCoroutine { cont ->
                val callback: (Any) -> Unit = { self ->
                    if (self !is Throwable) {
                        cont.resume(self as Sqlite3.Statement)
                    } else {
                        cont.resumeWithException(SQLite3Exception(self))
                    }
                }
                db.run("BEGIN TRANSACTION", callback)
            }
        }

        return@AsyncValue transaction
    }

    override fun currentTransaction(): Transacter.Transaction? = transaction

    override fun addListener(listener: Query.Listener, queryKeys: Array<String>) {
        queryKeys.forEach {
            listeners.getOrPut(it) { mutableSetOf() }.add(listener)
        }
    }

    override fun removeListener(listener: Query.Listener, queryKeys: Array<String>) {
        queryKeys.forEach {
            listeners[it]?.remove(listener)
        }
    }

    override fun notifyListeners(queryKeys: Array<String>) {
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
            suspendCoroutine { cont ->
                val callback: (Any?) -> Unit = {
                    if (it is Throwable)
                        cont.resumeWithException(it)
                    else
                        cont.resume(it)
                }
                bind(bound.parameters.toTypedArray(), callback)
            }
        }
    }
}
