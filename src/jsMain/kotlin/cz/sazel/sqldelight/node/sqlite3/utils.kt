package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult

/**
 * Workaround suspending method to use with SQLite3 async driver.
 * Use this instead of non-async method [Query.executeAsList].
 * @return The result set of the underlying SQL statement as a list of RowType.
 */
suspend fun <T : Any> Query<T>.executeSuspendingAsList(): List<T> {
    val query = execute { cursor ->
        val result = mutableListOf<T>()
        while (cursor.next()) result.add(mapper(cursor))
        result
    }
    require(query is QueryResult.AsyncValue<*>) { "Can be used only with async SQLite3 driver" }
    return (query as QueryResult.AsyncValue<List<T>>).await()
}


internal val <T> T?.nullable: T?
    get() = when (this) {
        null -> null
        undefined -> null
        else -> this
    }
