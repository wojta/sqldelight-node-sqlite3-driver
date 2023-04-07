@file:OptIn(ExperimentalCoroutinesApi::class)

package node.sqlite3

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.w3c.files.File
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.test.Test

class BasicSQLOperationsTest {

    @Test
    fun testCreateDb() = runTest {

        val x =Sqlite3
        val db: Sqlite3.Database = Sqlite3.Database("test.db", mode = Sqlite3.OPEN_CREATE.toInt() or Sqlite3.OPEN_READWRITE.toInt())
        val res = suspendCoroutine { cont ->
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
        val statement = suspendCoroutine { cont ->
            db.run(
                "INSERT INTO contacts (contact_id,first_name,last_name,email,phone) " +
                        "VALUES (?,?,?,?,?)", js("[1, \"Petr\", \"Novak\", \"petr.novak@gmail.com\", \"1234\"]")
            ) {
                it?.let { cont.resumeWithException(it as Throwable) } ?: cont.resume(it)
            }
        }
        val statement2 = suspendCoroutine { cont ->
            db.run(
                "INSERT INTO contacts (contact_id,first_name,last_name,email,phone) " +
                        "VALUES (?,?,?,?,?)", listOf(2, "Pavel", "Novotny", "pavel.novotny@gmail.com", "5674").toTypedArray()
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

        js("require('fs').unlinkSync('test.db')")
    }
}
