package cz.sazel.sqldelight.node.sqlite


/**
 * Exception of [SQLiteDriver].
 * Usually this class is directly returned in case of error within driver itself.
 */
open class SQLiteException(message: String) : Exception(message)

/**
 * Exception that occurs from within the SQLite Node.js module of the backend.
 */
class SQLiteJsException(private val err: Throwable?) : SQLiteException(err?.message ?: "unknown error") {
    /**
     * SQLite primary result code, `-1` when unknown.
     */
    val errorNumber: Int
        get() {
            val js = err?.asDynamic() ?: return -1
            // sqlite3 has `errno`, node:sqlite the extended `errcode`, better-sqlite3 only a name like `SQLITE_ERROR`
            (js.errno as? Int)?.let { return it }
            (js.errcode as? Int)?.let { return it and PRIMARY_CODE_MASK }
            val code = js.code as? String ?: return -1
            return PRIMARY_CODES[code.removePrefix("SQLITE_").substringBefore('_')] ?: -1
        }

    private companion object {
        const val PRIMARY_CODE_MASK = 0xFF

        val PRIMARY_CODES = listOf(
            "OK", "ERROR", "INTERNAL", "PERM", "ABORT", "BUSY", "LOCKED", "NOMEM", "READONLY", "INTERRUPT",
            "IOERR", "CORRUPT", "NOTFOUND", "FULL", "CANTOPEN", "PROTOCOL", "EMPTY", "SCHEMA", "TOOBIG",
            "CONSTRAINT", "MISMATCH", "MISUSE", "NOLFS", "AUTH", "FORMAT", "RANGE", "NOTADB", "NOTICE", "WARNING",
        ).withIndex().associate { (code, name) -> name to code }
    }
}
