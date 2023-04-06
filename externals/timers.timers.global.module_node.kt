@file:JsQualifier("timers.global")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package timers.global

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
import timers.global.NodeJS.Timeout
import timers.global.NodeJS.Timer
import timers.global.NodeJS.Immediate

external fun <TArgs : Array<Any>> setTimeout(callback: (args: TArgs) -> Unit, ms: Number = definedExternally, vararg args: TArgs): Timeout

external fun setTimeout(callback: (args: Unit) -> Unit, ms: Number = definedExternally): Timeout

external fun setTimeout(callback: (args: Unit) -> Unit): Timeout

external fun clearTimeout(timeoutId: Timeout)

external fun <TArgs : Array<Any>> setInterval(callback: (args: TArgs) -> Unit, ms: Number = definedExternally, vararg args: TArgs): Timer

external fun setInterval(callback: (args: Unit) -> Unit, ms: Number = definedExternally): Timer

external fun setInterval(callback: (args: Unit) -> Unit): Timer

external fun clearInterval(intervalId: Timeout)

external fun <TArgs : Array<Any>> setImmediate(callback: (args: TArgs) -> Unit, vararg args: TArgs): Immediate

external fun setImmediate(callback: (args: Unit) -> Unit): Immediate

external fun clearImmediate(immediateId: Immediate)

external fun queueMicrotask(callback: () -> Unit)