package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import kotlinx.coroutines.suspendCancellableCoroutine
import node.sqlite3.Sqlite3
import org.khronos.webgl.Int8Array
import org.khronos.webgl.Uint8Array
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@JsName("Object")
private external object JsObject {
    fun values(obj: Any): Array<dynamic>
}

internal class SQLite3Cursor internal constructor(val statementInit: suspend () -> Sqlite3.Statement) : SqlCursor {

    private var statement: Sqlite3.Statement? = null
    private var row: Array<dynamic>? = null

    override fun next(): QueryResult<Boolean> = QueryResult.AsyncValue {
        val statement = statement ?: statementInit().also {
            statement = it
            it.resetSuspending()
        }
        row = statement.fetchRow()
        row != null
    }

    private suspend fun Sqlite3.Statement.fetchRow(): Array<dynamic>? =
        suspendCancellableCoroutine { cont ->
            get { err, row ->
                when {
                    err != null -> cont.resumeWithException(SQLite3JsException(err))
                    row != null -> cont.resume(JsObject.values(row))
                    else -> cont.resume(null)
                }
            }
        }

    private suspend fun Sqlite3.Statement.resetSuspending(): Unit =
        suspendCancellableCoroutine { cont ->
            reset { cont.resume(Unit) }
        }

    private fun requireRow(): Array<dynamic> = row ?: throw SQLite3Exception(
        "Cursor was either not yet iterated or " +
                "already iterated all over, call next() first."
    )

    override fun getString(index: Int): String? = requireRow()[index] as String?

    override fun getLong(index: Int): Long? = (requireRow()[index] as? Number)?.toLong()

    override fun getBytes(index: Int): ByteArray? =
        (requireRow()[index] as? Uint8Array)?.let { Int8Array(it.buffer).unsafeCast<ByteArray>() }

    override fun getDouble(index: Int): Double? = (requireRow()[index] as? Number)?.toDouble()

    override fun getBoolean(index: Int): Boolean? = getLong(index)?.let { it != 0L }
}