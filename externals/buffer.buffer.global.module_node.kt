@file:JsQualifier("buffer.global")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package buffer.global

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
import SharedArrayBuffer
import BigUint64Array
import BigInt64Array
import tsstdlib.IterableIterator

external interface `T$19`<T> {
    fun valueOf(): T
}

external interface BufferConstructor {
    fun from(arrayBuffer: ArrayBuffer, byteOffset: Number = definedExternally, length: Number = definedExternally): Buffer
    fun from(arrayBuffer: ArrayBuffer): Buffer
    fun from(arrayBuffer: ArrayBuffer, byteOffset: Number = definedExternally): Buffer
    fun from(arrayBuffer: SharedArrayBuffer, byteOffset: Number = definedExternally, length: Number = definedExternally): Buffer
    fun from(arrayBuffer: SharedArrayBuffer): Buffer
    fun from(arrayBuffer: SharedArrayBuffer, byteOffset: Number = definedExternally): Buffer
    fun from(arrayBuffer: `T$19`<Any /* ArrayBuffer | SharedArrayBuffer */>, byteOffset: Number = definedExternally, length: Number = definedExternally): Buffer
    fun from(arrayBuffer: `T$19`<Any /* ArrayBuffer | SharedArrayBuffer | Uint8Array | ReadonlyArray<Number> | String */>): Buffer
    fun from(arrayBuffer: `T$19`<Any /* ArrayBuffer | SharedArrayBuffer */>, byteOffset: Number = definedExternally): Buffer
    fun from(data: Uint8Array): Buffer
    fun from(data: Array<Number>): Buffer
    fun from(data: String): Buffer
    fun from(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
    fun from(str: `T$19`<String>, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
    fun from(str: `T$19`<String>): Buffer
    fun from(str: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
    fun from(str: Any): Buffer
    fun of(vararg items: Number): Buffer
    fun isBuffer(obj: Any): Boolean
    fun isEncoding(encoding: String): Boolean
    fun byteLength(string: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: String): Number
    fun byteLength(string: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Uint8Array): Number
    fun byteLength(string: Uint8ClampedArray, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Uint8ClampedArray): Number
    fun byteLength(string: Uint16Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Uint16Array): Number
    fun byteLength(string: Uint32Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Uint32Array): Number
    fun byteLength(string: Int8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Int8Array): Number
    fun byteLength(string: Int16Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Int16Array): Number
    fun byteLength(string: Int32Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Int32Array): Number
    fun byteLength(string: BigUint64Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: BigUint64Array): Number
    fun byteLength(string: BigInt64Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: BigInt64Array): Number
    fun byteLength(string: Float32Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Float32Array): Number
    fun byteLength(string: Float64Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: Float64Array): Number
    fun byteLength(string: DataView, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: DataView): Number
    fun byteLength(string: ArrayBuffer, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: ArrayBuffer): Number
    fun byteLength(string: SharedArrayBuffer, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun byteLength(string: SharedArrayBuffer): Number
    fun concat(list: Array<Uint8Array>, totalLength: Number = definedExternally): Buffer
    fun compare(buf1: Uint8Array, buf2: Uint8Array): dynamic /* "-1" | 0 | 1 */
    fun alloc(size: Number, fill: String = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
    fun alloc(size: Number): Buffer
    fun alloc(size: Number, fill: String = definedExternally): Buffer
    fun alloc(size: Number, fill: Buffer = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
    fun alloc(size: Number, fill: Buffer = definedExternally): Buffer
    fun alloc(size: Number, fill: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
    fun alloc(size: Number, fill: Number = definedExternally): Buffer
    fun allocUnsafe(size: Number): Buffer
    fun allocUnsafeSlow(size: Number): Buffer
    var poolSize: Number
}

external interface `T$20` {
    var type: String /* "Buffer" */
    var data: Array<Number>
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Buffer : Uint8Array {
    fun write(string: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun write(string: String): Number
    fun write(string: String, offset: Number, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun write(string: String, offset: Number): Number
    fun write(string: String, offset: Number, length: Number, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun write(string: String, offset: Number, length: Number): Number
    fun toString(encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, start: Number = definedExternally, end: Number = definedExternally): String
    fun toJSON(): `T$20`
    fun equals(otherBuffer: Uint8Array): Boolean
    fun compare(target: Uint8Array, targetStart: Number = definedExternally, targetEnd: Number = definedExternally, sourceStart: Number = definedExternally, sourceEnd: Number = definedExternally): Number
    fun copy(target: Uint8Array, targetStart: Number = definedExternally, sourceStart: Number = definedExternally, sourceEnd: Number = definedExternally): Number
    fun slice(start: Number = definedExternally, end: Number = definedExternally): Buffer
    fun subarray(start: Number = definedExternally, end: Number = definedExternally): Buffer
    fun writeBigInt64BE(value: Any, offset: Number = definedExternally): Number
    fun writeBigInt64LE(value: Any, offset: Number = definedExternally): Number
    fun writeBigUInt64BE(value: Any, offset: Number = definedExternally): Number
    fun writeBigUint64BE(value: Any, offset: Number = definedExternally): Number
    fun writeBigUInt64LE(value: Any, offset: Number = definedExternally): Number
    fun writeBigUint64LE(value: Any, offset: Number = definedExternally): Number
    fun writeUIntLE(value: Number, offset: Number, byteLength: Number): Number
    fun writeUintLE(value: Number, offset: Number, byteLength: Number): Number
    fun writeUIntBE(value: Number, offset: Number, byteLength: Number): Number
    fun writeUintBE(value: Number, offset: Number, byteLength: Number): Number
    fun writeIntLE(value: Number, offset: Number, byteLength: Number): Number
    fun writeIntBE(value: Number, offset: Number, byteLength: Number): Number
    fun readBigUInt64BE(offset: Number = definedExternally): Any
    fun readBigUint64BE(offset: Number = definedExternally): Any
    fun readBigUInt64LE(offset: Number = definedExternally): Any
    fun readBigUint64LE(offset: Number = definedExternally): Any
    fun readBigInt64BE(offset: Number = definedExternally): Any
    fun readBigInt64LE(offset: Number = definedExternally): Any
    fun readUIntLE(offset: Number, byteLength: Number): Number
    fun readUintLE(offset: Number, byteLength: Number): Number
    fun readUIntBE(offset: Number, byteLength: Number): Number
    fun readUintBE(offset: Number, byteLength: Number): Number
    fun readIntLE(offset: Number, byteLength: Number): Number
    fun readIntBE(offset: Number, byteLength: Number): Number
    fun readUInt8(offset: Number = definedExternally): Number
    fun readUint8(offset: Number = definedExternally): Number
    fun readUInt16LE(offset: Number = definedExternally): Number
    fun readUint16LE(offset: Number = definedExternally): Number
    fun readUInt16BE(offset: Number = definedExternally): Number
    fun readUint16BE(offset: Number = definedExternally): Number
    fun readUInt32LE(offset: Number = definedExternally): Number
    fun readUint32LE(offset: Number = definedExternally): Number
    fun readUInt32BE(offset: Number = definedExternally): Number
    fun readUint32BE(offset: Number = definedExternally): Number
    fun readInt8(offset: Number = definedExternally): Number
    fun readInt16LE(offset: Number = definedExternally): Number
    fun readInt16BE(offset: Number = definedExternally): Number
    fun readInt32LE(offset: Number = definedExternally): Number
    fun readInt32BE(offset: Number = definedExternally): Number
    fun readFloatLE(offset: Number = definedExternally): Number
    fun readFloatBE(offset: Number = definedExternally): Number
    fun readDoubleLE(offset: Number = definedExternally): Number
    fun readDoubleBE(offset: Number = definedExternally): Number
    fun reverse(): Buffer /* this */
    fun swap16(): Buffer
    fun swap32(): Buffer
    fun swap64(): Buffer
    fun writeUInt8(value: Number, offset: Number = definedExternally): Number
    fun writeUint8(value: Number, offset: Number = definedExternally): Number
    fun writeUInt16LE(value: Number, offset: Number = definedExternally): Number
    fun writeUint16LE(value: Number, offset: Number = definedExternally): Number
    fun writeUInt16BE(value: Number, offset: Number = definedExternally): Number
    fun writeUint16BE(value: Number, offset: Number = definedExternally): Number
    fun writeUInt32LE(value: Number, offset: Number = definedExternally): Number
    fun writeUint32LE(value: Number, offset: Number = definedExternally): Number
    fun writeUInt32BE(value: Number, offset: Number = definedExternally): Number
    fun writeUint32BE(value: Number, offset: Number = definedExternally): Number
    fun writeInt8(value: Number, offset: Number = definedExternally): Number
    fun writeInt16LE(value: Number, offset: Number = definedExternally): Number
    fun writeInt16BE(value: Number, offset: Number = definedExternally): Number
    fun writeInt32LE(value: Number, offset: Number = definedExternally): Number
    fun writeInt32BE(value: Number, offset: Number = definedExternally): Number
    fun writeFloatLE(value: Number, offset: Number = definedExternally): Number
    fun writeFloatBE(value: Number, offset: Number = definedExternally): Number
    fun writeDoubleLE(value: Number, offset: Number = definedExternally): Number
    fun writeDoubleBE(value: Number, offset: Number = definedExternally): Number
    fun fill(value: String, offset: Number = definedExternally, end: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer /* this */
    fun fill(value: String): Buffer /* this */
    fun fill(value: String, offset: Number = definedExternally): Buffer /* this */
    fun fill(value: String, offset: Number = definedExternally, end: Number = definedExternally): Buffer /* this */
    fun fill(value: Uint8Array, offset: Number = definedExternally, end: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer /* this */
    fun fill(value: Uint8Array): Buffer /* this */
    fun fill(value: Uint8Array, offset: Number = definedExternally): Buffer /* this */
    fun fill(value: Uint8Array, offset: Number = definedExternally, end: Number = definedExternally): Buffer /* this */
    fun fill(value: Number, offset: Number = definedExternally, end: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer /* this */
    fun fill(value: Number): Buffer /* this */
    fun fill(value: Number, offset: Number = definedExternally): Buffer /* this */
    fun fill(value: Number, offset: Number = definedExternally, end: Number = definedExternally): Buffer /* this */
    fun indexOf(value: String, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun indexOf(value: String): Number
    fun indexOf(value: String, byteOffset: Number = definedExternally): Number
    fun indexOf(value: Number, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun indexOf(value: Number): Number
    fun indexOf(value: Number, byteOffset: Number = definedExternally): Number
    fun indexOf(value: Uint8Array, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun indexOf(value: Uint8Array): Number
    fun indexOf(value: Uint8Array, byteOffset: Number = definedExternally): Number
    fun lastIndexOf(value: String, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun lastIndexOf(value: String): Number
    fun lastIndexOf(value: String, byteOffset: Number = definedExternally): Number
    fun lastIndexOf(value: Number, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun lastIndexOf(value: Number): Number
    fun lastIndexOf(value: Number, byteOffset: Number = definedExternally): Number
    fun lastIndexOf(value: Uint8Array, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    fun lastIndexOf(value: Uint8Array): Number
    fun lastIndexOf(value: Uint8Array, byteOffset: Number = definedExternally): Number
    fun entries(): IterableIterator<dynamic /* JsTuple<Number, Number> */>
    fun includes(value: String, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    fun includes(value: String): Boolean
    fun includes(value: String, byteOffset: Number = definedExternally): Boolean
    fun includes(value: Number, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    fun includes(value: Number): Boolean
    fun includes(value: Number, byteOffset: Number = definedExternally): Boolean
    fun includes(value: Buffer, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    fun includes(value: Buffer): Boolean
    fun includes(value: Buffer, byteOffset: Number = definedExternally): Boolean
    fun keys(): IterableIterator<Number>
    fun values(): IterableIterator<Number>

    companion object : BufferConstructor by definedExternally
}

external fun atob(data: String): String

external fun btoa(data: String): String