@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package stream

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
import AsyncIterable
import NodeJS.`T$5`
import NodeJS.WritableStream
import stream.internal.ReadableOptions
import stream.internal.Stream
import events.EventEmitter.Abortable
import stream.internal.Readable
import stream.internal.StreamOptions
import NodeJS.ReadableStream
import tsstdlib.Iterable
import stream.internal.`T$16`
import stream.internal.Writable
import stream.internal.WritableOptions
import stream.internal.DuplexOptions
import stream.internal.Duplex
import AsyncGeneratorFunction
import stream.internal.TransformOptions
import stream.internal.Transform
import tsstdlib.AbortSignal
import events.EventEmitter
import stream.internal.FinishedOptions
import NodeJS.ErrnoException
import NodeJS.ReadWriteStream

typealias TransformCallback = (error: Error?, data: Any) -> Unit

typealias PipelineSourceFunction<T> = () -> dynamic

typealias PipelineDestinationIterableFunction<T> = (source: AsyncIterable<T>) -> AsyncIterable<Any>

typealias PipelineDestinationPromiseFunction<T, P> = (source: AsyncIterable<T>) -> Promise<P>

typealias PipelineDestination<S, P> = Any

typealias PipelineCallback<S> = Any

typealias PipelinePromise<S> = Any

