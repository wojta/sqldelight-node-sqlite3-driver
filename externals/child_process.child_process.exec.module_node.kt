@file:JsQualifier("child_process.exec")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package child_process.exec

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
import buffer.global.Buffer
import child_process.`T$65`
import child_process.PromiseWithChild
import child_process.`T$66`
import child_process.ExecOptions
import fs.ObjectEncodingOptions

external interface `T$67` {
    var stdout: String
    var stderr: String
}

external fun __promisify__(command: String): dynamic /* PromiseWithChild | PromiseWithChild */

external interface `T$68` {
    var stdout: Buffer
    var stderr: Buffer
}

external fun __promisify__(command: String, options: `T$65` /* `T$65` & ExecOptions */): PromiseWithChild<`T$68`>

external fun __promisify__(command: String, options: `T$66` /* `T$66` & ExecOptions */): PromiseWithChild<`T$67`>

external fun __promisify__(command: String, options: ExecOptions): PromiseWithChild<`T$67`>

external interface `T$69` {
    var stdout: dynamic /* String | Buffer */
        get() = definedExternally
        set(value) = definedExternally
    var stderr: dynamic /* String | Buffer */
        get() = definedExternally
        set(value) = definedExternally
}

external fun __promisify__(command: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecOptions */ = definedExternally): PromiseWithChild<`T$69`>