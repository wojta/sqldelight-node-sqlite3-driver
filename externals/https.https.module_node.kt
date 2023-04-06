@file:JsModule("https")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package https

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
import tls.ConnectionOptions
import http.RequestListener
import http.ServerOptions
import net.Socket
import stream.internal.Duplex
import http.IncomingMessage
import buffer.global.Buffer
import http.ServerResponse
import tls.TLSSocket
import net.ServerOpts
import net.ListenOptions
import tls.SecureContextOptions
import http.RequestOptions
import http.ClientRequest
import url.URL

external interface `T$72` {
    var rejectUnauthorized: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var servername: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AgentOptions : http.AgentOptions, ConnectionOptions {
    override var rejectUnauthorized: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var maxCachedSessions: Number?
        get() = definedExternally
        set(value) = definedExternally
    override var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Agent(options: AgentOptions = definedExternally) : http.Agent {
    open var options: AgentOptions
}

external open class Server : tls.Server {
    constructor(requestListener: RequestListener = definedExternally)
    constructor()
    constructor(options: ServerOptions, requestListener: RequestListener = definedExternally)
    constructor(options: ServerOptions)
    open fun setTimeout(msecs: Number = definedExternally, callback: () -> Unit = definedExternally): Server /* this */
    open fun setTimeout(): Server /* this */
    open fun setTimeout(msecs: Number = definedExternally): Server /* this */
    open fun setTimeout(callback: () -> Unit): Server /* this */
    open var maxHeadersCount: Number?
    open var maxRequestsPerSocket: Number?
    open var timeout: Number
    open var headersTimeout: Number
    open var keepAliveTimeout: Number
    open var requestTimeout: Number
    override fun addListener(event: String, listener: (args: Any) -> Unit): Server /* this */
    override fun addListener(event: String /* "close" | "listening" | "close" | "listening" | "close" | "listening" */, listener: () -> Unit): Server /* this */
    override fun addListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    override fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    open fun addListener(event: String /* "checkContinue" | "checkExpectation" | "request" | "checkContinue" | "checkExpectation" | "request" */, listener: RequestListener): Server /* this */
    open fun addListener(event: String /* "clientError" */, listener: (err: Error, socket: Duplex) -> Unit): Server /* this */
    open fun addListener(event: String /* "connect" | "upgrade" | "connect" | "upgrade" */, listener: (req: IncomingMessage, socket: Duplex, head: Buffer) -> Unit): Server /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: String /* "close" | "listening" | "close" | "listening" | "close" | "listening" */): Boolean
    override fun emit(event: String /* "connection" */, socket: Socket): Boolean
    override fun emit(event: String /* "error" */, err: Error): Boolean
    open fun emit(event: String /* "checkContinue" | "checkExpectation" | "request" | "checkContinue" | "checkExpectation" | "request" */, req: IncomingMessage, res: ServerResponse): Boolean
    open fun emit(event: String /* "clientError" */, err: Error, socket: Duplex): Boolean
    override fun emit(event: String /* "tlsClientError" */, err: Error, tlsSocket: TLSSocket): Boolean
    open fun emit(event: String /* "connect" | "upgrade" | "connect" | "upgrade" */, req: IncomingMessage, socket: Duplex, head: Buffer): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Server /* this */
    override fun on(event: String /* "close" | "listening" | "close" | "listening" | "close" | "listening" */, listener: () -> Unit): Server /* this */
    override fun on(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    override fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    open fun on(event: String /* "checkContinue" | "checkExpectation" | "request" | "checkContinue" | "checkExpectation" | "request" */, listener: RequestListener): Server /* this */
    open fun on(event: String /* "clientError" */, listener: (err: Error, socket: Duplex) -> Unit): Server /* this */
    open fun on(event: String /* "connect" | "upgrade" | "connect" | "upgrade" */, listener: (req: IncomingMessage, socket: Duplex, head: Buffer) -> Unit): Server /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Server /* this */
    override fun once(event: String /* "close" | "listening" | "close" | "listening" | "close" | "listening" */, listener: () -> Unit): Server /* this */
    override fun once(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    override fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    open fun once(event: String /* "checkContinue" | "checkExpectation" | "request" | "checkContinue" | "checkExpectation" | "request" */, listener: RequestListener): Server /* this */
    open fun once(event: String /* "clientError" */, listener: (err: Error, socket: Duplex) -> Unit): Server /* this */
    open fun once(event: String /* "connect" | "upgrade" | "connect" | "upgrade" */, listener: (req: IncomingMessage, socket: Duplex, head: Buffer) -> Unit): Server /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Server /* this */
    override fun prependListener(event: String /* "close" | "listening" | "close" | "listening" | "close" | "listening" */, listener: () -> Unit): Server /* this */
    override fun prependListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    override fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    open fun prependListener(event: String /* "checkContinue" | "checkExpectation" | "request" | "checkContinue" | "checkExpectation" | "request" */, listener: RequestListener): Server /* this */
    open fun prependListener(event: String /* "clientError" */, listener: (err: Error, socket: Duplex) -> Unit): Server /* this */
    open fun prependListener(event: String /* "connect" | "upgrade" | "connect" | "upgrade" */, listener: (req: IncomingMessage, socket: Duplex, head: Buffer) -> Unit): Server /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "close" | "listening" | "close" | "listening" | "close" | "listening" */, listener: () -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */
    open fun prependOnceListener(event: String /* "checkContinue" | "checkExpectation" | "request" | "checkContinue" | "checkExpectation" | "request" */, listener: RequestListener): Server /* this */
    open fun prependOnceListener(event: String /* "clientError" */, listener: (err: Error, socket: Duplex) -> Unit): Server /* this */
    open fun prependOnceListener(event: String /* "connect" | "upgrade" | "connect" | "upgrade" */, listener: (req: IncomingMessage, socket: Duplex, head: Buffer) -> Unit): Server /* this */
    constructor(connectionListener: (socket: Socket) -> Unit = definedExternally)
    constructor(options: ServerOpts = definedExternally, connectionListener: (socket: Socket) -> Unit = definedExternally)
    constructor(options: ServerOpts = definedExternally)
    override fun listen(port: Number, hostname: String, backlog: Number, listeningListener: () -> Unit): Server /* this */
    override fun listen(): Server /* this */
    override fun listen(port: Number): Server /* this */
    override fun listen(port: Number, hostname: String): Server /* this */
    override fun listen(port: Number, hostname: String, backlog: Number): Server /* this */
    override fun listen(port: Number, hostname: String, listeningListener: () -> Unit): Server /* this */
    override fun listen(port: Number, backlog: Number, listeningListener: () -> Unit): Server /* this */
    override fun listen(port: Number, backlog: Number): Server /* this */
    override fun listen(port: Number, listeningListener: () -> Unit): Server /* this */
    override fun listen(path: String, backlog: Number, listeningListener: () -> Unit): Server /* this */
    override fun listen(path: String): Server /* this */
    override fun listen(path: String, backlog: Number): Server /* this */
    override fun listen(path: String, listeningListener: () -> Unit): Server /* this */
    override fun listen(options: ListenOptions, listeningListener: () -> Unit): Server /* this */
    override fun listen(options: ListenOptions): Server /* this */
    override fun listen(handle: Any, backlog: Number, listeningListener: () -> Unit): Server /* this */
    override fun listen(handle: Any): Server /* this */
    override fun listen(handle: Any, backlog: Number): Server /* this */
    override fun listen(handle: Any, listeningListener: () -> Unit): Server /* this */
    override fun close(callback: (err: Error) -> Unit): Server /* this */
    override fun address(): dynamic /* AddressInfo? | String? */
    override fun getConnections(cb: (error: Error?, count: Number) -> Unit)
    override fun ref(): Server /* this */
    override fun unref(): Server /* this */
    override var maxConnections: Number
    override var connections: Number
    override var listening: Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    override fun addListener(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun on(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun once(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun removeListener(eventName: String, listener: (args: Any) -> Unit): Server /* this */
    override fun removeListener(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun off(eventName: String, listener: (args: Any) -> Unit): Server /* this */
    override fun off(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun removeAllListeners(event: String): Server /* this */
    override fun removeAllListeners(): Server /* this */
    override fun removeAllListeners(event: Any): Server /* this */
    override fun setMaxListeners(n: Number): Server /* this */
    override fun getMaxListeners(): Number
    override fun listeners(eventName: String): Array<Function<*>>
    override fun listeners(eventName: Any): Array<Function<*>>
    override fun rawListeners(eventName: String): Array<Function<*>>
    override fun rawListeners(eventName: Any): Array<Function<*>>
    override fun listenerCount(eventName: String): Number
    override fun listenerCount(eventName: Any): Number
    override fun prependListener(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun prependOnceListener(eventName: Any, listener: (args: Any) -> Unit): Server /* this */
    override fun eventNames(): Array<dynamic /* String | Any */>
    constructor(options: SecureContextOptions, requestListener: RequestListener = definedExternally)
    constructor(options: SecureContextOptions)
    override fun addListener(event: String /* "keylog" */, listener: (line: Buffer, tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun addListener(event: String /* "newSession" */, listener: (sessionId: Buffer, sessionData: Buffer, callback: (err: Error, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun addListener(event: String /* "OCSPRequest" */, listener: (certificate: Buffer, issuer: Buffer, callback: (err: Error?, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun addListener(event: String /* "resumeSession" */, listener: (sessionId: Buffer, callback: (err: Error, sessionData: Buffer) -> Unit) -> Unit): Server /* this */
    override fun addListener(event: String /* "secureConnection" */, listener: (tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun addListener(event: String /* "tlsClientError" */, listener: (err: Error, tlsSocket: TLSSocket) -> Unit): Server /* this */
    open fun addListener(event: String /* "connection" */, listener: (socket: Duplex) -> Unit): Server /* this */
    override fun emit(event: String /* "keylog" */, line: Buffer, tlsSocket: TLSSocket): Boolean
    override fun emit(event: String /* "newSession" */, sessionId: Buffer, sessionData: Buffer, callback: (err: Error, resp: Buffer) -> Unit): Boolean
    override fun emit(event: String /* "OCSPRequest" */, certificate: Buffer, issuer: Buffer, callback: (err: Error?, resp: Buffer) -> Unit): Boolean
    override fun emit(event: String /* "resumeSession" */, sessionId: Buffer, callback: (err: Error, sessionData: Buffer) -> Unit): Boolean
    override fun emit(event: String /* "secureConnection" */, tlsSocket: TLSSocket): Boolean
    open fun emit(event: String /* "connection" */, socket: Duplex): Boolean
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun on(event: String /* "keylog" */, listener: (line: Buffer, tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun on(event: String /* "newSession" */, listener: (sessionId: Buffer, sessionData: Buffer, callback: (err: Error, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun on(event: String /* "OCSPRequest" */, listener: (certificate: Buffer, issuer: Buffer, callback: (err: Error?, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun on(event: String /* "resumeSession" */, listener: (sessionId: Buffer, callback: (err: Error, sessionData: Buffer) -> Unit) -> Unit): Server /* this */
    override fun on(event: String /* "secureConnection" */, listener: (tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun on(event: String /* "tlsClientError" */, listener: (err: Error, tlsSocket: TLSSocket) -> Unit): Server /* this */
    open fun on(event: String /* "connection" */, listener: (socket: Duplex) -> Unit): Server /* this */
    override fun once(event: String /* "keylog" */, listener: (line: Buffer, tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun once(event: String /* "newSession" */, listener: (sessionId: Buffer, sessionData: Buffer, callback: (err: Error, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun once(event: String /* "OCSPRequest" */, listener: (certificate: Buffer, issuer: Buffer, callback: (err: Error?, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun once(event: String /* "resumeSession" */, listener: (sessionId: Buffer, callback: (err: Error, sessionData: Buffer) -> Unit) -> Unit): Server /* this */
    override fun once(event: String /* "secureConnection" */, listener: (tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun once(event: String /* "tlsClientError" */, listener: (err: Error, tlsSocket: TLSSocket) -> Unit): Server /* this */
    open fun once(event: String /* "connection" */, listener: (socket: Duplex) -> Unit): Server /* this */
    override fun prependListener(event: String /* "keylog" */, listener: (line: Buffer, tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun prependListener(event: String /* "newSession" */, listener: (sessionId: Buffer, sessionData: Buffer, callback: (err: Error, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun prependListener(event: String /* "OCSPRequest" */, listener: (certificate: Buffer, issuer: Buffer, callback: (err: Error?, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun prependListener(event: String /* "resumeSession" */, listener: (sessionId: Buffer, callback: (err: Error, sessionData: Buffer) -> Unit) -> Unit): Server /* this */
    override fun prependListener(event: String /* "secureConnection" */, listener: (tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun prependListener(event: String /* "tlsClientError" */, listener: (err: Error, tlsSocket: TLSSocket) -> Unit): Server /* this */
    open fun prependListener(event: String /* "connection" */, listener: (socket: Duplex) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "keylog" */, listener: (line: Buffer, tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "newSession" */, listener: (sessionId: Buffer, sessionData: Buffer, callback: (err: Error, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "OCSPRequest" */, listener: (certificate: Buffer, issuer: Buffer, callback: (err: Error?, resp: Buffer) -> Unit) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "resumeSession" */, listener: (sessionId: Buffer, callback: (err: Error, sessionData: Buffer) -> Unit) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "secureConnection" */, listener: (tlsSocket: TLSSocket) -> Unit): Server /* this */
    override fun prependOnceListener(event: String /* "tlsClientError" */, listener: (err: Error, tlsSocket: TLSSocket) -> Unit): Server /* this */
    open fun prependOnceListener(event: String /* "connection" */, listener: (socket: Duplex) -> Unit): Server /* this */
}

external fun createServer(requestListener: RequestListener = definedExternally): Server

external fun createServer(): Server

external fun createServer(options: SecureContextOptions /* tls.SecureContextOptions & tls.TlsOptions & http.ServerOptions */, requestListener: RequestListener = definedExternally): Server

external fun createServer(options: SecureContextOptions /* tls.SecureContextOptions & tls.TlsOptions & http.ServerOptions */): Server

external fun request(options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun request(options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */): ClientRequest

external fun request(options: String, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun request(options: String): ClientRequest

external fun request(options: URL, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun request(options: URL): ClientRequest

external fun request(url: String, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun request(url: String, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */): ClientRequest

external fun request(url: URL, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun request(url: URL, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */): ClientRequest

external fun get(options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun get(options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */): ClientRequest

external fun get(options: String, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun get(options: String): ClientRequest

external fun get(options: URL, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun get(options: URL): ClientRequest

external fun get(url: String, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun get(url: String, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */): ClientRequest

external fun get(url: URL, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */, callback: (res: IncomingMessage) -> Unit = definedExternally): ClientRequest

external fun get(url: URL, options: RequestOptions /* http.RequestOptions & tls.SecureContextOptions & `T$72` */): ClientRequest

external var globalAgent: Agent