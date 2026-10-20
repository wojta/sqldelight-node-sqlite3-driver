package cz.sazel.sqldelight.node.sqlite3

import cz.sazel.sqldelight.node.sqlite.SQLite3Connection
import cz.sazel.sqldelight.node.sqlite.SQLite3JsException
import cz.sazel.sqldelight.node.sqlite.SQLite3Statement
import kotlinx.coroutines.suspendCancellableCoroutine
import node.sqlite3.Sqlite3
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@JsName("Object")
private external object JsObject {
    @Suppress("UnusedParameter")
    fun values(obj: Any): Array<dynamic>
}

private suspend fun callback(block: (callback: (err: Throwable?) -> Unit) -> Unit): Unit =
    suspendCancellableCoroutine { cont ->
        block { err ->
            if (err == null) cont.resume(Unit) else cont.resumeWithException(SQLite3JsException(err))
        }
    }

internal class Sqlite3Connection(private val db: Sqlite3.Database) : SQLite3Connection {

    override suspend fun prepare(sql: String): SQLite3Statement {
        val statement: Sqlite3.Statement = suspendCancellableCoroutine { cont ->
            lateinit var statement: Sqlite3.Statement
            statement = db.prepare(sql) { err ->
                if (err != null) cont.resumeWithException(SQLite3JsException(err)) else cont.resume(statement)
            }
        }
        return Sqlite3StatementWrapper(statement)
    }

    override suspend fun exec(sql: String) = callback { db.exec(sql, it) }

    override suspend fun close() = callback { db.close(it) }
}

internal class Sqlite3StatementWrapper(private val statement: Sqlite3.Statement) : SQLite3Statement {

    override suspend fun bind(parameters: List<Any?>) = callback { done ->
        // node-sqlite3 can't bind Kotlin's Long (a JS object), only JS numbers
        statement.bind(parameters.map { if (it is Long) it.toDouble() else it }.toTypedArray(), done)
    }

    override suspend fun run(): Long {
        callback { statement.run(it) }
        // node-sqlite3 sets `changes` on the statement itself right before firing the run callback
        return statement.unsafeCast<Sqlite3.RunResult>().changes.toLong()
    }

    override suspend fun step(): Array<dynamic>? =
        suspendCancellableCoroutine { cont ->
            statement.get { err, row ->
                when {
                    err != null -> cont.resumeWithException(SQLite3JsException(err))
                    row != null -> cont.resume(JsObject.values(row))
                    else -> cont.resume(null)
                }
            }
        }

    override suspend fun reset() = callback { done -> statement.reset { done(null) } }

    override suspend fun finalize() = callback { statement.finalize(it) }
}
