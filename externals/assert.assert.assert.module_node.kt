@file:JsModule("node:assert")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package assert.assert

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
import tsstdlib.Omit

external interface `T$0` {
    var message: String?
        get() = definedExternally
        set(value) = definedExternally
    var actual: Any?
        get() = definedExternally
        set(value) = definedExternally
    var expected: Any?
        get() = definedExternally
        set(value) = definedExternally
    var operator: String?
        get() = definedExternally
        set(value) = definedExternally
    var stackStartFn: Function<*>?
        get() = definedExternally
        set(value) = definedExternally
}

external open class CallTracker {
    open fun calls(exact: Number = definedExternally): () -> Unit
    open fun calls(): () -> Unit
    open fun <Func : (args: Any) -> Any> calls(fn: Func = definedExternally, exact: Number = definedExternally): Func
    open fun <Func : (args: Any) -> Any> calls(): Func
    open fun <Func : (args: Any) -> Any> calls(fn: Func = definedExternally): Func
    open fun report(): Array<CallTrackerReportInformation>
    open fun verify()
}

external interface CallTrackerReportInformation {
    var message: String
    var actual: Number
    var expected: Number
    var operator: String
    var stack: Any?
}

external fun fail(message: String = definedExternally): Any

external fun fail(): Any

external fun fail(message: Error = definedExternally): Any

external fun fail(actual: Any, expected: Any, message: String = definedExternally, operator: String = definedExternally, stackStartFn: Function<*> = definedExternally): Any

external fun fail(actual: Any, expected: Any): Any

external fun fail(actual: Any, expected: Any, message: String = definedExternally): Any

external fun fail(actual: Any, expected: Any, message: String = definedExternally, operator: String = definedExternally): Any

external fun fail(actual: Any, expected: Any, message: Error = definedExternally, operator: String = definedExternally, stackStartFn: Function<*> = definedExternally): Any

external fun fail(actual: Any, expected: Any, message: Error = definedExternally): Any

external fun fail(actual: Any, expected: Any, message: Error = definedExternally, operator: String = definedExternally): Any

external fun ok(value: Any, message: String = definedExternally): Boolean

external fun ok(value: Any): Boolean

external fun ok(value: Any, message: Error = definedExternally): Boolean

external fun equal(actual: Any, expected: Any, message: String = definedExternally)

external fun equal(actual: Any, expected: Any)

external fun equal(actual: Any, expected: Any, message: Error = definedExternally)

external fun notEqual(actual: Any, expected: Any, message: String = definedExternally)

external fun notEqual(actual: Any, expected: Any)

external fun notEqual(actual: Any, expected: Any, message: Error = definedExternally)

external fun deepEqual(actual: Any, expected: Any, message: String = definedExternally)

external fun deepEqual(actual: Any, expected: Any)

external fun deepEqual(actual: Any, expected: Any, message: Error = definedExternally)

external fun notDeepEqual(actual: Any, expected: Any, message: String = definedExternally)

external fun notDeepEqual(actual: Any, expected: Any)

external fun notDeepEqual(actual: Any, expected: Any, message: Error = definedExternally)

external fun <T> strictEqual(actual: Any, expected: T, message: String = definedExternally): Boolean

external fun <T> strictEqual(actual: Any, expected: T): Boolean

external fun <T> strictEqual(actual: Any, expected: T, message: Error = definedExternally): Boolean

external fun notStrictEqual(actual: Any, expected: Any, message: String = definedExternally)

external fun notStrictEqual(actual: Any, expected: Any)

external fun notStrictEqual(actual: Any, expected: Any, message: Error = definedExternally)

external fun <T> deepStrictEqual(actual: Any, expected: T, message: String = definedExternally): Boolean

external fun <T> deepStrictEqual(actual: Any, expected: T): Boolean

external fun <T> deepStrictEqual(actual: Any, expected: T, message: Error = definedExternally): Boolean

external fun notDeepStrictEqual(actual: Any, expected: Any, message: String = definedExternally)

external fun notDeepStrictEqual(actual: Any, expected: Any)

external fun notDeepStrictEqual(actual: Any, expected: Any, message: Error = definedExternally)

external fun throws(block: () -> Any, message: String = definedExternally)

external fun throws(block: () -> Any)

external fun throws(block: () -> Any, message: Error = definedExternally)

external fun throws(block: () -> Any, error: RegExp?, message: String = definedExternally)

external fun throws(block: () -> Any, error: RegExp?)

external fun throws(block: () -> Any, error: RegExp?, message: Error = definedExternally)

external fun throws(block: () -> Any, error: Any?, message: String = definedExternally)

external fun throws(block: () -> Any, error: Any?)

external fun throws(block: () -> Any, error: Any?, message: Error = definedExternally)

external fun throws(block: () -> Any, error: ((thrown: Any) -> Boolean)?, message: String = definedExternally)

external fun throws(block: () -> Any, error: ((thrown: Any) -> Boolean)?)

external fun throws(block: () -> Any, error: ((thrown: Any) -> Boolean)?, message: Error = definedExternally)

