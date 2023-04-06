@file:JsModule("net")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package net

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
import tsstdlib.AbortSignal
import stream.internal.Duplex
import buffer.global.Buffer
import events.EventEmitter.Abortable
import events.EventEmitter

external interface AddressInfo {
    var address: String
    var family: String
    var port: Number
}

external interface SocketConstructorOpts {
    var fd: Number?
        get() = definedExternally
        set(value) = definedExternally
    var allowHalfOpen: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var readable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var writable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var signal: AbortSignal?
        get() = definedExternally
        set(value) = definedExternally
}

external interface OnReadOpts {
    var buffer: dynamic /* Uint8Array | () -> Uint8Array */
        get() = definedExternally
        set(value) = definedExternally
    fun callback(bytesWritten: Number, buf: Uint8Array): Boolean
}

external interface ConnectOpts {
    var onread: OnReadOpts?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TcpSocketConnectOpts : ConnectOpts {
    var port: Number
    var host: String?
        get() = definedExternally
        set(value) = definedExternally
    var localAddress: String?
        get() = definedExternally
        set(value) = definedExternally
    var localPort: Number?
        get() = definedExternally
        set(value) = definedExternally
    var hints: Number?
        get() = definedExternally
        set(value) = definedExternally
    var family: Number?
        get() = definedExternally
        set(value) = definedExternally
    var lookup: LookupFunction?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IpcSocketConnectOpts : ConnectOpts {
    var path: String
}

external open class Socket(options: SocketConstructorOpts = definedExternally) : Duplex {
    open fun write(buffer: Uint8Array, cb: (err: Error) -> Unit = definedExternally): Boolean
    override fun write(chunk: Any, cb: (error: Error?) -> Unit): Boolean
    open fun write(buffer: Uint8Array): Boolean
    override fun write(chunk: Any): Boolean
    open fun write(buffer: String, cb: (err: Error) -> Unit = definedExternally): Boolean
    open fun write(buffer: String): Boolean
    open fun write(str: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, cb: (err: Error) -> Unit = definedExternally): Boolean
    override fun write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, cb: (error: Error?) -> Unit): Boolean
    open fun write(str: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    override fun write(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Boolean
    open fun write(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, cb: (err: Error) -> Unit = definedExternally): Boolean
    open fun write(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    open fun connect(options: TcpSocketConnectOpts, connectionListener: () -> Unit = definedExternally): Socket /* this */
    open fun connect(options: TcpSocketConnectOpts): Socket /* this */
    open fun connect(options: IpcSocketConnectOpts, connectionListener: () -> Unit = definedExternally): Socket /* this */
    open fun connect(options: IpcSocketConnectOpts): Socket /* this */
    open fun connect(port: Number, host: String, connectionListener: () -> Unit = definedExternally): Socket /* this */
    open fun connect(port: Number, host: String): Socket /* this */
    open fun connect(port: Number, connectionListener: () -> Unit = definedExternally): Socket /* this */
    open fun connect(port: Number): Socket /* this */
    open fun connect(path: String, connectionListener: () -> Unit = definedExternally): Socket /* this */
    open fun connect(path: String): Socket /* this */
    override fun setEncoding(encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Socket /* this */
    override fun pause(): Socket /* this */
    override fun resume(): Socket /* this */
    open fun setTimeout(timeout: Number, callback: () -> Unit = definedExternally): Socket /* this */
    open fun setNoDelay(noDelay: Boolean = definedExternally): Socket /* this */
    open fun setKeepAlive(enable: Boolean = definedExternally, initialDelay: Number = definedExternally): Socket /* this */
    open fun address(): dynamic /* AddressInfo | Any */
    open fun unref(): Socket /* this */
    open fun ref(): Socket /* this */
    open var bufferSize: Number
    open var bytesRead: Number
    open var bytesWritten: Number
    open var connecting: Boolean
    override var destroyed: Boolean
    open var localAddress: String
    open var localPort: Number
    open var remoteAddress: String?
    open var remoteFamily: String?
    open var remotePort: Number?
    override fun end(callback: () -> Unit): Socket /* this */
    override fun end(): Socket /* this */
    open fun end(buffer: Uint8Array, callback: () -> Unit = definedExternally): Socket /* this */
    override fun end(chunk: Any, cb: () -> Unit): Duplex /* this */
    open fun end(buffer: Uint8Array): Socket /* this */
    override fun end(chunk: Any): Duplex /* this */
    open fun end(buffer: String, callback: () -> Unit = definedExternally): Socket /* this */
    open fun end(buffer: String): Socket /* this */
    open fun end(str: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, callback: () -> Unit = definedExternally): Socket /* this */
    override fun end(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, cb: () -> Unit): Duplex /* this */
    open fun end(str: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Socket /* this */
    override fun end(chunk: Any, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Duplex /* this */
    open fun end(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, callback: () -> Unit = definedExternally): Socket /* this */
    open fun end(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Socket /* this */
    override fun addListener(event: String, listener: (args: Any) -> Unit): Socket /* this */
    open fun addListener(event: String /* "close" */, listener: (hadError: Boolean) -> Unit): Socket /* this */
    override fun addListener(event: String /* "connect" | "drain" | "end" | "ready" | "timeout" */, listener: () -> Unit): Socket /* this */
    open fun addListener(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */
    override fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */
    open fun addListener(event: String /* "lookup" */, listener: (err: Error, address: String, family: Any /* String | Number */, host: String) -> Unit): Socket /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "close" */, hadError: Boolean): Boolean
    override fun emit(event: String /* "data" */, chunk: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(event: String /* "connect" | "drain" | "end" | "ready" | "timeout" */): Boolean
    open fun emit(event: String /* "data" */, data: Buffer): Boolean
    override fun emit(event: String /* "error" */, err: Error): Boolean
    open fun emit(event: String /* "lookup" */, err: Error, address: String, family: String, host: String): Boolean
    open fun emit(event: String /* "lookup" */, err: Error, address: String, family: Number, host: String): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Socket /* this */
    open fun on(event: String /* "close" */, listener: (hadError: Boolean) -> Unit): Socket /* this */
    override fun on(event: String /* "connect" | "drain" | "end" | "ready" | "timeout" */, listener: () -> Unit): Socket /* this */
    open fun on(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */
    override fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */
    open fun on(event: String /* "lookup" */, listener: (err: Error, address: String, family: Any /* String | Number */, host: String) -> Unit): Socket /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Socket /* this */
    open fun once(event: String /* "close" */, listener: (hadError: Boolean) -> Unit): Socket /* this */
    override fun once(event: String /* "connect" | "drain" | "end" | "ready" | "timeout" */, listener: () -> Unit): Socket /* this */
    open fun once(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */
    override fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */
    open fun once(event: String /* "lookup" */, listener: (err: Error, address: String, family: Any /* String | Number */, host: String) -> Unit): Socket /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Socket /* this */
    open fun prependListener(event: String /* "close" */, listener: (hadError: Boolean) -> Unit): Socket /* this */
    override fun prependListener(event: String /* "connect" | "drain" | "end" | "ready" | "timeout" */, listener: () -> Unit): Socket /* this */
    open fun prependListener(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */
    override fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */
    open fun prependListener(event: String /* "lookup" */, listener: (err: Error, address: String, family: Any /* String | Number */, host: String) -> Unit): Socket /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Socket /* this */
    open fun prependOnceListener(event: String /* "close" */, listener: (hadError: Boolean) -> Unit): Socket /* this */
    override fun prependOnceListener(event: String /* "connect" | "drain" | "end" | "ready" | "timeout" */, listener: () -> Unit): Socket /* this */
    open fun prependOnceListener(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */
    override fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */
    open fun prependOnceListener(event: String /* "lookup" */, listener: (err: Error, address: String, family: Any /* String | Number */, host: String) -> Unit): Socket /* this */
}

external interface ListenOptions : Abortable {
    var port: Number?
        get() = definedExternally
        set(value) = definedExternally
    var host: String?
        get() = definedExternally
        set(value) = definedExternally
    var backlog: Number?
        get() = definedExternally
        set(value) = definedExternally
    var path: String?
        get() = definedExternally
        set(value) = definedExternally
    var exclusive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var readableAll: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var writableAll: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ipv6Only: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ServerOpts {
    var allowHalfOpen: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var pauseOnConnect: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Server : EventEmitter {
    constructor(connectionListener: (socket: Socket) -> Unit = definedExternally)
    constructor()
    constructor(options: ServerOpts = definedExternally, connectionListener: (socket: Socket) -> Unit = definedExternally)
    constructor(options: ServerOpts = definedExternally)
    open fun listen(port: Number = definedExternally, hostname: String = definedExternally, backlog: Number = definedExternally, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(): Server /* this */
    open fun listen(port: Number = definedExternally): Server /* this */
    open fun listen(port: Number = definedExternally, hostname: String = definedExternally): Server /* this */
    open fun listen(port: Number = definedExternally, hostname: String = definedExternally, backlog: Number = definedExternally): Server /* this */
    open fun listen(port: Number = definedExternally, hostname: String = definedExternally, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(port: Number = definedExternally, backlog: Number = definedExternally, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(port: Number = definedExternally, backlog: Number = definedExternally): Server /* this */
    open fun listen(port: Number = definedExternally, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(path: String, backlog: Number = definedExternally, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(path: String): Server /* this */
    open fun listen(path: String, backlog: Number = definedExternally): Server /* this */
    open fun listen(path: String, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(options: ListenOptions, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(options: ListenOptions): Server /* this */
    open fun listen(handle: Any, backlog: Number = definedExternally, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun listen(handle: Any): Server /* this */
    open fun listen(handle: Any, backlog: Number = definedExternally): Server /* this */
    open fun listen(handle: Any, listeningListener: () -> Unit = definedExternally): Server /* this */
    open fun close(callback: (err: Error) -> Unit = definedExternally): Server /* this */
    open fun address(): dynamic /* AddressInfo? | String? */
    open fun getConnections(cb: (error: Error?, count: Number) -> Unit)
    open fun ref(): Server /* this */
    open fun unref(): Server /* this */
    open var maxConnections: Number
    open var connections: Number
    open var listening: Boolean
    override fun addListener(event: String, listener: (args: Any) -> Unit): Server /* this */
    open fun addListener(event: String /* "close" | "listening" */, listener: () -> Unit): Server /* this */
    open fun addListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "close" | "listening" */): Boolean
    open fun emit(event: String /* "connection" */, socket: Socket): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "error" */, err: Error): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Server /* this */
    open fun on(event: String /* "close" | "listening" */, listener: () -> Unit): Server /* this */
    open fun on(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Server /* this */
    open fun once(event: String /* "close" | "listening" */, listener: () -> Unit): Server /* this */
    open fun once(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Server /* this */
    open fun prependListener(event: String /* "close" | "listening" */, listener: () -> Unit): Server /* this */
    open fun prependListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Server /* this */
    open fun prependOnceListener(event: String /* "close" | "listening" */, listener: () -> Unit): Server /* this */
    open fun prependOnceListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
}

external open class BlockList {
    open fun addAddress(address: String, type: String /* "ipv4" | "ipv6" */ = definedExternally)
    open fun addAddress(address: String)
    open fun addAddress(address: SocketAddress)
    open fun addRange(start: String, end: String, type: String /* "ipv4" | "ipv6" */ = definedExternally)
    open fun addRange(start: String, end: String)
    open fun addRange(start: SocketAddress, end: SocketAddress)
    open fun addSubnet(net: SocketAddress, prefix: Number)
    open fun addSubnet(net: String, prefix: Number, type: String /* "ipv4" | "ipv6" */ = definedExternally)
    open fun addSubnet(net: String, prefix: Number)
    open fun check(address: SocketAddress): Boolean
    open fun check(address: String, type: String /* "ipv4" | "ipv6" */ = definedExternally): Boolean
    open fun check(address: String): Boolean
}

external interface TcpNetConnectOpts : TcpSocketConnectOpts, SocketConstructorOpts {
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IpcNetConnectOpts : IpcSocketConnectOpts, SocketConstructorOpts {
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun createServer(connectionListener: (socket: Socket) -> Unit = definedExternally): Server

external fun createServer(): Server

external fun createServer(options: ServerOpts = definedExternally, connectionListener: (socket: Socket) -> Unit = definedExternally): Server

external fun createServer(options: ServerOpts = definedExternally): Server

external fun connect(options: TcpNetConnectOpts, connectionListener: () -> Unit = definedExternally): Socket

external fun connect(options: TcpNetConnectOpts): Socket

external fun connect(options: IpcNetConnectOpts, connectionListener: () -> Unit = definedExternally): Socket

external fun connect(options: IpcNetConnectOpts): Socket

external fun connect(port: Number, host: String = definedExternally, connectionListener: () -> Unit = definedExternally): Socket

external fun connect(port: Number): Socket

external fun connect(port: Number, host: String = definedExternally): Socket

external fun connect(path: String, connectionListener: () -> Unit = definedExternally): Socket

external fun connect(path: String): Socket

external fun createConnection(options: TcpNetConnectOpts, connectionListener: () -> Unit = definedExternally): Socket

external fun createConnection(options: TcpNetConnectOpts): Socket

external fun createConnection(options: IpcNetConnectOpts, connectionListener: () -> Unit = definedExternally): Socket

external fun createConnection(options: IpcNetConnectOpts): Socket

external fun createConnection(port: Number, host: String = definedExternally, connectionListener: () -> Unit = definedExternally): Socket

external fun createConnection(port: Number): Socket

external fun createConnection(port: Number, host: String = definedExternally): Socket

external fun createConnection(path: String, connectionListener: () -> Unit = definedExternally): Socket

external fun createConnection(path: String): Socket

external fun isIP(input: String): Number

external fun isIPv4(input: String): Boolean

external fun isIPv6(input: String): Boolean

external interface SocketAddressInitOptions {
    var address: String?
        get() = definedExternally
        set(value) = definedExternally
    var family: String? /* "ipv4" | "ipv6" */
        get() = definedExternally
        set(value) = definedExternally
    var flowlabel: Number?
        get() = definedExternally
        set(value) = definedExternally
    var port: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class SocketAddress(options: SocketAddressInitOptions) {
    open var address: String
    open var family: String /* "ipv4" | "ipv6" */
    open var port: Number
    open var flowlabel: Number
}