package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import node.sqlite3.Sqlite3
import org.khronos.webgl.Int8Array
import org.khronos.webgl.Uint8Array
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class SQLite3Cursor(val statementInit: suspend () -> Sqlite3.Statement) : SqlCursor {

    private val jsObject = js("Object") //TODO this is weird, find way to improve
    private lateinit var statement: Sqlite3.Statement
    private var row: Array<dynamic>? = null

    private var initialized = false;
    private var counter = 0

    override fun next(): QueryResult<Boolean> = QueryResult.AsyncValue {
        if (!initialized) { // initialization
            statement = statementInit()
            reset()
            initialized = true
        }
        row = fetchRow()
        if (row == null) {
            _close()
            return@AsyncValue false
        }
        counter++
        true
    }

    private suspend fun fetchRow(): Array<dynamic>? {
        val result: Array<dynamic>? = suspendCoroutine { cont ->
            val callback: (row: Any?, row2: Any?) -> Unit = { row, row2 ->
                if (row == null && row2 != null) {
                    cont.resume(jsObject.values(row2))
                } else if (row != null) {
                    cont.resumeWithException(SQLite3JsException(row as Throwable?))
                } else {
                    cont.resume(null)
                }
            }
            statement = statement.get(callback)
        }
        return result
    }

    @Suppress("FunctionNaming")
    internal suspend fun _close() {
        statement.finalizeSuspending()
    }

    private suspend fun reset() {
        suspendCoroutine { cont ->
            val callback: (Nothing?) -> Unit = {
                cont.resume(Unit)
            }
            statement.reset(callback)
        }
    }

    private fun checkCursorState() {
        if (row == null) throw SQLite3Exception(
            "Cursor was either not yet iterated or " +
                    "already iterated all over, call next() first."
        )
    }

    override fun getString(index: Int): String? {
        checkCursorState()
        return row?.get(index) as String?
    }

    override fun getLong(index: Int): Long? {
        checkCursorState()
        val value = row?.get(index) as? Number
        return value?.toLong()
    }

    override fun getBytes(index: Int): ByteArray? {
        checkCursorState()
        return (row?.get(index) as? Uint8Array)?.let { Int8Array(it.buffer).unsafeCast<ByteArray>() }
    }

    override fun getDouble(index: Int): Double? {
        checkCursorState()
        return row?.get(index) as Double?
    }

    override fun getBoolean(index: Int): Boolean? {
        return getLong(index)?.let { it != 0L }
    }
}
