package cz.sazel.sqldelight.node.sqlite3

import app.cash.sqldelight.Query
import app.cash.sqldelight.db.QueryResult
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.toList

/**
 * Workaround suspending method to use with SQLite3 async driver.
 * Use this instead of non-async method [Query.executeAsList].
 * @return The result set of the underlying SQL statement as a list of RowType.
 */
suspend fun <T : Any> Query<T>.executeSuspendingAsList(): List<T> =
    executeAsFlow().toList(mutableListOf())

/**
 * Workaround suspending method to use with SQLite3 async driver.
 * Use this instead of non-async method [Query.executeAsList].
 * @return The result set of the underlying SQL statement as a list of RowType.
 */
suspend fun <T : Any> Query<T>.executeAsFlow(): Flow<T> =
    coroutineScope {
        execute<Flow<T>> { cursor ->
            return@execute QueryResult.Value(callbackFlow {
                do {
                    val hasNext = cursor.next().await()
                    if (!hasNext) {
                        close()
                    } else {
                        val row = mapper(cursor)
                        send(row)
                    }
                } while (hasNext)
                awaitClose()
            })
        }.await()
    }

internal val <T> T?.nullable: T?
    get() = when (this) {
        null -> null
        undefined -> null
        else -> this
    }