external fun throws(block: () -> Any, error: Error?, message: String = definedExternally)

external fun throws(block: () -> Any, error: Error?)

external fun throws(block: () -> Any, error: Error?, message: Error = definedExternally)

external fun doesNotThrow(block: () -> Any, message: String = definedExternally)

external fun doesNotThrow(block: () -> Any)

external fun doesNotThrow(block: () -> Any, message: Error = definedExternally)

external fun doesNotThrow(block: () -> Any, error: RegExp?, message: String = definedExternally)

external fun doesNotThrow(block: () -> Any, error: RegExp?)

external fun doesNotThrow(block: () -> Any, error: RegExp?, message: Error = definedExternally)

external fun doesNotThrow(block: () -> Any, error: Any?, message: String = definedExternally)

external fun doesNotThrow(block: () -> Any, error: Any?)

external fun doesNotThrow(block: () -> Any, error: Any?, message: Error = definedExternally)

external fun doesNotThrow(block: () -> Any, error: ((thrown: Any) -> Boolean)?, message: String = definedExternally)

external fun doesNotThrow(block: () -> Any, error: ((thrown: Any) -> Boolean)?)

external fun doesNotThrow(block: () -> Any, error: ((thrown: Any) -> Boolean)?, message: Error = definedExternally)

external fun doesNotThrow(block: () -> Any, error: Error?, message: String = definedExternally)

external fun doesNotThrow(block: () -> Any, error: Error?)

external fun doesNotThrow(block: () -> Any, error: Error?, message: Error = definedExternally)

external fun ifError(value: Any): Boolean

external fun rejects(block: () -> Promise<Any>, message: String = definedExternally): Promise<Unit>

external fun rejects(block: () -> Promise<Any>): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, message: Error = definedExternally): Promise<Unit>

external fun rejects(block: Promise<Any>, message: String = definedExternally): Promise<Unit>

external fun rejects(block: Promise<Any>): Promise<Unit>

external fun rejects(block: Promise<Any>, message: Error = definedExternally): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: RegExp?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: RegExp?): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: Any?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: Any?): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: ((thrown: Any) -> Boolean)?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: ((thrown: Any) -> Boolean)?): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: Error?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: () -> Promise<Any>, error: Error?): Promise<Unit>

external fun rejects(block: Promise<Any>, error: RegExp?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: Promise<Any>, error: RegExp?): Promise<Unit>

external fun rejects(block: Promise<Any>, error: Any?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: Promise<Any>, error: Any?): Promise<Unit>

external fun rejects(block: Promise<Any>, error: ((thrown: Any) -> Boolean)?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: Promise<Any>, error: ((thrown: Any) -> Boolean)?): Promise<Unit>

external fun rejects(block: Promise<Any>, error: Error?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun rejects(block: Promise<Any>, error: Error?): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, message: String = definedExternally): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, message: Error = definedExternally): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, message: String = definedExternally): Promise<Unit>

external fun doesNotReject(block: Promise<Any>): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, message: Error = definedExternally): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: RegExp?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: RegExp?): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: Any?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: Any?): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: ((thrown: Any) -> Boolean)?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: ((thrown: Any) -> Boolean)?): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: Error?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: () -> Promise<Any>, error: Error?): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: RegExp?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: RegExp?): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: Any?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: Any?): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: ((thrown: Any) -> Boolean)?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: ((thrown: Any) -> Boolean)?): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: Error?, message: Any /* String | Error */ = definedExternally): Promise<Unit>

external fun doesNotReject(block: Promise<Any>, error: Error?): Promise<Unit>

external fun match(value: String, regExp: RegExp, message: String = definedExternally)

external fun match(value: String, regExp: RegExp)

external fun match(value: String, regExp: RegExp, message: Error = definedExternally)

external fun doesNotMatch(value: String, regExp: RegExp, message: String = definedExternally)

external fun doesNotMatch(value: String, regExp: RegExp)

external fun doesNotMatch(value: String, regExp: RegExp, message: Error = definedExternally)

external interface `T$1` {
    @nativeInvoke
    operator fun invoke(value: Any, message: String = definedExternally): Boolean
    @nativeInvoke
    operator fun invoke(value: Any): Boolean
    @nativeInvoke
    operator fun invoke(value: Any, message: Error = definedExternally): Boolean
    var equal: Any
    var notEqual: Any
    var deepEqual: Any
    var notDeepEqual: Any
    var ok: Any
    var strictEqual: Any
    var deepStrictEqual: Any
    var ifError: Any
    var strict: Any
}

@JsModule("node:assert/strict")
external val strict: Omit<Any, String /* "equal" | "notEqual" | "deepEqual" | "notDeepEqual" | "ok" | "strictEqual" | "deepStrictEqual" | "ifError" | "strict" */> /* Omit<Any, String /* "equal" | "notEqual" | "deepEqual" | "notDeepEqual" | "ok" | "strictEqual" | "deepStrictEqual" | "ifError" | "strict" */> & `T$1` */