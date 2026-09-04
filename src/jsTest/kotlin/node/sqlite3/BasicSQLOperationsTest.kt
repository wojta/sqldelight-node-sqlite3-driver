@file:OptIn(ExperimentalCoroutinesApi::class)

package node.sqlite3

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import cz.sazel.sqldelight.node.sqlite3.newDatabase
import cz.sazel.sqldelight.node.sqlite3.unlinkSync
import cz.sazel.sqldelight.node.sqlite3.openFlags
import cz.sazel.sqldelight.node.sqlite3.sqlite3Exports
import kotlin.test.Test

class BasicSQLOperationsTest {

    @Test
    fun testCreateDb() = runTest {

        val db: Sqlite3.Database = newDatabase(sqlite3Exports().Database, "test.db", openFlags())
        suspendCoroutine { cont ->
            db.run(
                """CREATE TABLE contacts (
                contact_id INTEGER PRIMARY KEY,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE,
                phone TEXT NOT NULL UNIQUE);""",
            ) {
                it?.let { cont.resumeWithException(it as Throwable) } ?: cont.resume(it)
            }
        }
        suspendCoroutine { cont ->
            db.run(
                "INSERT INTO contacts (contact_id,first_name,last_name,email,phone) " +
                        "VALUES (?,?,?,?,?)", js("[1, \"Petr\", \"Novak\", \"petr.novak@gmail.com\", \"1234\"]")
            ) {
                it?.let { cont.resumeWithException(it as Throwable) } ?: cont.resume(it)
            }
        }
        suspendCoroutine { cont ->
            db.run(
                "INSERT INTO contacts (contact_id,first_name,last_name,email,phone) " +
                        "VALUES (?,?,?,?,?)",
                listOf(2, "Pavel", "Novotny", "pavel.novotny@gmail.com", "5674").toTypedArray()
            ) {
                it?.let { cont.resumeWithException(it as Throwable) } ?: cont.resume(it)
            }
        }

        suspendCoroutine { cont ->
            db.close {
                it?.let {
                    cont.resumeWithException(it)
                } ?: cont.resume(Unit)
            }
        }

        unlinkSync("test.db")
    }
}
