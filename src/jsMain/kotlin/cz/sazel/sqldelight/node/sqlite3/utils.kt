package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Above this magnitude a [Long] no longer round-trips exactly through the JS `Number` bridge
 * that binding and reading both go through, see README's "Limitations" section.
 */
internal const val MAX_SAFE_LONG: Long = 1L shl 53

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
