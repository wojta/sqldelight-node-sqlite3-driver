@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package tsstdlib

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
import url.URL as _URL
import url.URLSearchParams as _URLSearchParams

external interface PipeOptions {
    var preventAbort: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var preventCancel: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var preventClose: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var signal: AbortSignal?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueuingStrategy<T> {
    var highWaterMark: Number?
        get() = definedExternally
        set(value) = definedExternally
    var size: QueuingStrategySizeCallback<T>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadableStreamReadDoneResult<T> {
    var done: Boolean
    var value: T?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadableStreamReadValueResult<T> {
    var done: Boolean
    var value: T
}

external interface UnderlyingByteSource {
    var autoAllocateChunkSize: Number?
        get() = definedExternally
        set(value) = definedExternally
    var cancel: ReadableStreamErrorCallback?
        get() = definedExternally
        set(value) = definedExternally
    var pull: ReadableByteStreamControllerCallback?
        get() = definedExternally
        set(value) = definedExternally
    var start: ReadableByteStreamControllerCallback?
        get() = definedExternally
        set(value) = definedExternally
    var type: String /* "bytes" */
}

external interface UnderlyingSink<W> {
    var abort: WritableStreamErrorCallback?
        get() = definedExternally
        set(value) = definedExternally
    var close: WritableStreamDefaultControllerCloseCallback?
        get() = definedExternally
        set(value) = definedExternally
    var start: WritableStreamDefaultControllerStartCallback?
        get() = definedExternally
        set(value) = definedExternally
    var type: Any?
        get() = definedExternally
        set(value) = definedExternally
    var write: WritableStreamDefaultControllerWriteCallback<W>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UnderlyingSource<R> {
    var cancel: ReadableStreamErrorCallback?
        get() = definedExternally
        set(value) = definedExternally
    var pull: ReadableStreamDefaultControllerCallback<R>?
        get() = definedExternally
        set(value) = definedExternally
    var start: ReadableStreamDefaultControllerCallback<R>?
        get() = definedExternally
        set(value) = definedExternally
    var type: Any?
        get() = definedExternally
        set(value) = definedExternally
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface AbortController {
    var signal: AbortSignal
    fun abort()

    companion object {
        var prototype: AbortController
    }
}

external interface AbortSignalEventMap {
    var abort: Event
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface AbortSignal : EventTarget {
    var aborted: Boolean
    var onabort: ((self: AbortSignal, ev: Event) -> Any)?
    fun <K : String> addEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> addEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any)
    fun <K : String> addEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: Boolean)
    fun addEventListener(type: String, listener: EventListener)
    override fun addEventListener(type: String, listener: EventListener?)
    fun addEventListener(type: String, listener: EventListener, options: AddEventListenerOptions = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: AddEventListenerOptions)
    fun addEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    override fun addEventListener(type: String, listener: EventListenerObject?, options: Boolean)
    fun addEventListener(type: String, listener: EventListenerObject)
    override fun addEventListener(type: String, listener: EventListenerObject?)
    fun addEventListener(type: String, listener: EventListenerObject, options: AddEventListenerOptions = definedExternally)
    override fun addEventListener(type: String, listener: EventListenerObject?, options: AddEventListenerOptions)
    fun <K : String> removeEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> removeEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any)
    fun <K : String> removeEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListener)
    override fun removeEventListener(type: String, callback: EventListener?)
    fun removeEventListener(type: String, listener: EventListener, options: EventListenerOptions = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: EventListenerOptions)
    fun removeEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    override fun removeEventListener(type: String, callback: EventListenerObject?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListenerObject)
    override fun removeEventListener(type: String, callback: EventListenerObject?)
    fun removeEventListener(type: String, listener: EventListenerObject, options: EventListenerOptions = definedExternally)
    override fun removeEventListener(type: String, callback: EventListenerObject?, options: EventListenerOptions)

    companion object {
        var prototype: AbortSignal
    }
}

external interface EventListenerObject {
    fun handleEvent(evt: Event)
}

external interface ReadableByteStreamController {
    var byobRequest: ReadableStreamBYOBRequest?
    var desiredSize: Number?
    fun close()
    fun enqueue(chunk: ArrayBufferView)
    fun error(error: Any = definedExternally)
}

external interface `T$17` {
    var mode: String /* "byob" */
}

external interface `T$18`<R, T> {
    var writable: WritableStream<R>
    var readable: ReadableStream<T>
}

external interface ReadableStream<R> {
    var locked: Boolean
    fun cancel(reason: Any = definedExternally): Promise<Unit>
    fun getReader(options: `T$17`): ReadableStreamBYOBReader
    fun getReader(): ReadableStreamDefaultReader<R>
    fun <T> pipeThrough(__0: `T$18`<R, T>, options: PipeOptions = definedExternally): ReadableStream<T>
    fun pipeTo(dest: WritableStream<R>, options: PipeOptions = definedExternally): Promise<Unit>
    fun tee(): dynamic /* JsTuple<ReadableStream<R>, ReadableStream<R>> */
}

external interface ReadableStream__0 : ReadableStream<Any>

external interface ReadableStreamBYOBReader {
    var closed: Promise<Unit>
    fun cancel(reason: Any = definedExternally): Promise<Unit>
    fun <T : ArrayBufferView> read(view: T): Promise<dynamic /* ReadableStreamReadValueResult<T> | ReadableStreamReadDoneResult<T> */>
    fun releaseLock()
}

external interface ReadableStreamBYOBRequest {
    var view: ArrayBufferView
    fun respond(bytesWritten: Number)
    fun respondWithNewView(view: ArrayBufferView)
}

external interface ReadableStreamDefaultController<R> {
    var desiredSize: Number?
    fun close()
    fun enqueue(chunk: R)
    fun error(error: Any = definedExternally)
}

external interface ReadableStreamDefaultReader<R> {
    var closed: Promise<Unit>
    fun cancel(reason: Any = definedExternally): Promise<Unit>
    fun read(): Promise<dynamic /* ReadableStreamReadValueResult<R> | ReadableStreamReadDoneResult<R> */>
    fun releaseLock()
}

external interface WritableStream<W> {
    var locked: Boolean
    fun abort(reason: Any = definedExternally): Promise<Unit>
    fun getWriter(): WritableStreamDefaultWriter<W>
}

external interface WritableStreamDefaultController {
    fun error(error: Any = definedExternally)
}

external interface WritableStreamDefaultWriter<W> {
    var closed: Promise<Unit>
    var desiredSize: Number?
    var ready: Promise<Unit>
    fun abort(reason: Any = definedExternally): Promise<Unit>
    fun close(): Promise<Unit>
    fun releaseLock()
    fun write(chunk: W): Promise<Unit>
}

external interface QueuingStrategySizeCallback<T> {
    @nativeInvoke
    operator fun invoke(chunk: T): Number
}

external interface ReadableByteStreamControllerCallback {
    @nativeInvoke
    operator fun invoke(controller: ReadableByteStreamController): dynamic /* Unit | PromiseLike<Unit> */
}

external interface ReadableStreamDefaultControllerCallback<R> {
    @nativeInvoke
    operator fun invoke(controller: ReadableStreamDefaultController<R>): dynamic /* Unit | PromiseLike<Unit> */
}

external interface ReadableStreamErrorCallback {
    @nativeInvoke
    operator fun invoke(reason: Any): dynamic /* Unit | PromiseLike<Unit> */
}

external interface WritableStreamDefaultControllerCloseCallback {
    @nativeInvoke
    operator fun invoke(): dynamic /* Unit | PromiseLike<Unit> */
}

external interface WritableStreamDefaultControllerStartCallback {
    @nativeInvoke
    operator fun invoke(controller: WritableStreamDefaultController): dynamic /* Unit | PromiseLike<Unit> */
}

external interface WritableStreamDefaultControllerWriteCallback<W> {
    @nativeInvoke
    operator fun invoke(chunk: W, controller: WritableStreamDefaultController): dynamic /* Unit | PromiseLike<Unit> */
}

external interface WritableStreamErrorCallback {
    @nativeInvoke
    operator fun invoke(reason: Any): dynamic /* Unit | PromiseLike<Unit> */
}