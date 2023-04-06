@file:JsModule("async_hooks")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package async_hooks

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

external fun executionAsyncId(): Number

external fun executionAsyncResource(): Any?

external fun triggerAsyncId(): Number

external interface HookCallbacks {
    val init: ((asyncId: Number, type: String, triggerAsyncId: Number, resource: Any?) -> Unit)?
    val before: ((asyncId: Number) -> Unit)?
    val after: ((asyncId: Number) -> Unit)?
    val promiseResolve: ((asyncId: Number) -> Unit)?
    val destroy: ((asyncId: Number) -> Unit)?
}

external interface AsyncHook {
    fun enable(): AsyncHook /* this */
    fun disable(): AsyncHook /* this */
}

external fun createHook(callbacks: HookCallbacks): AsyncHook

external interface AsyncResourceOptions {
    var triggerAsyncId: Number?
        get() = definedExternally
        set(value) = definedExternally
    var requireManualDestroy: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$64` {
    var asyncResource: AsyncResource
}

external open class AsyncResource {
    constructor(type: String, triggerAsyncId: Number = definedExternally)
    constructor(type: String)
    constructor(type: String, triggerAsyncId: AsyncResourceOptions = definedExternally)
    open fun <Func : (args: Any) -> Any> bind(fn: Func): Func /* Func & `T$64` */
    open fun <This, Result> runInAsyncScope(fn: (self: This, args: Any) -> Result, thisArg: This = definedExternally, vararg args: Any): Result
    open fun emitDestroy(): AsyncResource /* this */
    open fun asyncId(): Number
    open fun triggerAsyncId(): Number

    companion object {
        fun <Func : (self: ThisArg, args: Any) -> Any, ThisArg> bind(fn: Func, type: String = definedExternally, thisArg: ThisArg = definedExternally): Func /* Func & `T$64` */
    }
}

external open class AsyncLocalStorage<T> {
    open fun disable()
    open fun getStore(): T?
    open fun <R, TArgs : Array<Any>> run(store: T, callback: (args: TArgs) -> R, vararg args: TArgs): R
    open fun <R, TArgs : Array<Any>> exit(callback: (args: TArgs) -> R, vararg args: TArgs): R
    open fun enterWith(store: T)
}