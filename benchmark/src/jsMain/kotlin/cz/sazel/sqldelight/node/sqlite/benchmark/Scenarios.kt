package cz.sazel.sqldelight.node.sqlite.benchmark

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import cz.sazel.sqldelight.node.sqlite.benchmark.db.BenchmarkDatabase
import cz.sazel.sqldelight.node.sqlite.benchmark.db.Item
import cz.sazel.sqldelight.node.sqlite.executeAsFlow
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

private const val SEED = 42
private const val CATEGORIES = 1_000
private const val CODE_DIGITS = 7
private const val LOOKUPS = 10_000
private const val WARM_UP = 100
private const val PARALLEL_WRITES = 1_000
private const val PARALLEL_LOOKUPS = 10_000
private const val MS_PER_SECOND = 1_000.0
private const val PERCENT = 100.0
private const val P50 = 0.5
private const val P99 = 0.99
@Suppress("MagicNumber")
private val SIZES = listOf(100, 1_000, 10_000, 100_000)

@Suppress("MagicNumber")
private val CONCURRENCY = listOf(1, 4, 16, 64)

/** Runs all scenarios on one open database, [itemCount] rows go to `item`. */
class Scenarios(private val database: BenchmarkDatabase, private val report: Report, private val itemCount: Int) {
    private val queries = database.itemQueries
    private val random = Random(SEED)
    private val sizes = SIZES.filter { it <= itemCount }

    suspend fun createDatabase(openMs: Double, filename: String) {
        val scenario = "1. create DB with $itemCount rows"
        val insertMs = measure {
            database.transaction {
                repeat(itemCount) { insertRow(it, target = false) }
            }
        }
        check(queries.countItems().awaitAsOne() == itemCount.toLong()) { "item count mismatch" }
        report.add(scenario, "open + schema", openMs, "ms")
        report.add(scenario, "insert in one transaction", insertMs, "ms")
        report.add(scenario, "insert rate", itemCount / insertMs * MS_PER_SECOND, "rows/s")
        report.add(scenario, "file size", NodeFs.statSync(filename).size / BYTES_PER_MB, "MB")
    }

    suspend fun indexedLookup() {
        val scenario = "2. select by indexed code"
        repeat(WARM_UP) { lookupRandom() }
        val latencies = DoubleArray(LOOKUPS)
        val totalMs = measure {
            repeat(LOOKUPS) { latencies[it] = measure { lookupRandom() } }
        }
        latencies.sort()
        report.add(scenario, "$LOOKUPS lookups", totalMs, "ms")
        report.add(scenario, "rate", LOOKUPS / totalMs * MS_PER_SECOND, "ops/s")
        report.add(scenario, "latency p50", latencies[(LOOKUPS * P50).toInt()], "ms")
        report.add(scenario, "latency p99", latencies[(LOOKUPS * P99).toInt()], "ms")
    }

    suspend fun rangeSelect() {
        val scenario = "3. select N rows and crawl them"
        crawlList(WARM_UP)
        crawlFlow(WARM_UP)
        crawlCursor(WARM_UP)
        sizes.forEach { size ->
            report.add(scenario, "awaitAsList $size rows", measure { crawlList(size) }, "ms")
            report.add(scenario, "executeAsFlow $size rows", measure { crawlFlow(size) }, "ms")
            report.add(scenario, "raw cursor $size rows", measure { crawlCursor(size) }, "ms")
        }
    }

    suspend fun batchInsert() {
        val scenario = "4. insert N rows in one transaction"
        insertTargetBatch(WARM_UP)
        sizes.forEach { size ->
            report.add(scenario, "insert $size rows", measure { insertTargetBatch(size) }, "ms")
        }
    }

    /**
     * Autocommit inserts, each its own transaction. `SQLiteDriver` tracks one current transaction,
     * so concurrent `transaction {}` blocks on one driver would interleave.
     */
    suspend fun parallelWrite() {
        val scenario = "5. parallel write of $PARALLEL_WRITES rows from coroutines"
        queries.clearTarget()
        val monitor = ResourceMonitor()
        monitor.start()
        val totalMs = measure {
            coroutineScope {
                repeat(PARALLEL_WRITES) { launch { insertRow(it, target = true) } }
            }
        }
        monitor.stop(report, scenario)
        check(queries.countTarget().awaitAsOne() == PARALLEL_WRITES.toLong()) { "target count mismatch" }
        report.add(scenario, "total", totalMs, "ms")
        report.add(scenario, "rate", PARALLEL_WRITES / totalMs * MS_PER_SECOND, "rows/s")
    }

