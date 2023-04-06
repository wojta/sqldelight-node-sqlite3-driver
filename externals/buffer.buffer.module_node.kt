@file:JsModule("buffer")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package buffer

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
import buffer.global.Buffer

external var INSPECT_MAX_BYTES: Number

external var kMaxLength: Number

external var kStringMaxLength: Number

external object constants {
    var MAX_LENGTH: Number
    var MAX_STRING_LENGTH: Number
}

external fun transcode(source: Uint8Array, fromEnc: String /* "ascii" | "utf8" | "utf16le" | "ucs2" | "latin1" | "binary" */, toEnc: String /* "ascii" | "utf8" | "utf16le" | "ucs2" | "latin1" | "binary" */): Buffer

external object SlowBuffer {
    var prototype: Buffer
}

external fun resolveObjectURL(id: String): Blob?

external interface BlobOptions {
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
        get() = definedExternally
        set(value) = definedExternally
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Blob(sources: Array<Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Blob */>, options: BlobOptions = definedExternally) {
    open var size: Number
    open var type: String
    open fun arrayBuffer(): Promise<ArrayBuffer>
    open fun slice(start: Number = definedExternally, end: Number = definedExternally, type: String = definedExternally): Blob
    open fun text(): Promise<String>
    open fun stream(): Any
}