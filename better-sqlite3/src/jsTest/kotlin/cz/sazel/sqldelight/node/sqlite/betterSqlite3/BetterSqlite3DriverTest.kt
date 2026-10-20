package cz.sazel.sqldelight.node.sqlite.betterSqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.test.DriverWithLibraryTest
import cz.sazel.sqldelight.node.sqlite.test.SQLite3DriverTest

class BetterSqlite3DriverTest : SQLite3DriverTest() {
    override suspend fun createDriver(
        filename: String,
        schema: SqlSchema<QueryResult.AsyncValue<Unit>>?,
        beginImmediate: Boolean,
    ) = initBetterSqlite3SqlDriver(filename, schema = schema, beginImmediate = beginImmediate)
}

class BetterSqlite3DriverWithLibraryTest : DriverWithLibraryTest() {
    override suspend fun createDriver(filename: String, schema: SqlSchema<QueryResult.AsyncValue<Unit>>) =
        initBetterSqlite3SqlDriver(filename, schema = schema)
}
