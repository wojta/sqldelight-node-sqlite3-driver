package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.SqlPreparedStatement
import org.khronos.webgl.Int8Array

internal class SQLite3PreparedStatement(parameters: Int) : SqlPreparedStatement {
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
            throw SQLite3Exception(
                "Long value $long exceeds the 2^53 precision limit of the JS Number bridge " +
                        "(see README's Limitations section) and cannot be bound reliably."
            )
        }
        // We convert Long to Double because Kotlin's Double is mapped to JS number
        // whereas Kotlin's Long is implemented as a JS object
        parameters[index] = long?.toDouble()
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
            true -> 1.0
            false -> 0.0
        }
    }
}
