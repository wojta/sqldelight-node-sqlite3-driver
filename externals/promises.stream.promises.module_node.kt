@file:JsModule("stream/promises")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package stream.promises

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
import NodeJS.ReadableStream
import stream.internal.FinishedOptions
import NodeJS.WritableStream
import NodeJS.ReadWriteStream
import stream.internal.PipelineOptions
import stream.PipelinePromise
import stream.PipelineDestination

external fun finished(stream: ReadableStream, options: FinishedOptions = definedExternally): Promise<Unit>

external fun finished(stream: ReadableStream): Promise<Unit>

external fun finished(stream: WritableStream, options: FinishedOptions = definedExternally): Promise<Unit>

external fun finished(stream: WritableStream): Promise<Unit>

external fun finished(stream: ReadWriteStream, options: FinishedOptions = definedExternally): Promise<Unit>

external fun finished(stream: ReadWriteStream): Promise<Unit>

external fun <A, B : PipelineDestination<A, Any>> pipeline(source: A, destination: B, options: PipelineOptions = definedExternally): PipelinePromise<B>

external fun <A, B : PipelineDestination<A, Any>> pipeline(source: A, destination: B): PipelinePromise<B>

external fun <A, T1, B : PipelineDestination<T1, Any>> pipeline(source: A, transform1: T1, destination: B, options: PipelineOptions = definedExternally): PipelinePromise<B>

external fun <A, T1, B : PipelineDestination<T1, Any>> pipeline(source: A, transform1: T1, destination: B): PipelinePromise<B>

external fun <A, T1, T2, B : PipelineDestination<T2, Any>> pipeline(source: A, transform1: T1, transform2: T2, destination: B, options: PipelineOptions = definedExternally): PipelinePromise<B>

external fun <A, T1, T2, B : PipelineDestination<T2, Any>> pipeline(source: A, transform1: T1, transform2: T2, destination: B): PipelinePromise<B>

external fun <A, T1, T2, T3, B : PipelineDestination<T3, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, destination: B, options: PipelineOptions = definedExternally): PipelinePromise<B>

external fun <A, T1, T2, T3, B : PipelineDestination<T3, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, destination: B): PipelinePromise<B>

external fun <A, T1, T2, T3, T4, B : PipelineDestination<T4, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, transform4: T4, destination: B, options: PipelineOptions = definedExternally): PipelinePromise<B>

external fun <A, T1, T2, T3, T4, B : PipelineDestination<T4, Any>> pipeline(source: A, transform1: T1, transform2: T2, transform3: T3, transform4: T4, destination: B): PipelinePromise<B>

external fun pipeline(streams: Array<Any /* NodeJS.ReadableStream | NodeJS.WritableStream | NodeJS.ReadWriteStream */>, options: PipelineOptions = definedExternally): Promise<Unit>

external fun pipeline(streams: Array<Any /* NodeJS.ReadableStream | NodeJS.WritableStream | NodeJS.ReadWriteStream */>): Promise<Unit>

external fun pipeline(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: Any /* NodeJS.ReadWriteStream | NodeJS.WritableStream | PipelineOptions */): Promise<Unit>

external fun pipeline(stream1: ReadableStream, stream2: WritableStream, vararg streams: Any /* NodeJS.ReadWriteStream | NodeJS.WritableStream | PipelineOptions */): Promise<Unit>