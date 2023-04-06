@file:JsModule("domain")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package domain

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
import events.EventEmitter
import timers.global.NodeJS.Timer

external open class Domain : EventEmitter {
    open var members: Array<dynamic /* EventEmitter | NodeJS.Timer */>
    open fun enter()
    open fun exit()
    open fun <T> run(fn: (args: Any) -> T, vararg args: Any): T
    open fun add(emitter: EventEmitter)
    open fun add(emitter: Timer)
    open fun remove(emitter: EventEmitter)
    open fun remove(emitter: Timer)
    open fun <T : Function<*>> bind(callback: T): T
    open fun <T : Function<*>> intercept(callback: T): T
}

external fun create(): Domain