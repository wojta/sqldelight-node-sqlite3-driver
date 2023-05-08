package cz.sazel.sqldelight.node.sqlite3


/**
 * Exception of [SQLite3Driver].
 * Usually this class is directly returned in case of error within driver itself.
 */
open class SQLite3Exception(message: String) : Exception(message)

/**
 * Exception that occurs from within SQLite 3 Node.js module.
 */
class SQLite3JsException(private val err: Throwable?) : SQLite3Exception(err.nullable?.message ?: "unknown error") {
    /**
     * SQLite error number
     */
    val errorNumber: Int
        get() = err?.asDynamic().errno as? Int ?: -1
}