@JsModule("node:stream")
external open class internal : EventEmitter {
    open fun <T : WritableStream> pipe(destination: T, options: `T$5` = definedExternally): T
    open class Stream(opts: ReadableOptions = definedExternally) : internal
    interface StreamOptions<T : Stream> : Abortable {
        var emitClose: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var highWaterMark: Number?
            get() = definedExternally
            set(value) = definedExternally
        var objectMode: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        val construct: ((callback: (error: Error?) -> Unit) -> Unit)?
        val destroy: ((error: Error?, callback: (error: Error?) -> Unit) -> Unit)?
        var autoDestroy: Boolean?
            get() = definedExternally
            set(value) = definedExternally
    }
    interface ReadableOptions : StreamOptions<Readable> {
        var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
            get() = definedExternally
            set(value) = definedExternally
        val read: ((size: Number) -> Unit)?
    }
    open class Readable(opts: ReadableOptions = definedExternally) : Stream, ReadableStream {
        open var readableAborted: Boolean
        override var readable: Boolean
        open var readableDidRead: Boolean
        open var readableEncoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
        open var readableEnded: Boolean
        open var readableFlowing: Boolean?
        open var readableHighWaterMark: Number
        open var readableLength: Number
        open var readableObjectMode: Boolean
        open var destroyed: Boolean
        open val _construct: ((callback: (error: Error?) -> Unit) -> Unit)?
        open fun _read(size: Number)
        override fun read(size: Number): Any
        override fun setEncoding(encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Readable /* this */
        override fun pause(): Readable /* this */
        override fun resume(): Readable /* this */
        override fun isPaused(): Boolean
        override fun unpipe(destination: WritableStream): Readable /* this */
        open fun unshift(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)
        override fun unshift(chunk: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */)
        override fun unshift(chunk: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */)
        open fun unshift(chunk: Any)
        override fun unshift(chunk: String)
        override fun unshift(chunk: Uint8Array)
        override fun wrap(stream: ReadableStream): Readable /* this */
        open fun push(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
        open fun _destroy(error: Error?, callback: (error: Error?) -> Unit)
        open fun destroy(error: Error = definedExternally): Readable /* this */
        open fun addListener(event: String /* "close" | "end" | "pause" | "readable" | "resume" */, listener: () -> Unit): Readable /* this */
        override fun addListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */
        open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */
        override fun addListener(event: Any, listener: (args: Any) -> Unit): Readable /* this */
        open fun emit(event: String /* "close" | "end" | "pause" | "readable" | "resume" */): Boolean
        open fun emit(event: String /* "data" */, chunk: Any): Boolean
        override fun emit(eventName: String, vararg args: Any): Boolean
        override fun emit(eventName: Any, vararg args: Any): Boolean
        override fun emit(eventName: String, vararg args: Any): Boolean
        override fun emit(eventName: Any, vararg args: Any): Boolean
        open fun emit(event: String /* "error" */, err: Error): Boolean
        override fun emit(event: Any, vararg args: Any): Boolean
        open fun on(event: String /* "close" | "end" | "pause" | "readable" | "resume" */, listener: () -> Unit): Readable /* this */
        override fun on(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */
        open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */
        override fun on(event: Any, listener: (args: Any) -> Unit): Readable /* this */
        open fun once(event: String /* "close" | "end" | "pause" | "readable" | "resume" */, listener: () -> Unit): Readable /* this */
        override fun once(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */
        open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */
        override fun once(event: Any, listener: (args: Any) -> Unit): Readable /* this */
        open fun prependListener(event: String /* "close" | "end" | "pause" | "readable" | "resume" */, listener: () -> Unit): Readable /* this */
        override fun prependListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */
        open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */
        override fun prependListener(event: Any, listener: (args: Any) -> Unit): Readable /* this */
        open fun prependOnceListener(event: String /* "close" | "end" | "pause" | "readable" | "resume" */, listener: () -> Unit): Readable /* this */
        override fun prependOnceListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */
        open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */
        override fun prependOnceListener(event: Any, listener: (args: Any) -> Unit): Readable /* this */
        open fun removeListener(event: String /* "close" | "end" | "pause" | "readable" | "resume" */, listener: () -> Unit): Readable /* this */
        override fun removeListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */
        open fun removeListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */
        override fun removeListener(event: Any, listener: (args: Any) -> Unit): Readable /* this */

        companion object {
            fun from(iterable: Iterable<Any>, options: ReadableOptions = definedExternally): Readable
            fun from(iterable: AsyncIterable<Any>, options: ReadableOptions = definedExternally): Readable
            fun isDisturbed(stream: Readable): Boolean
            fun isDisturbed(stream: ReadableStream): Boolean
        }
    }
    interface `T$16` {
        var chunk: Any
        var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
    }
    interface WritableOptions : StreamOptions<Writable> {
        var decodeStrings: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var defaultEncoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
            get() = definedExternally
            set(value) = definedExternally
        val write: ((chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (error: Error?) -> Unit) -> Unit)?
        val writev: ((chunks: Array<`T$16`>, callback: (error: Error?) -> Unit) -> Unit)?
        val final: ((callback: (error: Error?) -> Unit) -> Unit)?
    }
    open class Writable(opts: WritableOptions = definedExternally) : Stream, WritableStream {
        override var writable: Boolean
        open var writableEnded: Boolean
        open var writableFinished: Boolean
        open var writableHighWaterMark: Number
        open var writableLength: Number
        open var writableObjectMode: Boolean
        open var writableCorked: Number
        open var destroyed: Boolean
        open fun _write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (error: Error?) -> Unit)
        open val _writev: ((chunks: Array<`T$16`>, callback: (error: Error?) -> Unit) -> Unit)?
        open val _construct: ((callback: (error: Error?) -> Unit) -> Unit)?
        open fun _destroy(error: Error?, callback: (error: Error?) -> Unit)
        open fun _final(callback: (error: Error?) -> Unit)
        open fun write(chunk: Any, callback: (error: Error?) -> Unit = definedExternally): Boolean
        override fun write(buffer: Uint8Array, cb: (err: Error?) -> Unit): Boolean
        override fun write(buffer: String, cb: (err: Error?) -> Unit): Boolean
        open fun write(chunk: Any): Boolean
        override fun write(buffer: Uint8Array): Boolean
        override fun write(buffer: String): Boolean
        open fun write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (error: Error?) -> Unit = definedExternally): Boolean
        override fun write(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, cb: (err: Error?) -> Unit): Boolean
        open fun write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Boolean
        override fun write(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Boolean
        open fun setDefaultEncoding(encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Writable /* this */
        override fun end(cb: () -> Unit): Writable /* this */
        override fun end(): Writable /* this */
        open fun end(chunk: Any, cb: () -> Unit = definedExternally): Writable /* this */
        override fun end(data: String, cb: () -> Unit): WritableStream /* this */
        override fun end(data: Uint8Array, cb: () -> Unit): WritableStream /* this */
        open fun end(chunk: Any): Writable /* this */
        override fun end(cb: () -> Unit): WritableStream /* this */
        override fun end(data: String): WritableStream /* this */
        override fun end(data: Uint8Array): WritableStream /* this */
        open fun end(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, cb: () -> Unit = definedExternally): Writable /* this */
        override fun end(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, cb: () -> Unit): WritableStream /* this */
        open fun end(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Writable /* this */
        override fun end(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): WritableStream /* this */
        open fun cork()
        open fun uncork()
        open fun destroy(error: Error = definedExternally): Writable /* this */
        open fun addListener(event: String /* "close" | "drain" | "finish" */, listener: () -> Unit): Writable /* this */
        open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */
        open fun addListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */
        override fun addListener(event: String, listener: (args: Any) -> Unit): Writable /* this */
        override fun addListener(event: Any, listener: (args: Any) -> Unit): Writable /* this */
        open fun emit(event: String /* "close" | "drain" | "finish" */): Boolean
        open fun emit(event: String /* "error" */, err: Error): Boolean
        override fun emit(eventName: String, vararg args: Any): Boolean
        override fun emit(eventName: Any, vararg args: Any): Boolean
        override fun emit(eventName: String, vararg args: Any): Boolean
        override fun emit(eventName: Any, vararg args: Any): Boolean
        open fun emit(event: String /* "pipe" | "unpipe" */, src: Readable): Boolean
        override fun emit(event: String, vararg args: Any): Boolean
        override fun emit(event: Any, vararg args: Any): Boolean
        open fun on(event: String /* "close" | "drain" | "finish" */, listener: () -> Unit): Writable /* this */
        open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */
        open fun on(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */
        override fun on(event: String, listener: (args: Any) -> Unit): Writable /* this */
        override fun on(event: Any, listener: (args: Any) -> Unit): Writable /* this */
        open fun once(event: String /* "close" | "drain" | "finish" */, listener: () -> Unit): Writable /* this */
        open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */
        open fun once(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */
        override fun once(event: String, listener: (args: Any) -> Unit): Writable /* this */
        override fun once(event: Any, listener: (args: Any) -> Unit): Writable /* this */
        open fun prependListener(event: String /* "close" | "drain" | "finish" */, listener: () -> Unit): Writable /* this */
        open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */
        open fun prependListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */
        override fun prependListener(event: String, listener: (args: Any) -> Unit): Writable /* this */
        override fun prependListener(event: Any, listener: (args: Any) -> Unit): Writable /* this */
        open fun prependOnceListener(event: String /* "close" | "drain" | "finish" */, listener: () -> Unit): Writable /* this */
        open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */
        open fun prependOnceListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */
        override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Writable /* this */
        override fun prependOnceListener(event: Any, listener: (args: Any) -> Unit): Writable /* this */
        open fun removeListener(event: String /* "close" | "drain" | "finish" */, listener: () -> Unit): Writable /* this */
        open fun removeListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */
        open fun removeListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */
        override fun removeListener(event: String, listener: (args: Any) -> Unit): Writable /* this */
        override fun removeListener(event: Any, listener: (args: Any) -> Unit): Writable /* this */
    }
    interface DuplexOptions : ReadableOptions, WritableOptions {
        var allowHalfOpen: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var readableObjectMode: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var writableObjectMode: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var readableHighWaterMark: Number?
            get() = definedExternally
            set(value) = definedExternally
        var writableHighWaterMark: Number?
            get() = definedExternally
            set(value) = definedExternally
        var writableCorked: Number?
            get() = definedExternally
            set(value) = definedExternally
        override val construct: ((callback: (error: Error?) -> Unit) -> Unit)?
        override val read: ((size: Number) -> Unit)?
        override val write: ((chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (error: Error?) -> Unit) -> Unit)?
        override val writev: ((chunks: Array<`T$16`>, callback: (error: Error?) -> Unit) -> Unit)?
        override val final: ((callback: (error: Error?) -> Unit) -> Unit)?
        override val destroy: ((error: Error?, callback: (error: Error?) -> Unit) -> Unit)?
    }
    open class Duplex(opts: DuplexOptions = definedExternally) : Readable {
        open var writable: Boolean
        open var writableEnded: Boolean
        open var writableFinished: Boolean
        open var writableHighWaterMark: Number
        open var writableLength: Number
        open var writableObjectMode: Boolean
        open var writableCorked: Number
        open var allowHalfOpen: Boolean
        open fun _write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (error: Error?) -> Unit)
        open val _writev: ((chunks: Array<`T$16`>, callback: (error: Error?) -> Unit) -> Unit)?
        override fun _destroy(error: Error?, callback: (error: Error?) -> Unit)
        open fun _final(callback: (error: Error?) -> Unit)
        open fun write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, cb: (error: Error?) -> Unit = definedExternally): Boolean
        open fun write(chunk: Any): Boolean
        open fun write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
        open fun write(chunk: Any, cb: (error: Error?) -> Unit = definedExternally): Boolean
        open fun setDefaultEncoding(encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Duplex /* this */
        open fun end(cb: () -> Unit = definedExternally): Duplex /* this */
        open fun end(): Duplex /* this */
        open fun end(chunk: Any, cb: () -> Unit = definedExternally): Duplex /* this */
        open fun end(chunk: Any): Duplex /* this */
        open fun end(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, cb: () -> Unit = definedExternally): Duplex /* this */
        open fun end(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Duplex /* this */
        open fun cork()
        open fun uncork()

        companion object {
            fun from(src: Stream): Duplex
            fun from(src: Blob): Duplex
            fun from(src: ArrayBuffer): Duplex
            fun from(src: String): Duplex
            fun from(src: Iterable<Any>): Duplex
            fun from(src: AsyncIterable<Any>): Duplex
            fun from(src: AsyncGeneratorFunction): Duplex
            fun from(src: Promise<Any>): Duplex
            fun from(src: Any): Duplex
        }
    }
    interface TransformOptions : DuplexOptions {
        override val construct: ((callback: (error: Error?) -> Unit) -> Unit)?
        override val read: ((size: Number) -> Unit)?
        override val write: ((chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (error: Error?) -> Unit) -> Unit)?
        override val writev: ((chunks: Array<`T$16`>, callback: (error: Error?) -> Unit) -> Unit)?
        override val final: ((callback: (error: Error?) -> Unit) -> Unit)?
        override val destroy: ((error: Error?, callback: (error: Error?) -> Unit) -> Unit)?
        val transform: ((chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: TransformCallback) -> Unit)?
        val flush: ((callback: TransformCallback) -> Unit)?
    }
    open class Transform(opts: TransformOptions = definedExternally) : Duplex {
        open fun _transform(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: TransformCallback)
        open fun _flush(callback: TransformCallback)
    }
    open class PassThrough(opts: TransformOptions = definedExternally) : Transform
    interface FinishedOptions : Abortable {
        var error: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var readable: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var writable: Boolean?
            get() = definedExternally
            set(value) = definedExternally
    }
    interface PipelineOptions {
        var signal: AbortSignal
    }
    interface Pipe {
        fun close()
        fun hasRef(): Boolean
        fun ref()
        fun unref()
    }

    companion object {
        fun <T : Stream> addAbortSignal(signal: AbortSignal, stream: T): T
        fun finished(stream: ReadableStream, options: FinishedOptions, callback: (err: ErrnoException?) -> Unit): () -> Unit
        fun finished(stream: WritableStream, options: FinishedOptions, callback: (err: ErrnoException?) -> Unit): () -> Unit
        fun finished(stream: ReadWriteStream, options: FinishedOptions, callback: (err: ErrnoException?) -> Unit): () -> Unit
        fun finished(stream: ReadableStream, callback: (err: ErrnoException?) -> Unit): () -> Unit
        fun finished(stream: WritableStream, callback: (err: ErrnoException?) -> Unit): () -> Unit
        fun finished(stream: ReadWriteStream, callback: (err: ErrnoException?) -> Unit): () -> Unit
        fun <A, B : PipelineDestination<A, Any>> pipeline(source: A, destination: B, callback: PipelineCallback<B> = definedExternally): Any
        fun <A, B : PipelineDestination<A, Any>> pipeline(source: A, destination: B): Any
        fun <A, T1, B : PipelineDestination<T1, Any>> pipeline(source: A, transform1: T1, destination: B, callback: PipelineCallback<B> = definedExternally): Any
        fun <A, T1, B : PipelineDestination<T1, Any>> pipeline(source: A, transform1: T1, destination: B): Any
        fun <A, T1, T2, B : PipelineDestination<T2, Any>> pipeline(source: A, transform1: T1, transform2: T2, destination: B, callback: PipelineCallback<B> = definedExternally): Any
        fun <A, T1, T2, B : PipelineDestination<T2, Any>> pipeline(source: A, transform1: T1, transform2: T2, destination: B): Any
        fun <A, T1, T2, T3, B : PipelineDestination<T3, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, destination: B, callback: PipelineCallback<B> = definedExternally): Any
        fun <A, T1, T2, T3, B : PipelineDestination<T3, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, destination: B): Any
        fun <A, T1, T2, T3, T4, B : PipelineDestination<T4, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, transform4: T4, destination: B, callback: PipelineCallback<B> = definedExternally): Any
        fun <A, T1, T2, T3, T4, B : PipelineDestination<T4, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, transform4: T4, destination: B): Any
        fun pipeline(streams: Array<Any /* NodeJS.ReadableStream | NodeJS.WritableStream | NodeJS.ReadWriteStream */>, callback: (err: ErrnoException?) -> Unit = definedExternally): WritableStream
        fun pipeline(streams: Array<Any /* NodeJS.ReadableStream | NodeJS.WritableStream | NodeJS.ReadWriteStream */>): WritableStream
        fun pipeline(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: Any /* NodeJS.ReadWriteStream | NodeJS.WritableStream | (err: NodeJS.ErrnoException?) -> Unit */): WritableStream
        fun pipeline(stream1: ReadableStream, stream2: WritableStream, vararg streams: Any /* NodeJS.ReadWriteStream | NodeJS.WritableStream | (err: NodeJS.ErrnoException?) -> Unit */): WritableStream
        var promises: Any
        var consumers: Any
    }
}