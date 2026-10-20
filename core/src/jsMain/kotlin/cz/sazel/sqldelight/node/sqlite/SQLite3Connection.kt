package cz.sazel.sqldelight.node.sqlite

/**
 * Database connection of a SQLite backend module, wrapped by [SQLite3Driver].
 * Implementations throw [SQLite3JsException] on SQLite errors.
 */
interface SQLite3Connection {
    suspend fun prepare(sql: String): SQLite3Statement

    suspend fun exec(sql: String)

    suspend fun close()
}

/**
 * Prepared statement of a [SQLite3Connection].
 */
interface SQLite3Statement {
    /**
     * Binds positional parameters for the next [run] or [step].
     * Values are `null`, [Long], [Double], [String] or a Node.js `Buffer`.
     */
    suspend fun bind(parameters: List<Any?>)

    /**
     * Executes the statement, returns the number of changed rows.
     */
    suspend fun run(): Long

    /**
     * Fetches the next row as column values, `null` when there are no more rows.
     */
    suspend fun step(): Array<dynamic>?

    /**
     * Rewinds the statement so [step] starts from the first row again.
     */
    suspend fun reset()

    suspend fun finalize()
}

/**
 * Marks API that is public only for backend modules and shared tests.
 */
@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
annotation class InternalSQLite3DriverApi

/**
 * Converts [SQLite3Statement.bind] parameters for backends that bind JS numbers as REAL,
 * [Long] becomes a JS `BigInt` so it is bound as INTEGER.
 */
@InternalSQLite3DriverApi
fun List<Any?>.withLongsAsBigInt(): Array<Any?> = map { if (it is Long) jsBigInt(it.toString()) else it }.toTypedArray()

@Suppress("UnusedParameter")
private fun jsBigInt(value: String): dynamic = js("BigInt(value)")

/**
 * Runs [block] and rethrows any JS error as [SQLite3JsException].
 */
@InternalSQLite3DriverApi
inline fun <T> wrapJsErrors(block: () -> T): T =
    try {
        block()
    } catch (e: SQLite3Exception) {
        throw e
    } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
        throw SQLite3JsException(e)
    }
