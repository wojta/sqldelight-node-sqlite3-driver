package cz.sazel.sqldelight.node.sqlite

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import org.khronos.webgl.Int8Array
import org.khronos.webgl.Uint8Array

internal class SQLite3Cursor internal constructor(val statementInit: suspend () -> SQLite3Statement) : SqlCursor {

    private var statement: SQLite3Statement? = null
    private var row: Array<dynamic>? = null

    override fun next(): QueryResult<Boolean> = QueryResult.AsyncValue {
        val statement = statement ?: statementInit().also {
            statement = it
            it.reset()
        }
        row = statement.step()
        row != null
    }

    private fun requireRow(): Array<dynamic> = row ?: throw SQLite3Exception(
        "Cursor was either not yet iterated or " +
                "already iterated all over, call next() first."
    )

    override fun getString(index: Int): String? = requireRow()[index] as String?

    override fun getLong(index: Int): Long? {
        val value: dynamic = requireRow()[index]
        // node:sqlite and better-sqlite3 read integers as BigInt, parsed exactly to get the real magnitude
        val long = if (jsTypeOf(value) == "bigint") value.toString().unsafeCast<String>().toLong()
        else (value as? Number)?.toLong()
        return long?.also {
            if (kotlin.math.abs(it) > MAX_SAFE_LONG) {
                throw SQLite3Exception(
                    "Long value $it exceeds the 2^53 precision limit of the JS Number bridge " +
                            "(see README's Limitations section) and may not be the value that was stored."
                )
            }
        }
    }

    override fun getBytes(index: Int): ByteArray? =
        (requireRow()[index] as? Uint8Array)?.let {
            val view = Int8Array(it.buffer, it.byteOffset, it.length)
            Int8Array(view.length).apply { set(view) }.unsafeCast<ByteArray>()
        }

    override fun getDouble(index: Int): Double? {
        val value: dynamic = requireRow()[index]
        return if (jsTypeOf(value) == "bigint") jsNumber(value) else (value as? Number)?.toDouble()
    }

    override fun getBoolean(index: Int): Boolean? = getLong(index)?.let { it != 0L }
}

@Suppress("UnusedParameter")
private fun jsNumber(value: dynamic): Double = js("Number(value)").unsafeCast<Double>()
