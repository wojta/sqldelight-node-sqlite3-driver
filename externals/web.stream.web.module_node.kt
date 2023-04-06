@file:JsModule("stream/web")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package stream.web

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
import tsstdlib.AbortSignal

external interface ReadableWritablePair<R, W> {
    var readable: ReadableStream<R>
    var writable: WritableStream<W>
}

external interface StreamPipeOptions {
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

external interface ReadableStreamGenericReader {
    var closed: Promise<Nothing?>
    fun cancel(reason: Any = definedExternally): Promise<Unit>
}

external interface ReadableStreamDefaultReadValueResult<T> {
    var done: Boolean
    var value: T
}

external interface ReadableStreamDefaultReadDoneResult {
    var done: Boolean
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadableByteStreamControllerCallback {
    @nativeInvoke
    operator fun invoke(controller: ReadableByteStreamController): dynamic /* Unit | PromiseLike<Unit> */
}

external interface UnderlyingSinkAbortCallback {
    @nativeInvoke
    operator fun invoke(reason: Any = definedExternally): dynamic /* Unit | PromiseLike<Unit> */
}

external interface UnderlyingSinkCloseCallback {
    @nativeInvoke
    operator fun invoke(): dynamic /* Unit | PromiseLike<Unit> */
}

external interface UnderlyingSinkStartCallback {
    @nativeInvoke
    operator fun invoke(controller: WritableStreamDefaultController): Any
}

external interface UnderlyingSinkWriteCallback<W> {
    @nativeInvoke
    operator fun invoke(chunk: W, controller: WritableStreamDefaultController): dynamic /* Unit | PromiseLike<Unit> */
}

external interface UnderlyingSourceCancelCallback {
    @nativeInvoke
    operator fun invoke(reason: Any = definedExternally): dynamic /* Unit | PromiseLike<Unit> */
}

external interface UnderlyingSourcePullCallback<R> {
    @nativeInvoke
    operator fun invoke(controller: ReadableStreamController<R>): dynamic /* Unit | PromiseLike<Unit> */
}

external interface UnderlyingSourceStartCallback<R> {
    @nativeInvoke
    operator fun invoke(controller: ReadableStreamController<R>): Any
}

external interface TransformerFlushCallback<O> {
    @nativeInvoke
    operator fun invoke(controller: TransformStreamDefaultController<O>): dynamic /* Unit | PromiseLike<Unit> */
}

external interface TransformerStartCallback<O> {
    @nativeInvoke
    operator fun invoke(controller: TransformStreamDefaultController<O>): Any
}

external interface TransformerTransformCallback<I, O> {
    @nativeInvoke
    operator fun invoke(chunk: I, controller: TransformStreamDefaultController<O>): dynamic /* Unit | PromiseLike<Unit> */
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

external interface UnderlyingSource<R> {
    var cancel: UnderlyingSourceCancelCallback?
        get() = definedExternally
        set(value) = definedExternally
    var pull: UnderlyingSourcePullCallback<R>?
        get() = definedExternally
        set(value) = definedExternally
    var start: UnderlyingSourceStartCallback<R>?
        get() = definedExternally
        set(value) = definedExternally
    var type: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UnderlyingSink<W> {
    var abort: UnderlyingSinkAbortCallback?
        get() = definedExternally
        set(value) = definedExternally
    var close: UnderlyingSinkCloseCallback?
        get() = definedExternally
        set(value) = definedExternally
    var start: UnderlyingSinkStartCallback?
        get() = definedExternally
        set(value) = definedExternally
    var type: Any?
        get() = definedExternally
        set(value) = definedExternally
    var write: UnderlyingSinkWriteCallback<W>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadableStreamErrorCallback {
    @nativeInvoke
    operator fun invoke(reason: Any): dynamic /* Unit | PromiseLike<Unit> */
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface ReadableStream<R> {
    var locked: Boolean
    fun cancel(reason: Any = definedExternally): Promise<Unit>
    fun getReader(): ReadableStreamDefaultReader<R>
    fun <T> pipeThrough(transform: ReadableWritablePair<T, R>, options: StreamPipeOptions = definedExternally): ReadableStream<T>
    fun pipeTo(destination: WritableStream<R>, options: StreamPipeOptions = definedExternally): Promise<Unit>
    fun tee(): dynamic /* JsTuple<ReadableStream<R>, ReadableStream<R>> */

    companion object {
        var prototype: ReadableStream__0
    }
}

external interface ReadableStream__0 : ReadableStream<Any>

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface ReadableStreamDefaultReader<R> : ReadableStreamGenericReader {
    fun read(): Promise<dynamic /* ReadableStreamDefaultReadValueResult<R> | ReadableStreamDefaultReadDoneResult */>
    fun releaseLock()

    companion object {
        var prototype: ReadableStreamDefaultReader__0
    }
}

external interface ReadableStreamDefaultReader__0 : ReadableStreamDefaultReader<Any>

external var ReadableStreamBYOBReader: Any

external var ReadableStreamBYOBRequest: Any

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface ReadableByteStreamController {
    var byobRequest: Any?
    var desiredSize: Number?
    fun close()
    fun enqueue(chunk: ArrayBufferView)
    fun error(error: Any = definedExternally)

    companion object {
        var prototype: ReadableByteStreamController
    }
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface ReadableStreamDefaultController<R> {
    var desiredSize: Number?
    fun close()
    fun enqueue(chunk: R = definedExternally)
    fun error(e: Any = definedExternally)

    companion object {
        var prototype: ReadableStreamDefaultController__0
    }
}

external interface ReadableStreamDefaultController__0 : ReadableStreamDefaultController<Any>

external interface Transformer<I, O> {
    var flush: TransformerFlushCallback<O>?
        get() = definedExternally
        set(value) = definedExternally
    var readableType: Any?
        get() = definedExternally
        set(value) = definedExternally
    var start: TransformerStartCallback<O>?
        get() = definedExternally
        set(value) = definedExternally
    var transform: TransformerTransformCallback<I, O>?
        get() = definedExternally
        set(value) = definedExternally
    var writableType: Any?
        get() = definedExternally
        set(value) = definedExternally
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface TransformStream<I, O> {
    var readable: ReadableStream<O>
    var writable: WritableStream<I>

    companion object {
        var prototype: TransformStream__0
    }
}

external interface TransformStream__0 : TransformStream<Any, Any>

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface TransformStreamDefaultController<O> {
    var desiredSize: Number?
    fun enqueue(chunk: O = definedExternally)
    fun error(reason: Any = definedExternally)
    fun terminate()

    companion object {
        var prototype: TransformStreamDefaultController__0
    }
}

external interface TransformStreamDefaultController__0 : TransformStreamDefaultController<Any>

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface WritableStream<W> {
    var locked: Boolean
    fun abort(reason: Any = definedExternally): Promise<Unit>
    fun close(): Promise<Unit>
    fun getWriter(): WritableStreamDefaultWriter<W>

    companion object {
        var prototype: WritableStream__0
    }
}

external interface WritableStream__0 : WritableStream<Any>

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface WritableStreamDefaultWriter<W> {
    var closed: Promise<Nothing?>
    var desiredSize: Number?
    var ready: Promise<Nothing?>
    fun abort(reason: Any = definedExternally): Promise<Unit>
    fun close(): Promise<Unit>
    fun releaseLock()
    fun write(chunk: W = definedExternally): Promise<Unit>

    companion object {
        var prototype: WritableStreamDefaultWriter__0
    }
}

external interface WritableStreamDefaultWriter__0 : WritableStreamDefaultWriter<Any>

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface WritableStreamDefaultController {
    fun error(e: Any = definedExternally)

    companion object {
        var prototype: WritableStreamDefaultController
    }
}

external interface QueuingStrategy<T> {
    var highWaterMark: Number?
        get() = definedExternally
        set(value) = definedExternally
    var size: QueuingStrategySize<T>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueuingStrategy__0 : QueuingStrategy<Any>

external interface QueuingStrategySize<T> {
    @nativeInvoke
    operator fun invoke(chunk: T = definedExternally): Number
}

external interface QueuingStrategySize__0 : QueuingStrategySize<Any>

external interface QueuingStrategyInit {
    var highWaterMark: Number
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface ByteLengthQueuingStrategy : QueuingStrategy<ArrayBufferView> {
    companion object {
        var prototype: ByteLengthQueuingStrategy
    }
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface CountQueuingStrategy : QueuingStrategy__0 {
    companion object {
        var prototype: CountQueuingStrategy
    }
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface TextEncoderStream {
    var encoding: String /* "utf-8" */
    var readable: ReadableStream<Uint8Array>
    var writable: WritableStream<String>

    companion object {
        var prototype: TextEncoderStream
    }
}

external interface TextDecoderOptions {
    var fatal: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreBOM: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface TextDecoderStream {
    var encoding: String
    var fatal: Boolean
    var ignoreBOM: Boolean
    var readable: ReadableStream<String>
    var writable: WritableStream<dynamic /* ArrayBufferView | ArrayBuffer */>

    companion object {
        var prototype: TextDecoderStream
    }
}