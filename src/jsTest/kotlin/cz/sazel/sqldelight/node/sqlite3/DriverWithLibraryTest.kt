package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.async.coroutines.awaitAsList
import cz.sazel.sqldelight.dontuse.HockeyPlayer
import cz.sazel.sqldelight.dontuse.TestDataBaseDontUseQueries
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

typealias Database = cz.sazel.sqldelight._dont_use.TestDatabaseDontUse

class DriverWithLibraryTest {

    private lateinit var driver: SQLite3Driver
    private lateinit var playerQueries: TestDataBaseDontUseQueries
    private val dbName = "driver_test.db"

    private fun withDatabase(fn: suspend Database.() -> Unit) = runTest {
        val dbName = this@DriverWithLibraryTest.dbName
        js("var fs=require('fs'); if(fs.existsSync(dbName)) fs.unlinkSync(dbName)")
        try {
            driver = initSqlite3SqlDriver(filename = "driver_test.db", schema = Database.Schema)
            val database = Database(driver)
            playerQueries = database.testDataBaseDontUseQueries
            database.fn()
        } finally {
            js("require('fs').unlinkSync(dbName)")
        }
    }

    @Test
    fun testInitialContents() = withDatabase {
        playerQueries.selectAll().awaitAsList().let {
            assertEquals(initialPlayer, it.first())
            assertEquals(1, it.size)
        }
    }

    @Test
    fun testInsert() = withDatabase {
        val insertedPlayer = HockeyPlayer(player_number = 8, full_name = "Teemu Selanne")
        transaction {
            playerQueries.insertFullPlayerObject(insertedPlayer)
        }
        playerQueries.selectAll().awaitAsList().let {
            assertContains(it, initialPlayer)
            assertContains(it, insertedPlayer)
            assertEquals(2, it.size)
        }
    }

    @Test
    fun testInsertWithCancelledTransaction() = withDatabase {
        val insertedPlayer = HockeyPlayer(player_number = 18, full_name = "Saku Koivu")
        try {
            transaction {
                playerQueries.insertFullPlayerObject(insertedPlayer)
                error("Rollback")
            }
        } catch (e: Exception) {
            // do nothing
        } finally {
            playerQueries.selectAll().awaitAsList().let {
                assertContains(it, initialPlayer)
                assertEquals(1, it.size)
            }
        }
    }

    @Test
    fun testMultipleInsertsAndPartialCursorRead() = withDatabase {
        val insertedPlayers = (0..10).map { HockeyPlayer(player_number = 100L + it, full_name = "Player $it") }
        transaction {
            insertedPlayers.forEach {
                playerQueries.insertFullPlayerObject(it)
            }
        }
        playerQueries.selectAll().awaitAsList().take(4).let {
            println(it)
            assertContains(it, initialPlayer)
            assertEquals(4, it.size)
        }
    }

    @Test
    fun testUpdate() = withDatabase {
        val updatedPlayer = initialPlayer.copy(full_name = "Petr Sykora")
        transaction {
            playerQueries.updateName(updatedPlayer.full_name, initialPlayer.player_number)
        }
        playerQueries.selectAll().awaitAsList().let {
            assertContains(it, updatedPlayer)
            assertEquals(1, it.size)
        }
    }

    @Test
    fun testDelete() = withDatabase {
        transaction {
            playerQueries.deletePlayer(initialPlayer.player_number)
        }
        playerQueries.selectAll().awaitAsList().let {
            assertEquals(0, it.size)
        }
    }

    @Test
    fun testSelectWithLimit() = withDatabase {
        val insertedPlayers = (0..100).map { HockeyPlayer(player_number = 100L + it, full_name = "Player $it") }
        transaction {
            insertedPlayers.forEach {
                playerQueries.insertFullPlayerObject(it)
            }
        }
        val list1 = playerQueries.selectWithLimit(0, 50).awaitAsList()
        println(list1.size)
        val list2 = playerQueries.selectWithLimit(50, 99).awaitAsList()
        println(list2.size)
        val list3 = playerQueries.selectAll().awaitAsList()
        println(list3.size)
    }

    private companion object {
        val initialPlayer = HockeyPlayer(player_number = 15, full_name = "Ryan Getzlaf")
    }
}
