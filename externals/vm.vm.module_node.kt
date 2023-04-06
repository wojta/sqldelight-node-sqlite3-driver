@file:JsModule("vm")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vm

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
import buffer.global.Buffer

external interface Context : Dict<Any>

external interface BaseOptions {
    var filename: String?
        get() = definedExternally
        set(value) = definedExternally
    var lineOffset: Number?
        get() = definedExternally
        set(value) = definedExternally
    var columnOffset: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ScriptOptions : BaseOptions {
    var displayErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var cachedData: Buffer?
        get() = definedExternally
        set(value) = definedExternally
    var produceCachedData: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RunningScriptOptions : BaseOptions {
    var displayErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var breakOnSigint: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var microtaskMode: String? /* "afterEvaluate" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface CompileFunctionOptions : BaseOptions {
    var cachedData: Buffer?
        get() = definedExternally
        set(value) = definedExternally
    var produceCachedData: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var parsingContext: Context?
        get() = definedExternally
        set(value) = definedExternally
    var contextExtensions: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$74` {
    var strings: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var wasm: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CreateContextOptions {
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var origin: String?
        get() = definedExternally
        set(value) = definedExternally
    var codeGeneration: `T$74`?
        get() = definedExternally
        set(value) = definedExternally
    var microtaskMode: String? /* "afterEvaluate" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface MeasureMemoryOptions {
    var mode: String? /* "summary" | "detailed" */
        get() = definedExternally
        set(value) = definedExternally
    var context: Context?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$75` {
    var jsMemoryEstimate: Number
    var jsMemoryRange: dynamic /* JsTuple<Number, Number> */
        get() = definedExternally
        set(value) = definedExternally
}

external interface MemoryMeasurement {
    var total: `T$75`
}

external open class Script(code: String, options: ScriptOptions = definedExternally) {
    open fun runInContext(contextifiedObject: Context, options: RunningScriptOptions = definedExternally): Any
    open fun runInNewContext(contextObject: Context = definedExternally, options: RunningScriptOptions = definedExternally): Any
    open fun runInThisContext(options: RunningScriptOptions = definedExternally): Any
    open fun createCachedData(): Buffer
    open var cachedDataProduced: Boolean?
    open var cachedDataRejected: Boolean?
    open var cachedData: Buffer?
}

external fun createContext(sandbox: Context = definedExternally, options: CreateContextOptions = definedExternally): Context

external fun isContext(sandbox: Context): Boolean

external fun runInContext(code: String, contextifiedObject: Context, options: RunningScriptOptions = definedExternally): Any

external fun runInContext(code: String, contextifiedObject: Context): Any

external fun runInContext(code: String, contextifiedObject: Context, options: String = definedExternally): Any

external fun runInNewContext(code: String, contextObject: Context = definedExternally, options: RunningScriptOptions = definedExternally): Any

external fun runInNewContext(code: String): Any

external fun runInNewContext(code: String, contextObject: Context = definedExternally): Any

external fun runInNewContext(code: String, contextObject: Context = definedExternally, options: String = definedExternally): Any

external fun runInThisContext(code: String, options: RunningScriptOptions = definedExternally): Any

external fun runInThisContext(code: String): Any

external fun runInThisContext(code: String, options: String = definedExternally): Any

external fun compileFunction(code: String, params: Array<String> = definedExternally, options: CompileFunctionOptions = definedExternally): Function<*>

external fun measureMemory(options: MeasureMemoryOptions = definedExternally): Promise<MemoryMeasurement>