package cz.sazel.sqldelight.node.sqlite

import cz.sazel.sqldelight.node.sqlite.externals.NodeSqlite
import cz.sazel.sqldelight.node.sqlite.externals.RowIterator

@OptIn(InternalSQLite3DriverApi::class)
internal class NodeSqliteConnection(private val db: NodeSqlite.DatabaseSync) : SQLite3Connection {

    override suspend fun prepare(sql: String): SQLite3Statement = NodeSqliteStatement(wrapJsErrors { db.prepare(sql) })

    override suspend fun exec(sql: String) = wrapJsErrors { db.exec(sql) }

    override suspend fun close() = wrapJsErrors { db.close() }
}

/**
 * node:sqlite has no separate bind step, parameters are kept and passed to each `run` / `iterate`.
 */
@OptIn(InternalSQLite3DriverApi::class)
@Suppress("SpreadOperator") // parameters go to a JS varargs API
internal class NodeSqliteStatement(private val statement: NodeSqlite.StatementSync) : SQLite3Statement {
    private var parameters: Array<Any?> = emptyArray()
    private var rows: RowIterator? = null

    init {
        statement.setReturnArrays(true)
        // integers beyond 2^53 would otherwise fail while stepping, the cursor checks the range on read
        statement.setReadBigInts(true)
    }

    override suspend fun bind(parameters: List<Any?>) {
        closeRows()
        this.parameters = parameters.withLongsAsBigInt()
    }

    override suspend fun run(): Long = wrapJsErrors {
        closeRows()
        statement.run(*parameters).changes.toString().toLong()
    }

    override suspend fun step(): Array<dynamic>? = wrapJsErrors {
        val rows = rows ?: statement.iterate(*parameters).also { rows = it }
        val next = rows.next()
        if (next.done) null else next.value
    }

    override suspend fun reset() = closeRows()

    override suspend fun finalize() = closeRows()

    private fun closeRows() {
        rows?.asDynamic()?.`return`()
        rows = null
    }
}
