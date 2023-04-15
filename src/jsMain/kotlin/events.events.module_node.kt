@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package events

import kotlin.js.Promise

internal external interface EventEmitterOptions {
    var captureRejections: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

internal external interface NodeEventTarget {
    fun once(eventName: String, listener: (args: Any) -> Unit): NodeEventTarget /* this */
    fun once(eventName: Any, listener: (args: Any) -> Unit): NodeEventTarget /* this */
}

internal external interface `T$15` {
    var once: Boolean
}

internal external interface DOMEventTarget {
    fun addEventListener(eventName: String, listener: (args: Any) -> Unit, opts: `T$15` = definedExternally): Any
}

internal external interface StaticEventEmitterOptions {
    var signal: Any?
        get() = definedExternally
        set(value) = definedExternally
}

@JsModule("node:events")
internal open external class EventEmitter(options: EventEmitterOptions = definedExternally) {
    open fun addListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun addListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun on(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun on(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun once(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun once(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun removeListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun removeListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun off(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun off(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun removeAllListeners(event: String): dynamic /* EventEmitter */
    open fun removeAllListeners(): dynamic /* EventEmitter */
    open fun removeAllListeners(event: Any): dynamic /* EventEmitter */
    open fun setMaxListeners(n: Number): EventEmitter /* this */
    open fun getMaxListeners(): Number
    open fun listeners(eventName: String): Array<Function<*>>
    open fun listeners(eventName: Any): Array<Function<*>>
    open fun rawListeners(eventName: String): Array<Function<*>>
    open fun rawListeners(eventName: Any): Array<Function<*>>
    open fun emit(eventName: String, vararg args: Any): Boolean
    open fun emit(eventName: Any, vararg args: Any): Boolean
    open fun listenerCount(eventName: String): Number
    open fun listenerCount(eventName: Any): Number
    open fun prependListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun prependListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun prependOnceListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun prependOnceListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    open fun eventNames(): Array<dynamic /* String | Any */>
    interface Abortable {
        var signal: Any?
            get() = definedExternally
            set(value) = definedExternally
    }

    companion object {
        fun once(emitter: NodeEventTarget, eventName: String, options: StaticEventEmitterOptions = definedExternally): Promise<Array<Any>>
        fun once(emitter: NodeEventTarget, eventName: Any, options: StaticEventEmitterOptions = definedExternally): Promise<Array<Any>>
        fun once(emitter: DOMEventTarget, eventName: String, options: StaticEventEmitterOptions = definedExternally): Promise<Array<Any>>
//        fun on(emitter: events.global.NodeJS.EventEmitter, eventName: String, options: StaticEventEmitterOptions = definedExternally): AsyncIterableIterator<Any>
//        fun listenerCount(emitter: events.global.NodeJS.EventEmitter, eventName: String): Number
//        fun listenerCount(emitter: events.global.NodeJS.EventEmitter, eventName: Any): Number
//        fun getEventListeners(emitter: DOMEventTarget, name: String): Array<Function<*>>
//        fun getEventListeners(emitter: DOMEventTarget, name: Any): Array<Function<*>>
//        fun getEventListeners(emitter: events.global.NodeJS.EventEmitter, name: String): Array<Function<*>>
//        fun getEventListeners(emitter: events.global.NodeJS.EventEmitter, name: Any): Array<Function<*>>
        fun setMaxListeners(n: Number = definedExternally, vararg eventTargets: Any /* DOMEventTarget | NodeJS.EventEmitter */)
        var errorMonitor: Any
        var captureRejectionSymbol: Any
        var captureRejections: Boolean
        var defaultMaxListeners: Number
    }
}
