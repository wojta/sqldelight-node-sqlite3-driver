package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult

private fun <T> jsObject(block: T.() -> Unit): T {
    val o = js("{}").unsafeCast<T>()
    block(o)
    return o
}

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
    if (query is QueryResult.AsyncValue<*>) {
        return (query as QueryResult.AsyncValue<List<T>>).await()
    } else throw IllegalArgumentException("Can be used only with async SQLite3 driver")
}
