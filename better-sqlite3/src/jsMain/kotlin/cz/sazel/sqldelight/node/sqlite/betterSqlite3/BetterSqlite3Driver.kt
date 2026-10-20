package cz.sazel.sqldelight.node.sqlite.betterSqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.InternalSQLite3DriverApi
import cz.sazel.sqldelight.node.sqlite.SQLite3Driver
import cz.sazel.sqldelight.node.sqlite.betterSqlite3.externals.newBetterSqlite3Database
import cz.sazel.sqldelight.node.sqlite.withSchema
import cz.sazel.sqldelight.node.sqlite.wrapJsErrors

/**
 * Opens [filename] with the `better-sqlite3` Node.js module.
 * @param schema created right after opening when given
 * @param beginImmediate start transactions with `BEGIN IMMEDIATE`
 */
@OptIn(InternalSQLite3DriverApi::class)
suspend fun initBetterSqlite3SqlDriver(
    filename: String,
    schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null,
    beginImmediate: Boolean = false,
): SQLite3Driver =
    SQLite3Driver(
        BetterSqlite3Connection(wrapJsErrors { newBetterSqlite3Database(filename) }),
        beginImmediate,
    ).withSchema(schema)
