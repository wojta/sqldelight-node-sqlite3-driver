package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor

/**
 * Workaround suspending method to use with SQLite3 async driver.
 * Use this instead of non-async method [Query.executeAsList].
 * @return The result set of the underlying SQL statement as a list of RowType.
 */
suspend fun <T : Any> Query<T>.executeSuspendingAsList(): List<T> {
    val list = execute<List<T>> { cursor ->
        QueryResult.AsyncValue {
            val result = mutableListOf<T>()
            while (cursor.next().await()) result.add(mapper(cursor))
            result
        }
    }.await()
    return list
}

/**
 * Function that must be used only with [SQLite3Cursor], used to close cursor when no longer used.
 */
suspend fun SqlCursor.close() {
    require(this is SQLite3Cursor)
    _close()
}

internal val <T> T?.nullable: T?
    get() = when (this) {
        null -> null
        undefined -> null
        else -> this
    }