    /**
     * Same lookups as [indexedLookup], spread over concurrent coroutines. Rate going flat while the main
     * thread isn't busy means the single connection is the limit and more reader threads could help.
     */
    suspend fun parallelReads() {
        val scenario = "6. $PARALLEL_LOOKUPS lookups from N coroutines"
        CONCURRENCY.forEach { coroutines ->
            val perCoroutine = PARALLEL_LOOKUPS / coroutines
            val startCpu = nodeProcess.cpuUsage()
            val startLoop = PerfHooks.performance.eventLoopUtilization()
            val totalMs = measure {
                coroutineScope {
                    repeat(coroutines) { launch { repeat(perCoroutine) { lookupRandom() } } }
                }
            }
            val cpu = nodeProcess.cpuUsage(startCpu)
            val mainBusy = PerfHooks.performance.eventLoopUtilization(startLoop).utilization * PERCENT
            val rate = perCoroutine * coroutines / totalMs * MS_PER_SECOND
            report.add(scenario, "$coroutines coroutines rate", rate, "ops/s")
            report.add(scenario, "$coroutines coroutines CPU avg", cpuPercent(cpu, totalMs), "%")
            report.add(scenario, "$coroutines coroutines main thread busy", mainBusy, "%")
        }
    }

    private suspend fun lookupRandom() {
        val code = code(random.nextInt(itemCount))
        checkNotNull(queries.selectByCode(code).awaitAsOneOrNull()) { "$code not found" }
    }

    private suspend fun crawlList(size: Int) {
        var count = 0
        var checksum = 0.0
        queries.selectFrom(randomStart(size), size.toLong()).awaitAsList().forEach {
            count++
            checksum += it.touch()
        }
        checkCrawled(size, count, checksum)
    }

    private suspend fun crawlFlow(size: Int) {
        var count = 0
        var checksum = 0.0
        queries.selectFrom(randomStart(size), size.toLong()).executeAsFlow().collect {
            count++
            checksum += it.touch()
        }
        checkCrawled(size, count, checksum)
    }

    /** Reads columns from the cursor directly, no row objects. */
    private suspend fun crawlCursor(size: Int) {
        var count = 0
        var checksum = 0.0
        queries.selectFrom(randomStart(size), size.toLong()).execute { cursor ->
            QueryResult.AsyncValue {
                while (cursor.next().await()) {
                    count++
                    checksum += cursor.touch()
                }
            }
        }.await()
        checkCrawled(size, count, checksum)
    }

    private fun checkCrawled(size: Int, count: Int, checksum: Double) =
        check(count == size && checksum > 0) { "crawled $count of $size rows" }

    private suspend fun insertTargetBatch(size: Int) {
        queries.clearTarget()
        database.transaction {
            repeat(size) { insertRow(it, target = true) }
        }
        check(queries.countTarget().awaitAsOne() == size.toLong()) { "target count mismatch" }
    }

    private suspend fun insertRow(index: Int, target: Boolean) {
        val id = index.toLong()
        val category = (index % CATEGORIES).toLong()
        val name = "name $index"
        val amount = random.nextDouble()
        if (target) {
            queries.insertTarget(id, code(index), category, name, amount)
        } else {
            queries.insertItem(id, code(index), category, name, amount)
        }
    }

    private fun randomStart(size: Int) = random.nextInt(itemCount - size + 1).toLong()

}

private fun code(index: Int) = "item-" + index.toString().padStart(CODE_DIGITS, '0')

private fun Item.touch() = id + category + name.length + code.length + amount

@Suppress("MagicNumber")
private fun SqlCursor.touch(): Double {
    val id = getLong(0) ?: 0L
    val code = getString(1).orEmpty()
    val category = getLong(2) ?: 0L
    val name = getString(3).orEmpty()
    val amount = getDouble(4) ?: 0.0
    return id + category + name.length + code.length + amount
}

private inline fun measure(block: () -> Unit): Double {
    val start = now()
    block()
    return now() - start
}
