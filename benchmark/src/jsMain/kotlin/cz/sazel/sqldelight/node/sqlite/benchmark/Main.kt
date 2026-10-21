package cz.sazel.sqldelight.node.sqlite.benchmark

import cz.sazel.sqldelight.node.sqlite.benchmark.db.BenchmarkDatabase
import kotlin.js.Date
import kotlin.js.json

private const val DEFAULT_ROWS = 1_000_000

private val outDir: String = nodeProcess.env.BENCH_OUT.unsafeCast<String?>() ?: "${nodeProcess.cwd()}/benchmark-out"
private val rows: Int = nodeProcess.env.BENCH_ROWS.unsafeCast<String?>()?.toIntOrNull() ?: DEFAULT_ROWS

/** Without arguments runs every backend in its own Node.js process, with a backend id runs only that one. */
suspend fun main() {
    NodeFs.mkdirSync(outDir, json("recursive" to true))
    val backendId = nodeProcess.argv.getOrNull(2)
    if (backendId == null) runAll() else runBackend(Backend.entries.first { it.id == backendId })
}

private fun runAll() {
    val selected = nodeProcess.env.BENCH_BACKENDS.unsafeCast<String?>()?.split(",")?.map { it.trim() }
    val backends = Backend.entries.filter { selected == null || it.id in selected }
    println("Node.js ${nodeProcess.version}, $rows rows, output $outDir")

    val results = linkedMapOf<String, List<Metric>>()
    backends.forEach { backend ->
        println("\n=== ${backend.id} ===")
        val args = nodeProcess.execArgv.toList() + listOf(nodeProcess.argv[1], backend.id)
        val child = ChildProcess.spawnSync(nodeProcess.execPath, args.toTypedArray(), json("stdio" to "inherit"))
        if (child.status == 0) {
            results[backend.id] = readMetrics(metricsFile(backend.id))
        } else {
            println("${backend.id} failed with status ${child.status}")
            nodeProcess.exitCode = 1
        }
    }
    if (results.isEmpty()) return

    printComparison(results)
    val backendsJson = json()
    results.keys.forEach { backendsJson[it] = JSON.parse<Any>(NodeFs.readFileSync(metricsFile(it), "utf8")) }
    val summary = json("node" to nodeProcess.version, "rows" to rows, "timestamp" to Date().toISOString(),
        "backends" to backendsJson)
    NodeFs.writeFileSync("$outDir/results.json", JSON.stringify(summary, null, 2))
    println("\nResults written to $outDir/results.json")
}

private suspend fun runBackend(backend: Backend) {
    val filename = "$outDir/${backend.id}.db"
    deleteDatabase(filename)
    val report = Report()
    val start = now()
    val driver = backend.open(filename)
    val openMs = now() - start
    try {
        Scenarios(BenchmarkDatabase(driver), report, rows).apply {
            createDatabase(openMs, filename)
            indexedLookup()
            rangeSelect()
            batchInsert()
            parallelWrite()
            parallelReads()
        }
    } finally {
        driver.closeSuspending()
        deleteDatabase(filename)
    }
    report.writeJson(metricsFile(backend.id))
}

private fun metricsFile(id: String) = "$outDir/$id.json"

private fun deleteDatabase(filename: String) =
    listOf(filename, "$filename-wal", "$filename-shm").forEach(::deleteIfExists)
