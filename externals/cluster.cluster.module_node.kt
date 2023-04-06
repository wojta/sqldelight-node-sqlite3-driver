@file:JsModule("cluster")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package cluster

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
import child_process.ChildProcess
import net.Socket
import net.Server
import child_process.MessageOptions
import events.EventEmitter
import NodeJS.Dict

external interface ClusterSettings {
    var execArgv: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var exec: String?
        get() = definedExternally
        set(value) = definedExternally
    var args: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var silent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var stdio: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
    var uid: Number?
        get() = definedExternally
        set(value) = definedExternally
    var gid: Number?
        get() = definedExternally
        set(value) = definedExternally
    var inspectPort: dynamic /* Number? | (() -> Number)? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface Address {
    var address: String
    var port: Number
    var addressType: dynamic /* Number | "udp4" | "udp6" */
        get() = definedExternally
        set(value) = definedExternally
}

external open class Worker : EventEmitter {
    open var id: Number
    open var process: ChildProcess
    open fun send(message: String?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?): Boolean
    open fun send(message: Any?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?): Boolean
    open fun send(message: Number?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?): Boolean
    open fun send(message: Boolean?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?): Boolean
    open fun send(message: String?, sendHandle: Socket, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Socket): Boolean
    open fun send(message: String?, sendHandle: Server, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server): Boolean
    open fun send(message: Any?, sendHandle: Socket, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket): Boolean
    open fun send(message: Any?, sendHandle: Server, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server): Boolean
    open fun send(message: Number?, sendHandle: Socket, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket): Boolean
    open fun send(message: Number?, sendHandle: Server, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server): Boolean
    open fun send(message: Boolean?, sendHandle: Socket, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket): Boolean
    open fun send(message: Boolean?, sendHandle: Server, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server): Boolean
    open fun send(message: String?, sendHandle: Socket, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Socket, options: MessageOptions = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server, options: MessageOptions = definedExternally): Boolean
    open fun kill(signal: String = definedExternally)
    open fun destroy(signal: String = definedExternally)
    open fun disconnect()
    open fun isConnected(): Boolean
    open fun isDead(): Boolean
    open var exitedAfterDisconnect: Boolean
    override fun addListener(event: String, listener: (args: Any) -> Unit): Worker /* this */
    open fun addListener(event: String /* "disconnect" | "online" */, listener: () -> Unit): Worker /* this */
    open fun addListener(event: String /* "error" */, listener: (error: Error) -> Unit): Worker /* this */
    open fun addListener(event: String /* "exit" */, listener: (code: Number, signal: String) -> Unit): Worker /* this */
    open fun addListener(event: String /* "listening" */, listener: (address: Address) -> Unit): Worker /* this */
    open fun addListener(event: String /* "message" */, listener: (message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Worker /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "disconnect" | "online" */): Boolean
    open fun emit(event: String /* "error" */, error: Error): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "exit" */, code: Number, signal: String): Boolean
    open fun emit(event: String /* "listening" */, address: Address): Boolean
    open fun emit(event: String /* "message" */, message: Any, handle: Socket): Boolean
    open fun emit(event: String /* "message" */, message: Any, handle: Server): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Worker /* this */
    open fun on(event: String /* "disconnect" | "online" */, listener: () -> Unit): Worker /* this */
    open fun on(event: String /* "error" */, listener: (error: Error) -> Unit): Worker /* this */
    open fun on(event: String /* "exit" */, listener: (code: Number, signal: String) -> Unit): Worker /* this */
    open fun on(event: String /* "listening" */, listener: (address: Address) -> Unit): Worker /* this */
    open fun on(event: String /* "message" */, listener: (message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Worker /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Worker /* this */
    open fun once(event: String /* "disconnect" | "online" */, listener: () -> Unit): Worker /* this */
    open fun once(event: String /* "error" */, listener: (error: Error) -> Unit): Worker /* this */
    open fun once(event: String /* "exit" */, listener: (code: Number, signal: String) -> Unit): Worker /* this */
    open fun once(event: String /* "listening" */, listener: (address: Address) -> Unit): Worker /* this */
    open fun once(event: String /* "message" */, listener: (message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Worker /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Worker /* this */
    open fun prependListener(event: String /* "disconnect" | "online" */, listener: () -> Unit): Worker /* this */
    open fun prependListener(event: String /* "error" */, listener: (error: Error) -> Unit): Worker /* this */
    open fun prependListener(event: String /* "exit" */, listener: (code: Number, signal: String) -> Unit): Worker /* this */
    open fun prependListener(event: String /* "listening" */, listener: (address: Address) -> Unit): Worker /* this */
    open fun prependListener(event: String /* "message" */, listener: (message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Worker /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Worker /* this */
    open fun prependOnceListener(event: String /* "disconnect" | "online" */, listener: () -> Unit): Worker /* this */
    open fun prependOnceListener(event: String /* "error" */, listener: (error: Error) -> Unit): Worker /* this */
    open fun prependOnceListener(event: String /* "exit" */, listener: (code: Number, signal: String) -> Unit): Worker /* this */
    open fun prependOnceListener(event: String /* "listening" */, listener: (address: Address) -> Unit): Worker /* this */
    open fun prependOnceListener(event: String /* "message" */, listener: (message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Worker /* this */
}

external interface Cluster : EventEmitter {
    fun disconnect(callback: () -> Unit = definedExternally)
    fun fork(env: Any = definedExternally): Worker
    var isMaster: Boolean
    var isPrimary: Boolean
    var isWorker: Boolean
    var schedulingPolicy: Number
    var settings: ClusterSettings
    fun setupMaster(settings: ClusterSettings = definedExternally)
    fun setupPrimary(settings: ClusterSettings = definedExternally)
    var worker: Worker?
        get() = definedExternally
        set(value) = definedExternally
    var workers: Dict<Worker>?
        get() = definedExternally
        set(value) = definedExternally
    var SCHED_NONE: Number
    var SCHED_RR: Number
    override fun addListener(event: String, listener: (args: Any) -> Unit): Cluster /* this */
    fun addListener(event: String /* "disconnect" | "fork" | "online" */, listener: (worker: Worker) -> Unit): Cluster /* this */
    fun addListener(event: String /* "exit" */, listener: (worker: Worker, code: Number, signal: String) -> Unit): Cluster /* this */
    fun addListener(event: String /* "listening" */, listener: (worker: Worker, address: Address) -> Unit): Cluster /* this */
    fun addListener(event: String /* "message" */, listener: (worker: Worker, message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Cluster /* this */
    fun addListener(event: String /* "setup" */, listener: (settings: ClusterSettings) -> Unit): Cluster /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    fun emit(event: String /* "disconnect" | "fork" | "online" */, worker: Worker): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    fun emit(event: String /* "exit" */, worker: Worker, code: Number, signal: String): Boolean
    fun emit(event: String /* "listening" */, worker: Worker, address: Address): Boolean
    fun emit(event: String /* "message" */, worker: Worker, message: Any, handle: Socket): Boolean
    fun emit(event: String /* "message" */, worker: Worker, message: Any, handle: Server): Boolean
    fun emit(event: String /* "setup" */, settings: ClusterSettings): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Cluster /* this */
    fun on(event: String /* "disconnect" | "fork" | "online" */, listener: (worker: Worker) -> Unit): Cluster /* this */
    fun on(event: String /* "exit" */, listener: (worker: Worker, code: Number, signal: String) -> Unit): Cluster /* this */
    fun on(event: String /* "listening" */, listener: (worker: Worker, address: Address) -> Unit): Cluster /* this */
    fun on(event: String /* "message" */, listener: (worker: Worker, message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Cluster /* this */
    fun on(event: String /* "setup" */, listener: (settings: ClusterSettings) -> Unit): Cluster /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Cluster /* this */
    fun once(event: String /* "disconnect" | "fork" | "online" */, listener: (worker: Worker) -> Unit): Cluster /* this */
    fun once(event: String /* "exit" */, listener: (worker: Worker, code: Number, signal: String) -> Unit): Cluster /* this */
    fun once(event: String /* "listening" */, listener: (worker: Worker, address: Address) -> Unit): Cluster /* this */
    fun once(event: String /* "message" */, listener: (worker: Worker, message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Cluster /* this */
    fun once(event: String /* "setup" */, listener: (settings: ClusterSettings) -> Unit): Cluster /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Cluster /* this */
    fun prependListener(event: String /* "disconnect" | "fork" | "online" */, listener: (worker: Worker) -> Unit): Cluster /* this */
    fun prependListener(event: String /* "exit" */, listener: (worker: Worker, code: Number, signal: String) -> Unit): Cluster /* this */
    fun prependListener(event: String /* "listening" */, listener: (worker: Worker, address: Address) -> Unit): Cluster /* this */
    fun prependListener(event: String /* "message" */, listener: (worker: Worker, message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Cluster /* this */
    fun prependListener(event: String /* "setup" */, listener: (settings: ClusterSettings) -> Unit): Cluster /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Cluster /* this */
    fun prependOnceListener(event: String /* "disconnect" | "fork" | "online" */, listener: (worker: Worker) -> Unit): Cluster /* this */
    fun prependOnceListener(event: String /* "exit" */, listener: (worker: Worker, code: Number, signal: String) -> Unit): Cluster /* this */
    fun prependOnceListener(event: String /* "listening" */, listener: (worker: Worker, address: Address) -> Unit): Cluster /* this */
    fun prependOnceListener(event: String /* "message" */, listener: (worker: Worker, message: Any, handle: Any /* net.Socket | net.Server */) -> Unit): Cluster /* this */
    fun prependOnceListener(event: String /* "setup" */, listener: (settings: ClusterSettings) -> Unit): Cluster /* this */
}

@JsName("default")
external var cluster: Cluster