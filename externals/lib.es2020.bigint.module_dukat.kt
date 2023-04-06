@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

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
import tsstdlib.IterableIterator
import tsstdlib.ArrayLike

external interface BigInt {
    fun toString(radix: Number = definedExternally): String
    fun toLocaleString(): String
    fun valueOf(): Any
}

external interface BigIntConstructor {
    @nativeInvoke
    operator fun invoke(value: Any = definedExternally): Any
    var prototype: BigInt
    fun asIntN(bits: Number, int: Any): Any
    fun asUintN(bits: Number, int: Any): Any
}

external interface BigInt64Array : RelativeIndexable<Any> {
    var BYTES_PER_ELEMENT: Number
    var buffer: dynamic /* SharedArrayBuffer | ArrayBuffer */
        get() = definedExternally
        set(value) = definedExternally
    var byteLength: Number
    var byteOffset: Number
    fun copyWithin(target: Number, start: Number, end: Number = definedExternally): BigInt64Array /* this */
    fun entries(): IterableIterator<dynamic /* JsTuple<Number, Any> */>
    fun every(callbackfn: (value: Any, index: Number, array: BigInt64Array) -> Boolean, thisArg: Any = definedExternally): Boolean
    fun fill(value: Any, start: Number = definedExternally, end: Number = definedExternally): BigInt64Array /* this */
    fun filter(callbackfn: (value: Any, index: Number, array: BigInt64Array) -> Any, thisArg: Any = definedExternally): BigInt64Array
    fun find(predicate: (value: Any, index: Number, array: BigInt64Array) -> Boolean, thisArg: Any = definedExternally): Any?
    fun findIndex(predicate: (value: Any, index: Number, array: BigInt64Array) -> Boolean, thisArg: Any = definedExternally): Number
    fun forEach(callbackfn: (value: Any, index: Number, array: BigInt64Array) -> Unit, thisArg: Any = definedExternally)
    fun includes(searchElement: Any, fromIndex: Number = definedExternally): Boolean
    fun indexOf(searchElement: Any, fromIndex: Number = definedExternally): Number
    fun join(separator: String = definedExternally): String
    fun keys(): IterableIterator<Number>
    fun lastIndexOf(searchElement: Any, fromIndex: Number = definedExternally): Number
    var length: Number
    fun map(callbackfn: (value: Any, index: Number, array: BigInt64Array) -> Any, thisArg: Any = definedExternally): BigInt64Array
    fun reduce(callbackfn: (previousValue: Any, currentValue: Any, currentIndex: Number, array: BigInt64Array) -> Any): Any
    fun <U> reduce(callbackfn: (previousValue: U, currentValue: Any, currentIndex: Number, array: BigInt64Array) -> U, initialValue: U): U
    fun reduceRight(callbackfn: (previousValue: Any, currentValue: Any, currentIndex: Number, array: BigInt64Array) -> Any): Any
    fun <U> reduceRight(callbackfn: (previousValue: U, currentValue: Any, currentIndex: Number, array: BigInt64Array) -> U, initialValue: U): U
    fun reverse(): BigInt64Array /* this */
    fun set(array: ArrayLike<Any>, offset: Number = definedExternally)
    fun set(array: ArrayLike<Any>)
    fun slice(start: Number = definedExternally, end: Number = definedExternally): BigInt64Array
    fun some(callbackfn: (value: Any, index: Number, array: BigInt64Array) -> Boolean, thisArg: Any = definedExternally): Boolean
    fun sort(compareFn: (a: Any, b: Any) -> Any = definedExternally): BigInt64Array /* this */
    fun subarray(begin: Number = definedExternally, end: Number = definedExternally): BigInt64Array
    fun toLocaleString(): String
    override fun toString(): String
    fun valueOf(): BigInt64Array
    fun values(): IterableIterator<Any>
    @nativeGetter
    operator fun get(index: Number): Any?
    @nativeSetter
    operator fun set(index: Number, value: Any)
}

