package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList

/**
 * Workaround suspending method to use with SQLite3 async driver.
 * Use this instead of non-async method [Query.executeAsList].
 * @return The result set of the underlying SQL statement as a list of RowType.
 */
@Deprecated(
    "Use awaitAsList() instead, will be removed in 0.7",
    ReplaceWith("awaitAsList()", "app.cash.sqldelight.async.coroutines.awaitAsList")
)
suspend fun <T : Any> Query<T>.executeSuspendingAsList(): List<T> =
    executeAsFlow().toList()

/**
 * Workaround suspending method to use with SQLite3 async driver.
 * Use this instead of non-async method [Query.executeAsList].
 * @return The result set of the underlying SQL statement as a list of RowType.
 */
suspend fun <T : Any> Query<T>.executeAsFlow(): Flow<T> = flow {
    execute { cursor ->
        QueryResult.AsyncValue {
            while (cursor.next().await()) {
                emit(mapper(cursor))
            }
        }
    }.await()
}
