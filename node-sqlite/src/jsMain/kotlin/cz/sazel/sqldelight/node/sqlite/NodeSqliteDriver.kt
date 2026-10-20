package cz.sazel.sqldelight.node.sqlite

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.externals.NodeSqlite

/**
 * Opens [filename] with the `node:sqlite` module built into Node.js 24 and newer.
 * @param schema created right after opening when given
 * @param beginImmediate start transactions with `BEGIN IMMEDIATE`
 */
@OptIn(InternalSQLite3DriverApi::class)
suspend fun initNodeSqliteSqlDriver(
    filename: String,
    schema: SqlSchema<QueryResult.AsyncValue<Unit>>? = null,
    beginImmediate: Boolean = false,
): SQLite3Driver =
    SQLite3Driver(
        NodeSqliteConnection(wrapJsErrors { NodeSqlite.DatabaseSync(filename) }),
        beginImmediate,
    ).withSchema(schema)
