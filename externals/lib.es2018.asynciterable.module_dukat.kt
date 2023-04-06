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
import tsstdlib.PromiseLike

external interface `L$1`<TReturn, T> {
    @nativeInvoke
    operator fun invoke(value: TReturn = definedExternally): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
    @nativeInvoke
    operator fun invoke(): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
    @nativeInvoke
    operator fun invoke(value: PromiseLike<TReturn> = definedExternally): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
}

external interface AsyncIterator<T, TReturn, TNext> {
    fun next(vararg args: Any /* JsTuple<> | JsTuple<TNext> */): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
    val `return`: `L$1`<TReturn, T>?
        get() = definedExternally
    val `throw`: ((e: Any) -> Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>)?
}

external interface AsyncIterator__1<T> : AsyncIterator<T, Any, Nothing?>

external interface AsyncIterable<T>

external interface AsyncIterableIterator<T> : AsyncIterator__1<T>