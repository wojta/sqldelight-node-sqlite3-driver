@file:JsModule("stream/consumers")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package stream.consumers

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
import buffer.global.Buffer
import stream.internal.Readable
import AsyncIterator__1

external fun buffer(stream: ReadableStream): Promise<Buffer>

external fun buffer(stream: Readable): Promise<Buffer>

external fun buffer(stream: AsyncIterator__1<Any>): Promise<Buffer>

external fun text(stream: ReadableStream): Promise<String>

external fun text(stream: Readable): Promise<String>

external fun text(stream: AsyncIterator__1<Any>): Promise<String>

external fun arrayBuffer(stream: ReadableStream): Promise<ArrayBuffer>

external fun arrayBuffer(stream: Readable): Promise<ArrayBuffer>

external fun arrayBuffer(stream: AsyncIterator__1<Any>): Promise<ArrayBuffer>

external fun blob(stream: ReadableStream): Promise<Blob>

external fun blob(stream: Readable): Promise<Blob>

external fun blob(stream: AsyncIterator__1<Any>): Promise<Blob>

external fun json(stream: ReadableStream): Promise<Any>

external fun json(stream: Readable): Promise<Any>

external fun json(stream: AsyncIterator__1<Any>): Promise<Any>