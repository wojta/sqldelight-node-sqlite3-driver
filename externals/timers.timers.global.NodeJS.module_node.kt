@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package timers.global.NodeJS

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
import NodeJS.RefCounted

external interface Timer : RefCounted {
    fun hasRef(): Boolean
    fun refresh(): Timer /* this */
}

external interface Immediate : RefCounted {
    fun hasRef(): Boolean
    var _onImmediate: Function<*>
}

external interface Timeout : Timer {
    override fun hasRef(): Boolean
    override fun refresh(): Timeout /* this */
}