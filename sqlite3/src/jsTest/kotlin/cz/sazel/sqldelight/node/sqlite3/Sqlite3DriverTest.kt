@file:OptIn(InternalSQLite3DriverApi::class)

package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import cz.sazel.sqldelight.node.sqlite.InternalSQLite3DriverApi
import cz.sazel.sqldelight.node.sqlite.SQLite3JsException
import cz.sazel.sqldelight.node.sqlite.test.DriverWithLibraryTest
import cz.sazel.sqldelight.node.sqlite.test.SQLite3DriverTest
import cz.sazel.sqldelight.node.sqlite.test.deleteIfExists
import cz.sazel.sqldelight.node.sqlite.test.unlinkSync
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class Sqlite3DriverTest : SQLite3DriverTest() {
    override suspend fun createDriver(
        filename: String,
        schema: SqlSchema<QueryResult.AsyncValue<Unit>>?,
        beginImmediate: Boolean,
    ) = initSqlite3SqlDriver(filename, schema = schema, beginImmediate = beginImmediate)

    /**
     * Only an asynchronous backend can wait for the busy timeout while another connection
     * in the same process finishes its transaction.
     */
    @Test
    fun begin_immediate_waits_for_busy_timeout_instead_of_failing_on_lock_upgrade() = kotlinx.coroutines.test.runTest {
        val file = "test_begin_immediate.db"
        deleteIfExists(file)
        try {
            val driver1 = createDriver(file, beginImmediate = true)
            driver1.execute(0, "PRAGMA journal_mode=WAL", 0).await()
            driver1.execute(1, "PRAGMA busy_timeout=3000", 0).await()
            driver1.execute(2, "CREATE TABLE t (id INTEGER)", 0).await()

            val driver2 = createDriver(file, beginImmediate = true)
            driver2.execute(0, "PRAGMA busy_timeout=3000", 0).await()

            driver1.newTransaction().await()
            driver1.execute(3, "INSERT INTO t VALUES (1)", 0).await()

            val driver2Tx = async { driver2.newTransaction().await() }
            delay(100)
            driver1._endTransactionForTests(true)?.await()

            assertNotNull(driver2Tx.await())
            driver2._endTransactionForTests(true)?.await()

            driver1.close()
            driver2.close()
        } finally {
            unlinkSync(file)
        }
    }

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
            assertFailsWith<SQLite3JsException> { driver.closeSuspending() }

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
