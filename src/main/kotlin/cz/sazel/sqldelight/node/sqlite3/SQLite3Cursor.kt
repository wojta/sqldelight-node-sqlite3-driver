package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.SqlCursor
import org.khronos.webgl.Int8Array
import org.khronos.webgl.Uint8Array

internal class SQLite3Cursor(result: Array<Array<dynamic>>) : SqlCursor {

    private val rows: Array<Array<dynamic>>

    init {
        val jsObject = js("Object") //TODO this is weird, find way to improve
        rows = result.map { jsObject.values(it) as Array<dynamic> }.toTypedArray()
    }

    private var row = -1;

    override fun next(): Boolean =
        if (row >= rows.size - 1)
            false
        else {
            row++
            true
        }

    private fun checkCursorState() {
        js("Object")
        if (row < 0) throw SQLite3Exception("Cursor was not yet iterated, call next() first.")
    }

    override fun getString(index: Int): String? {
        checkCursorState()
        return rows[row][index] as String?
    }

    override fun getLong(index: Int): Long? {
        checkCursorState()
        val value = rows[row][index] as? Number
        return value?.toLong()
    }

    override fun getBytes(index: Int): ByteArray? {
        checkCursorState()
        return (rows[row][index] as? Uint8Array)?.let { Int8Array(it.buffer).unsafeCast<ByteArray>() }
    }

    override fun getDouble(index: Int): Double? {
        checkCursorState()
        return rows[row][index] as Double?
    }

    override fun getBoolean(index: Int): Boolean? {
        checkCursorState()
        return rows[row][index] as Boolean?
    }
}
