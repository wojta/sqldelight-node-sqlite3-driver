package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.SqlPreparedStatement

internal class SQLite3PreparedStatement(parameters: Int) : SqlPreparedStatement {
    val parameters = MutableList<Any?>(parameters) { null }

    override fun bindBytes(index: Int, bytes: ByteArray?) {
        parameters[index] = bytes?.toTypedArray()
    }

    override fun bindLong(index: Int, long: Long?) {
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
