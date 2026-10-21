@file:OptIn(InternalSQLiteDriverApi::class)

package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.InternalSQLiteDriverApi
import cz.sazel.sqldelight.node.sqlite.SQLiteJsException
import cz.sazel.sqldelight.node.sqlite.test.DriverWithLibraryTest
import cz.sazel.sqldelight.node.sqlite.test.SQLiteDriverTest
import cz.sazel.sqldelight.node.sqlite.test.deleteIfExists
import kotlin.test.Test
import kotlin.test.assertFailsWith

class Sqlite3DriverTest : SQLiteDriverTest() {
    override suspend fun createDriver(
        filename: String,
        schema: SqlSchema<QueryResult.AsyncValue<Unit>>?,
        beginImmediate: Boolean,
    ) = initSqlite3SqlDriver(filename, schema = schema, beginImmediate = beginImmediate)

    /**
     * Only node-sqlite3 refuses to close while a transaction keeps statements unfinalized.
     */
    @Test
    fun closeSuspending_reports_errors_and_can_be_retried() = kotlinx.coroutines.test.runTest {
        val file = "close-error-test.db"
        deleteIfExists(file)
        val driver = createDriver(file, schema = schema)
        try {
            driver.newTransaction().await()
            driver.execute(0, "INSERT INTO test VALUES (1, 'a')", 0).await()
            assertFailsWith<SQLiteJsException> { driver.closeSuspending() }

            driver._endTransactionForTests(false)?.await()
            driver.closeSuspending()
        } finally {
            deleteIfExists(file)
        }
    }
}

class Sqlite3DriverWithLibraryTest : DriverWithLibraryTest() {
    override suspend fun createDriver(filename: String, schema: SqlSchema<QueryResult.AsyncValue<Unit>>) =
        initSqlite3SqlDriver(filename, schema = schema)
}
