@file:JsModule("wasi")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package wasi

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
import NodeJS.Dict

external interface WASIOptions {
    var args: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var env: Any?
        get() = definedExternally
        set(value) = definedExternally
    var preopens: Dict<String>?
        get() = definedExternally
        set(value) = definedExternally
    var returnOnExit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var stdin: Number?
        get() = definedExternally
        set(value) = definedExternally
    var stdout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var stderr: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class WASI(options: WASIOptions = definedExternally) {
    open fun start(instance: Any?)
    open fun initialize(instance: Any?)
    open var wasiImport: Dict<Any>
}