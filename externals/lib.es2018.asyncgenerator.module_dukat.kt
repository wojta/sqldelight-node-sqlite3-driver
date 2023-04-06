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

external interface AsyncGenerator<T, TReturn, TNext> : AsyncIterator<T, TReturn, TNext> {
    override fun next(vararg args: Any /* JsTuple<> | JsTuple<TNext> */): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
    fun `return`(value: TReturn): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
    fun `return`(value: PromiseLike<TReturn>): Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
    override var `throw`: (e: Any) -> Promise<dynamic /* IteratorYieldResult<T> | IteratorReturnResult<TReturn> */>
}

external interface AsyncGenerator__0 : AsyncGenerator<Any, Any, Any>

external interface AsyncGeneratorFunction {
    @nativeInvoke
    operator fun invoke(vararg args: Any): AsyncGenerator__0
    var length: Number
    var name: String
    var prototype: AsyncGenerator__0
}