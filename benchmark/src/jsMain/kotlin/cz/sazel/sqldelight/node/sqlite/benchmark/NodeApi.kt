@file:Suppress("UnusedParameter")

package cz.sazel.sqldelight.node.sqlite.benchmark

const val BYTES_PER_MB = 1_048_576.0

external interface NodeProcess {
    val argv: Array<String>
    val execArgv: Array<String>
    val execPath: String
    val env: dynamic
    val version: String
    var exitCode: Int?
    fun cpuUsage(previous: CpuUsage = definedExternally): CpuUsage
    fun memoryUsage(): MemoryUsage
    fun cwd(): String
}

/** Microseconds. */
external interface CpuUsage {
    val user: Double
    val system: Double
}

/** Bytes. */
external interface MemoryUsage {
    val rss: Double
    val heapUsed: Double
    val external: Double
}

@JsName("process")
external val nodeProcess: NodeProcess

external fun setInterval(handler: () -> Unit, ms: Int): dynamic

external fun clearInterval(id: dynamic)

external interface Stats {
    val size: Double
}

@JsModule("node:fs")
external object NodeFs {
    fun existsSync(path: String): Boolean
    fun unlinkSync(path: String)
    fun mkdirSync(path: String, options: dynamic)
    fun writeFileSync(path: String, data: String)
    fun readFileSync(path: String, encoding: String): String
    fun statSync(path: String): Stats
}

@JsModule("node:child_process")
external object ChildProcess {
    fun spawnSync(command: String, args: Array<String>, options: dynamic): dynamic
}

/** Durations in nanoseconds. */
external interface EventLoopDelayHistogram {
    val max: Double
    fun percentile(percentile: Double): Double
    fun enable()
    fun disable()
    fun reset()
}

external interface EventLoopUtilization {
    /** Share of time the main thread was busy, 0..1. */
    val utilization: Double
}

external interface Performance {
    fun now(): Double
    fun eventLoopUtilization(previous: EventLoopUtilization = definedExternally): EventLoopUtilization
}

@JsModule("node:perf_hooks")
external object PerfHooks {
    val performance: Performance
    fun monitorEventLoopDelay(options: dynamic): EventLoopDelayHistogram
}

fun now(): Double = PerfHooks.performance.now()

fun deleteIfExists(path: String) {
    if (NodeFs.existsSync(path)) NodeFs.unlinkSync(path)
}
