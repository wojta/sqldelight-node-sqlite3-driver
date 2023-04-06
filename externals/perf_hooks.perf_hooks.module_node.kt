@file:JsModule("perf_hooks")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package perf_hooks

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import async_hooks.AsyncResource
import tsstdlib.Map

external interface NodeGCPerformanceDetail {
    var kind: Number?
        get() = definedExternally
        set(value) = definedExternally
    var flags: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class PerformanceEntry {
    open var duration: Number
    open var name: String
    open var startTime: Number
    open var entryType: String /* "node" | "mark" | "measure" | "gc" | "function" | "http2" | "http" */
    open var detail: dynamic /* NodeGCPerformanceDetail? | Any? */
}

external open class PerformanceNodeTiming : PerformanceEntry {
    open var bootstrapComplete: Number
    open var environment: Number
    open var idleTime: Number
    open var loopExit: Number
    open var loopStart: Number
    open var v8Start: Number
}

external interface EventLoopUtilization {
    var idle: Number
    var active: Number
    var utilization: Number
}

external interface MarkOptions {
    var detail: Any?
        get() = definedExternally
        set(value) = definedExternally
    var startTime: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MeasureOptions {
    var detail: Any?
        get() = definedExternally
        set(value) = definedExternally
    var duration: Number?
        get() = definedExternally
        set(value) = definedExternally
    var end: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var start: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface TimerifyOptions {
    var histogram: RecordableHistogram?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Performance {
    fun clearMarks(name: String = definedExternally)
    fun mark(name: String = definedExternally, options: MarkOptions = definedExternally)
    fun measure(name: String, startMark: String = definedExternally, endMark: String = definedExternally)
    fun measure(name: String)
    fun measure(name: String, startMark: String = definedExternally)
    fun measure(name: String, options: MeasureOptions)
    var nodeTiming: PerformanceNodeTiming
    fun now(): Number
    var timeOrigin: Number
    fun <T : (params: Any) -> Any> timerify(fn: T, options: TimerifyOptions = definedExternally): T
    var eventLoopUtilization: EventLoopUtilityFunction
}

external interface PerformanceObserverEntryList {
    fun getEntries(): Array<PerformanceEntry>
    fun getEntriesByName(name: String, type: String /* "node" | "mark" | "measure" | "gc" | "function" | "http2" | "http" */ = definedExternally): Array<PerformanceEntry>
    fun getEntriesByType(type: String /* "node" | "mark" | "measure" | "gc" | "function" | "http2" | "http" */): Array<PerformanceEntry>
}

external interface `T$23` {
    var entryTypes: Array<String /* "node" | "mark" | "measure" | "gc" | "function" | "http2" | "http" */>
    var buffered: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$24` {
    var type: String /* "node" | "mark" | "measure" | "gc" | "function" | "http2" | "http" */
    var buffered: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class PerformanceObserver(callback: PerformanceObserverCallback) : AsyncResource {
    open fun disconnect()
    open fun observe(options: `T$23`)
    open fun observe(options: `T$24`)
}

external var performance: Performance

external interface EventLoopMonitorOptions {
    var resolution: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Histogram {
    var percentiles: Map<Number, Number>
    var exceeds: Number
    var min: Number
    var max: Number
    var mean: Number
    var stddev: Number
    fun reset()
    fun percentile(percentile: Number): Number
}

external interface IntervalHistogram : Histogram {
    fun enable(): Boolean
    fun disable(): Boolean
}

external interface RecordableHistogram : Histogram {
    fun record(param_val: Number)
    fun record(param_val: Any)
    fun recordDelta()
}

external fun monitorEventLoopDelay(options: EventLoopMonitorOptions = definedExternally): IntervalHistogram

external interface CreateHistogramOptions {
    var min: dynamic /* Number? | Any? */
        get() = definedExternally
        set(value) = definedExternally
    var max: dynamic /* Number? | Any? */
        get() = definedExternally
        set(value) = definedExternally
    var figures: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun createHistogram(options: CreateHistogramOptions = definedExternally): RecordableHistogram