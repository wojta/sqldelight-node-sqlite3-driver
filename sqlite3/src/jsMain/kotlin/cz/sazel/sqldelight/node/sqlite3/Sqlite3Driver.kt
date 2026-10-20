package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.InternalSQLite3DriverApi
import cz.sazel.sqldelight.node.sqlite.SQLite3Driver
import cz.sazel.sqldelight.node.sqlite.withSchema

/**
 * Opens [filename] with the `sqlite3` Node.js module.
 * @param mode open flags, defaults to `OPEN_CREATE | OPEN_READWRITE`
 * @param schema created right after opening when given
 * @param beginImmediate start transactions with `BEGIN IMMEDIATE`
 */
@OptIn(InternalSQLite3DriverApi::class)
suspend fun initSqlite3SqlDriver(
    filename: String, mode: Number? = null,
    schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null,
    beginImmediate: Boolean = false,
): SQLite3Driver =
    SQLite3Driver(
        Sqlite3Connection(newDatabase(sqlite3Exports().Database, filename, mode ?: openFlags())),
        beginImmediate,
    ).withSchema(schema)
