@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package tsstdlib

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

typealias Generator<T, TReturn, TNext> = Iterator<T, TReturn, TNext>

external interface Generator__0 : Generator<Any, Any, Any>

external interface GeneratorFunction {
    @nativeInvoke
    operator fun invoke(vararg args: Any): Generator__0
    var length: Number
    var name: String
    var prototype: Generator__0
}