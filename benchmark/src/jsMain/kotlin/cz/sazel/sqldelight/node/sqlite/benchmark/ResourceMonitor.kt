package cz.sazel.sqldelight.node.sqlite.benchmark

import kotlin.js.json

private const val SAMPLE_INTERVAL_MS = 50
private const val HISTOGRAM_RESOLUTION_MS = 10
private const val MICROS_PER_MS = 1_000.0
private const val NANOS_PER_MS = 1_000_000.0
private const val PERCENT = 100.0
private const val P99 = 99.0

/**
 * Samples CPU and memory of the whole process. `process.cpuUsage()` counts all threads,
 * worker and libuv ones too, so CPU can exceed 100 %.
 */
class ResourceMonitor {
    private val loopDelay = PerfHooks.monitorEventLoopDelay(json("resolution" to HISTOGRAM_RESOLUTION_MS))
    private var timer: dynamic = null
    private lateinit var startCpu: CpuUsage
    private lateinit var lastCpu: CpuUsage
    private var startTime = 0.0
    private var lastTime = 0.0
    private var startRss = 0.0
    private var peakCpu = 0.0
    private var peakRss = 0.0
    private var peakHeap = 0.0
    private var peakExternal = 0.0

    fun start() {
        startRss = nodeProcess.memoryUsage().rss
        startCpu = nodeProcess.cpuUsage()
        lastCpu = startCpu
        startTime = now()
        lastTime = startTime
        loopDelay.reset()
        loopDelay.enable()
        timer = setInterval(::sample, SAMPLE_INTERVAL_MS)
    }

    fun stop(report: Report, scenario: String) {
        sample()
        clearInterval(timer)
        loopDelay.disable()
        val cpu = nodeProcess.cpuUsage(startCpu)
        report.add(scenario, "CPU avg", cpuPercent(cpu, now() - startTime), "%")
        report.add(scenario, "CPU peak", peakCpu, "%")
        report.add(scenario, "RSS start", startRss / BYTES_PER_MB, "MB")
        report.add(scenario, "RSS peak", peakRss / BYTES_PER_MB, "MB")
        report.add(scenario, "heap used peak", peakHeap / BYTES_PER_MB, "MB")
        report.add(scenario, "external peak", peakExternal / BYTES_PER_MB, "MB")
        report.add(scenario, "event loop delay p99", loopDelay.percentile(P99) / NANOS_PER_MS, "ms")
        report.add(scenario, "event loop delay max", loopDelay.max / NANOS_PER_MS, "ms")
    }

    private fun sample() {
        val time = now()
        if (time > lastTime) {
            peakCpu = maxOf(peakCpu, cpuPercent(nodeProcess.cpuUsage(lastCpu), time - lastTime))
        }
        lastCpu = nodeProcess.cpuUsage()
        lastTime = time
        val memory = nodeProcess.memoryUsage()
        peakRss = maxOf(peakRss, memory.rss)
        peakHeap = maxOf(peakHeap, memory.heapUsed)
        peakExternal = maxOf(peakExternal, memory.external)
    }
}

fun cpuPercent(cpu: CpuUsage, wallMs: Double) = (cpu.user + cpu.system) / MICROS_PER_MS / wallMs * PERCENT
