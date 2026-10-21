package cz.sazel.sqldelight.node.sqlite.benchmark

import cz.sazel.sqldelight.node.sqlite.SQLiteDriver
import cz.sazel.sqldelight.node.sqlite.benchmark.db.BenchmarkDatabase
import cz.sazel.sqldelight.node.sqlite.betterSqlite3.initBetterSqlite3SqlDriver
import cz.sazel.sqldelight.node.sqlite.initNodeSqliteSqlDriver
import cz.sazel.sqldelight.node.sqlite3.initSqlite3SqlDriver

private const val READERS = 2

/** `-2r` variants add [READERS] reader connections, which also switches the database to WAL. */
enum class Backend(val id: String, val open: suspend (filename: String) -> SQLiteDriver) {
    NODE_SQLITE("node-sqlite", { initNodeSqliteSqlDriver(it, schema = BenchmarkDatabase.Schema) }),
    NODE_SQLITE_READERS("node-sqlite-${READERS}r", {
        initNodeSqliteSqlDriver(it, schema = BenchmarkDatabase.Schema, readers = READERS)
    }),
    BETTER_SQLITE3("better-sqlite3", { initBetterSqlite3SqlDriver(it, schema = BenchmarkDatabase.Schema) }),
    BETTER_SQLITE3_READERS("better-sqlite3-${READERS}r", {
        initBetterSqlite3SqlDriver(it, schema = BenchmarkDatabase.Schema, readers = READERS)
    }),
    SQLITE3("sqlite3", { initSqlite3SqlDriver(it, schema = BenchmarkDatabase.Schema) }),
}