external interface BigInt64ArrayConstructor {
    var prototype: BigInt64Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Any): BigInt64Array
    fun from(arrayLike: ArrayLike<Any>): BigInt64Array
    fun <U> from(arrayLike: ArrayLike<U>, mapfn: (v: U, k: Number) -> Any, thisArg: Any = definedExternally): BigInt64Array
    fun <U> from(arrayLike: ArrayLike<U>, mapfn: (v: U, k: Number) -> Any): BigInt64Array
}

external interface BigUint64Array : RelativeIndexable<Any> {
    var BYTES_PER_ELEMENT: Number
    var buffer: dynamic /* SharedArrayBuffer | ArrayBuffer */
        get() = definedExternally
        set(value) = definedExternally
    var byteLength: Number
    var byteOffset: Number
    fun copyWithin(target: Number, start: Number, end: Number = definedExternally): BigUint64Array /* this */
    fun entries(): IterableIterator<dynamic /* JsTuple<Number, Any> */>
    fun every(callbackfn: (value: Any, index: Number, array: BigUint64Array) -> Boolean, thisArg: Any = definedExternally): Boolean
    fun fill(value: Any, start: Number = definedExternally, end: Number = definedExternally): BigUint64Array /* this */
    fun filter(callbackfn: (value: Any, index: Number, array: BigUint64Array) -> Any, thisArg: Any = definedExternally): BigUint64Array
    fun find(predicate: (value: Any, index: Number, array: BigUint64Array) -> Boolean, thisArg: Any = definedExternally): Any?
    fun findIndex(predicate: (value: Any, index: Number, array: BigUint64Array) -> Boolean, thisArg: Any = definedExternally): Number
    fun forEach(callbackfn: (value: Any, index: Number, array: BigUint64Array) -> Unit, thisArg: Any = definedExternally)
    fun includes(searchElement: Any, fromIndex: Number = definedExternally): Boolean
    fun indexOf(searchElement: Any, fromIndex: Number = definedExternally): Number
    fun join(separator: String = definedExternally): String
    fun keys(): IterableIterator<Number>
    fun lastIndexOf(searchElement: Any, fromIndex: Number = definedExternally): Number
    var length: Number
    fun map(callbackfn: (value: Any, index: Number, array: BigUint64Array) -> Any, thisArg: Any = definedExternally): BigUint64Array
    fun reduce(callbackfn: (previousValue: Any, currentValue: Any, currentIndex: Number, array: BigUint64Array) -> Any): Any
    fun <U> reduce(callbackfn: (previousValue: U, currentValue: Any, currentIndex: Number, array: BigUint64Array) -> U, initialValue: U): U
    fun reduceRight(callbackfn: (previousValue: Any, currentValue: Any, currentIndex: Number, array: BigUint64Array) -> Any): Any
    fun <U> reduceRight(callbackfn: (previousValue: U, currentValue: Any, currentIndex: Number, array: BigUint64Array) -> U, initialValue: U): U
    fun reverse(): BigUint64Array /* this */
    fun set(array: ArrayLike<Any>, offset: Number = definedExternally)
    fun set(array: ArrayLike<Any>)
    fun slice(start: Number = definedExternally, end: Number = definedExternally): BigUint64Array
    fun some(callbackfn: (value: Any, index: Number, array: BigUint64Array) -> Boolean, thisArg: Any = definedExternally): Boolean
    fun sort(compareFn: (a: Any, b: Any) -> Any = definedExternally): BigUint64Array /* this */
    fun subarray(begin: Number = definedExternally, end: Number = definedExternally): BigUint64Array
    fun toLocaleString(): String
    override fun toString(): String
    fun valueOf(): BigUint64Array
    fun values(): IterableIterator<Any>
    @nativeGetter
    operator fun get(index: Number): Any?
    @nativeSetter
    operator fun set(index: Number, value: Any)
}

external interface BigUint64ArrayConstructor {
    var prototype: BigUint64Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Any): BigUint64Array
    fun from(arrayLike: ArrayLike<Any>): BigUint64Array
    fun <U> from(arrayLike: ArrayLike<U>, mapfn: (v: U, k: Number) -> Any, thisArg: Any = definedExternally): BigUint64Array
    fun <U> from(arrayLike: ArrayLike<U>, mapfn: (v: U, k: Number) -> Any): BigUint64Array
}