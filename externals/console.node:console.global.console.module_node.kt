@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package node:console.global.console

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
import NodeJS.WritableStream
import util.InspectOptions

external interface ConsoleConstructorOptions {
    var stdout: WritableStream
    var stderr: WritableStream?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var colorMode: dynamic /* Boolean? | "auto" */
        get() = definedExternally
        set(value) = definedExternally
    var inspectOptions: InspectOptions?
        get() = definedExternally
        set(value) = definedExternally
    var groupIndentation: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ConsoleConstructor {
    var prototype: Console
}