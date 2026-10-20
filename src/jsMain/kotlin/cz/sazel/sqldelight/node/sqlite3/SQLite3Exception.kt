@file:Suppress("DEPRECATION")

package cz.sazel.sqldelight.node.sqlite3


/**
 * Exception of [SQLite3Driver].
 * Usually this class is directly returned in case of error within driver itself.
 */
@Deprecated(DEPRECATION_MESSAGE, ReplaceWith("SQLiteException", "cz.sazel.sqldelight.node.sqlite.SQLiteException"))
open class SQLite3Exception(message: String) : Exception(message)

/**
 * Exception that occurs from within SQLite 3 Node.js module.
 */
@Deprecated(DEPRECATION_MESSAGE, ReplaceWith("SQLiteJsException", "cz.sazel.sqldelight.node.sqlite.SQLiteJsException"))
class SQLite3JsException(private val err: Throwable?) : SQLite3Exception(err?.message ?: "unknown error") {
    /**
     * SQLite error number
     */
    val errorNumber: Int
        get() = err?.asDynamic().errno as? Int ?: -1
}

