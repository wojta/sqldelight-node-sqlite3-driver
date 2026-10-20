package cz.sazel.sqldelight.node.sqlite

import app.cash.sqldelight.db.SqlPreparedStatement
import org.khronos.webgl.Int8Array

internal class SQLitePreparedStatement(parameters: Int) : SqlPreparedStatement {
    val parameters = MutableList<Any?>(parameters) { null }

    override fun bindBytes(index: Int, bytes: ByteArray?) {
        parameters[index] = bytes?.let { toNodeBuffer(it) }
    }

    private fun toNodeBuffer(bytes: ByteArray): dynamic {
        val view = bytes.unsafeCast<Int8Array>()
        return js("Buffer").from(view.buffer, view.byteOffset, view.byteLength)
    }

    override fun bindLong(index: Int, long: Long?) {
        if (long != null && kotlin.math.abs(long) > MAX_SAFE_LONG) {
            throw SQLiteException(
                "Long value $long exceeds the 2^53 precision limit of the JS Number bridge " +
                        "(see README's Limitations section) and cannot be bound reliably."
            )
        }
        // kept as Long, each backend converts it to the JS type its binding expects
        parameters[index] = long
    }

    override fun bindDouble(index: Int, double: Double?) {
        parameters[index] = double
    }

    override fun bindString(index: Int, string: String?) {
        parameters[index] = string
    }

    override fun bindBoolean(index: Int, boolean: Boolean?) {
        parameters[index] = when (boolean) {
            null -> null
            true -> 1L
            false -> 0L
        }
    }
}
