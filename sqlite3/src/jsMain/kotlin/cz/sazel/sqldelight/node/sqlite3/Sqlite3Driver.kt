package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.InternalSQLiteDriverApi
import cz.sazel.sqldelight.node.sqlite.SQLiteDriver
import cz.sazel.sqldelight.node.sqlite.withSchema

/**
 * Opens [filename] with the `sqlite3` Node.js module.
 * @param mode open flags, defaults to `OPEN_CREATE | OPEN_READWRITE`
 * @param schema created right after opening when given
 * @param beginImmediate start transactions with `BEGIN IMMEDIATE`
 */
@OptIn(InternalSQLiteDriverApi::class)
suspend fun initSqlite3SqlDriver(
    filename: String, mode: Number? = null,
    schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null,
    beginImmediate: Boolean = false,
): SQLiteDriver =
    SQLiteDriver(
        Sqlite3Connection(newDatabase(sqlite3Exports().Database, filename, mode ?: openFlags())),
        beginImmediate,
    ).withSchema(schema)
