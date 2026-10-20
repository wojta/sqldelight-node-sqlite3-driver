package cz.sazel.sqldelight.node.sqlite

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.test.DriverWithLibraryTest
import cz.sazel.sqldelight.node.sqlite.test.SQLite3DriverTest

class NodeSqliteDriverTest : SQLite3DriverTest() {
    override suspend fun createDriver(
        filename: String,
        schema: SqlSchema<QueryResult.AsyncValue<Unit>>?,
        beginImmediate: Boolean,
    ) = initNodeSqliteSqlDriver(filename, schema = schema, beginImmediate = beginImmediate)
}

class NodeSqliteDriverWithLibraryTest : DriverWithLibraryTest() {
    override suspend fun createDriver(filename: String, schema: SqlSchema<QueryResult.AsyncValue<Unit>>) =
        initNodeSqliteSqlDriver(filename, schema = schema)
}
