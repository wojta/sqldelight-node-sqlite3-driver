@file:JsModule("diagnostics_channel")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package diagnostics_channel

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

external fun hasSubscribers(name: String): Boolean

external fun channel(name: String): Channel

external open class Channel(name: String) {
    open var name: String
    open var hasSubscribers: Boolean
    open fun subscribe(onMessage: ChannelListener)
    open fun unsubscribe(onMessage: ChannelListener)
}