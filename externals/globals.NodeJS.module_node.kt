@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package NodeJS

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
import NodeModule
import worker_threads.Worker
import tsstdlib.ReadonlySet

external interface CallSite {
    fun getThis(): Any
    fun getTypeName(): String?
    fun getFunction(): Function<*>?
    fun getFunctionName(): String?
    fun getMethodName(): String?
    fun getFileName(): String?
    fun getLineNumber(): Number?
    fun getColumnNumber(): Number?
    fun getEvalOrigin(): String?
    fun isToplevel(): Boolean
    fun isEval(): Boolean
    fun isNative(): Boolean
    fun isConstructor(): Boolean
}

typealias ErrnoException = Error

external interface `T$5` {
    var end: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadableStream : events.global.NodeJS.EventEmitter {
    var readable: Boolean
    fun read(size: Number = definedExternally): dynamic /* String | Buffer */
    fun setEncoding(encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): ReadableStream /* this */
    fun pause(): ReadableStream /* this */
    fun resume(): ReadableStream /* this */
    fun isPaused(): Boolean
    fun <T : WritableStream> pipe(destination: T, options: `T$5` = definedExternally): T
    fun unpipe(destination: WritableStream = definedExternally): ReadableStream /* this */
    fun unshift(chunk: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)
    fun unshift(chunk: String)
    fun unshift(chunk: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)
    fun unshift(chunk: Uint8Array)
    fun wrap(oldStream: ReadableStream): ReadableStream /* this */
}

external interface WritableStream : events.global.NodeJS.EventEmitter {
    var writable: Boolean
    fun write(buffer: Uint8Array, cb: (err: Error?) -> Unit = definedExternally): Boolean
    fun write(buffer: Uint8Array): Boolean
    fun write(buffer: String, cb: (err: Error?) -> Unit = definedExternally): Boolean
    fun write(buffer: String): Boolean
    fun write(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, cb: (err: Error?) -> Unit = definedExternally): Boolean
    fun write(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    fun end(cb: () -> Unit = definedExternally): WritableStream /* this */
    fun end(): WritableStream /* this */
    fun end(data: String, cb: () -> Unit = definedExternally): WritableStream /* this */
    fun end(data: String): WritableStream /* this */
    fun end(data: Uint8Array, cb: () -> Unit = definedExternally): WritableStream /* this */
    fun end(data: Uint8Array): WritableStream /* this */
    fun end(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, cb: () -> Unit = definedExternally): WritableStream /* this */
    fun end(str: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): WritableStream /* this */
}

external interface ReadWriteStream : ReadableStream, WritableStream

external interface RefCounted {
    fun ref(): RefCounted /* this */
    fun unref(): RefCounted /* this */
}

external interface Require {
    @nativeInvoke
    operator fun invoke(id: String): Any
    var resolve: RequireResolve
    var cache: Dict<NodeModule>
    var extensions: RequireExtensions
    var main: Module?
}

external interface `T$6` {
    var paths: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RequireResolve {
    @nativeInvoke
    operator fun invoke(id: String, options: `T$6` = definedExternally): String
    fun paths(request: String): Array<String>?
}

external interface RequireExtensions : Dict<(m: Module, filename: String) -> Any> {
    @nativeGetter
    override operator fun get(key: String): ((m: Module, filename: String) -> Any)?
    @nativeSetter
    operator fun set(key: String, value: (m: Module, filename: String) -> Any)
}

external interface Module {
    var isPreloading: Boolean
    var exports: Any
    var require: Require
    var id: String
    var filename: String
    var loaded: Boolean
    var parent: Module?
    var children: Array<Module>
    var path: String
    var paths: Array<String>
}

external interface Dict<T> {
    @nativeGetter
    operator fun get(key: String): T?
    @nativeSetter
    operator fun set(key: String, value: T?)
}

external interface ReadOnlyDict<T> {
    @nativeGetter
    operator fun get(key: String): T?
    @nativeSetter
    operator fun set(key: String, value: T?)
}

external interface EventEmitter {
    fun addListener(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun addListener(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun on(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun on(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun once(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun once(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun removeListener(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun removeListener(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun off(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun off(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun removeAllListeners(event: String = definedExternally): events.global.NodeJS.EventEmitter /* this */
    fun removeAllListeners(): events.global.NodeJS.EventEmitter /* this */
    fun removeAllListeners(event: Any = definedExternally): events.global.NodeJS.EventEmitter /* this */
    fun setMaxListeners(n: Number): events.global.NodeJS.EventEmitter /* this */
    fun getMaxListeners(): Number
    fun listeners(eventName: String): Array<Function<*>>
    fun listeners(eventName: Any): Array<Function<*>>
    fun rawListeners(eventName: String): Array<Function<*>>
    fun rawListeners(eventName: Any): Array<Function<*>>
    fun emit(eventName: String, vararg args: Any): Boolean
    fun emit(eventName: Any, vararg args: Any): Boolean
    fun listenerCount(eventName: String): Number
    fun listenerCount(eventName: Any): Number
    fun prependListener(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun prependListener(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun prependOnceListener(eventName: String, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun prependOnceListener(eventName: Any, listener: (args: Any) -> Unit): events.global.NodeJS.EventEmitter /* this */
    fun eventNames(): Array<dynamic /* String | Any */>
}

external interface ReadStream : tty.ReadStream

external interface WriteStream : tty.WriteStream

external interface MemoryUsageFn {
    @nativeInvoke
    operator fun invoke(): process.global.NodeJS.MemoryUsage
    fun rss(): Number
}

external interface MemoryUsage {
    var rss: Number
    var heapTotal: Number
    var heapUsed: Number
    var external: Number
    var arrayBuffers: Number
}

external interface CpuUsage {
    var user: Number
    var system: Number
}

external interface ProcessRelease {
    var name: String
    var sourceUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var headersUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var libUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var lts: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ProcessVersions : Dict<String> {
    var http_parser: String
    var node: String
    var v8: String
    var ares: String
    var uv: String
    var zlib: String
    var modules: String
    var openssl: String
}

typealias BeforeExitListener = (code: Number) -> Unit

typealias DisconnectListener = () -> Unit

typealias ExitListener = (code: Number) -> Unit

typealias RejectionHandledListener = (promise: Promise<Any>) -> Unit

typealias UncaughtExceptionListener = (error: Error, origin: String /* "uncaughtException" | "unhandledRejection" */) -> Unit

typealias UnhandledRejectionListener = (reason: Any, promise: Promise<Any>) -> Unit

typealias WarningListener = (warning: Error) -> Unit

typealias MessageListener = (message: Any, sendHandle: Any) -> Unit

typealias SignalsListener = (signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */) -> Unit

typealias MultipleResolveListener = (type: String /* "resolve" | "reject" */, promise: Promise<Any>, value: Any) -> Unit

typealias WorkerListener = (worker: Worker) -> Unit

external interface Socket : ReadWriteStream {
    var isTTY: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ProcessEnv : Dict<String> {
    var TZ: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface HRTime {
    @nativeInvoke
    operator fun invoke(time: Any /* JsTuple<Number, Number> */ = definedExternally): dynamic /* JsTuple<Number, Number> */
    fun bigint(): Any
}

external interface ProcessReport {
    var directory: String
    var filename: String
    fun getReport(err: Error = definedExternally): String
    var reportOnFatalError: Boolean
    var reportOnSignal: Boolean
    var reportOnUncaughtException: Boolean
    var signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */
    fun writeReport(fileName: String = definedExternally): String
    fun writeReport(): String
    fun writeReport(error: Error = definedExternally): String
    fun writeReport(fileName: String = definedExternally, err: Error = definedExternally): String
}

external interface ResourceUsage {
    var fsRead: Number
    var fsWrite: Number
    var involuntaryContextSwitches: Number
    var ipcReceived: Number
    var ipcSent: Number
    var majorPageFault: Number
    var maxRSS: Number
    var minorPageFault: Number
    var sharedMemorySize: Number
    var signalsCount: Number
    var swappedOut: Number
    var systemCPUTime: Number
    var unsharedDataSize: Number
    var unsharedStackSize: Number
    var userCPUTime: Number
    var voluntaryContextSwitches: Number
}

external interface EmitWarningOptions {
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var code: String?
        get() = definedExternally
        set(value) = definedExternally
    var ctor: Function<*>?
        get() = definedExternally
        set(value) = definedExternally
    var detail: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$7` {
    var cflags: Array<Any>
    var default_configuration: String
    var defines: Array<String>
    var include_dirs: Array<String>
    var libraries: Array<String>
}

external interface `T$8` {
    var clang: Number
    var host_arch: String
    var node_install_npm: Boolean
    var node_install_waf: Boolean
    var node_prefix: String
    var node_shared_openssl: Boolean
    var node_shared_v8: Boolean
    var node_shared_zlib: Boolean
    var node_use_dtrace: Boolean
    var node_use_etw: Boolean
    var node_use_openssl: Boolean
    var target_arch: String
    var v8_no_strict_aliasing: Number
    var v8_use_snapshot: Boolean
    var visibility: String
}

external interface ProcessConfig {
    var target_defaults: process.global.NodeJS.`T$7`
    var variables: process.global.NodeJS.`T$8`
}

external interface `T$9` {
    var fd: Number /* 1 */
}

external interface `T$10` {
    var fd: Number /* 2 */
}

external interface `T$11` {
    var fd: Number /* 0 */
}

external interface `T$12` {
    var inspector: Boolean
    var debug: Boolean
    var uv: Boolean
    var ipv6: Boolean
    var tls_alpn: Boolean
    var tls_sni: Boolean
    var tls_ocsp: Boolean
    var tls: Boolean
}

external interface `T$13` {
    var swallowErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Process : events.global.NodeJS.EventEmitter {
    var stdout: process.global.NodeJS.WriteStream /* WriteStream & `T$9` */
    var stderr: process.global.NodeJS.WriteStream /* WriteStream & `T$10` */
    var stdin: process.global.NodeJS.ReadStream /* ReadStream & `T$11` */
    fun openStdin(): process.global.NodeJS.Socket
    var argv: Array<String>
    var argv0: String
    var execArgv: Array<String>
    var execPath: String
    fun abort(): Any
    fun chdir(directory: String)
    fun cwd(): String
    var debugPort: Number
    fun emitWarning(warning: String, ctor: Function<*> = definedExternally)
    fun emitWarning(warning: String)
    fun emitWarning(warning: Error, ctor: Function<*> = definedExternally)
    fun emitWarning(warning: Error)
    fun emitWarning(warning: String, type: String = definedExternally, ctor: Function<*> = definedExternally)
    fun emitWarning(warning: String, type: String = definedExternally)
    fun emitWarning(warning: Error, type: String = definedExternally, ctor: Function<*> = definedExternally)
    fun emitWarning(warning: Error, type: String = definedExternally)
    fun emitWarning(warning: String, type: String = definedExternally, code: String = definedExternally, ctor: Function<*> = definedExternally)
    fun emitWarning(warning: String, type: String = definedExternally, code: String = definedExternally)
    fun emitWarning(warning: Error, type: String = definedExternally, code: String = definedExternally, ctor: Function<*> = definedExternally)
    fun emitWarning(warning: Error, type: String = definedExternally, code: String = definedExternally)
    fun emitWarning(warning: String, options: process.global.NodeJS.EmitWarningOptions = definedExternally)
    fun emitWarning(warning: Error, options: process.global.NodeJS.EmitWarningOptions = definedExternally)
    var env: process.global.NodeJS.ProcessEnv
    fun exit(code: Number = definedExternally): Any
    var exitCode: Number?
        get() = definedExternally
        set(value) = definedExternally
    fun getgid(): Number
    fun setgid(id: Number)
    fun setgid(id: String)
    fun getuid(): Number
    fun setuid(id: Number)
    fun setuid(id: String)
    fun geteuid(): Number
    fun seteuid(id: Number)
    fun seteuid(id: String)
    fun getegid(): Number
    fun setegid(id: Number)
    fun setegid(id: String)
    fun getgroups(): Array<Number>
    fun setgroups(groups: Array<Any /* String | Number */>)
    fun setUncaughtExceptionCaptureCallback(cb: ((err: Error) -> Unit)?)
    fun hasUncaughtExceptionCaptureCallback(): Boolean
    var version: String
    var versions: process.global.NodeJS.ProcessVersions
    var config: process.global.NodeJS.ProcessConfig
    fun kill(pid: Number, signal: String = definedExternally): Boolean
    fun kill(pid: Number): Boolean
    fun kill(pid: Number, signal: Number = definedExternally): Boolean
    var pid: Number
    var ppid: Number
    var title: String
    var arch: String
    var platform: String /* "aix" | "android" | "darwin" | "freebsd" | "haiku" | "linux" | "openbsd" | "sunos" | "win32" | "cygwin" | "netbsd" */
    var mainModule: Module?
        get() = definedExternally
        set(value) = definedExternally
    var memoryUsage: process.global.NodeJS.MemoryUsageFn
    fun cpuUsage(previousValue: process.global.NodeJS.CpuUsage = definedExternally): process.global.NodeJS.CpuUsage
    fun nextTick(callback: Function<*>, vararg args: Any)
    var release: process.global.NodeJS.ProcessRelease
    var features: process.global.NodeJS.`T$12`
    fun umask(): Number
    fun umask(mask: String): Number
    fun umask(mask: Number): Number
    fun uptime(): Number
    var hrtime: process.global.NodeJS.HRTime
    val send: ((message: Any, sendHandle: Any, options: process.global.NodeJS.`T$13`, callback: (error: Error?) -> Unit) -> Boolean)?
    fun disconnect()
    var connected: Boolean
    var allowedNodeEnvironmentFlags: ReadonlySet<String>
    var report: process.global.NodeJS.ProcessReport?
        get() = definedExternally
        set(value) = definedExternally
    fun resourceUsage(): process.global.NodeJS.ResourceUsage
    var traceDeprecation: Boolean
    fun addListener(event: String /* "beforeExit" | "exit" */, listener: process.global.NodeJS.BeforeExitListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "disconnect" */, listener: process.global.NodeJS.DisconnectListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "rejectionHandled" */, listener: process.global.NodeJS.RejectionHandledListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: process.global.NodeJS.UncaughtExceptionListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "unhandledRejection" */, listener: process.global.NodeJS.UnhandledRejectionListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "warning" */, listener: process.global.NodeJS.WarningListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "message" */, listener: process.global.NodeJS.MessageListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: process.global.NodeJS.SignalsListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "multipleResolves" */, listener: process.global.NodeJS.MultipleResolveListener): process.global.NodeJS.Process /* this */
    fun addListener(event: String /* "worker" */, listener: process.global.NodeJS.WorkerListener): process.global.NodeJS.Process /* this */
    fun emit(event: String /* "beforeExit" | "exit" */, code: Number): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    fun emit(event: String /* "disconnect" */): Boolean
    fun emit(event: String /* "rejectionHandled" */, promise: Promise<Any>): Boolean
    fun emit(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" | "warning" */, error: Error): Boolean
    fun emit(event: String /* "unhandledRejection" */, reason: Any, promise: Promise<Any>): Boolean
    fun emit(event: String /* "message" */, message: Any, sendHandle: Any): process.global.NodeJS.Process /* this */
    fun emit(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */): Boolean
    fun emit(event: String /* "multipleResolves" */, type: String /* "resolve" | "reject" */, promise: Promise<Any>, value: Any): process.global.NodeJS.Process /* this */
    fun emit(event: String /* "worker" */, listener: process.global.NodeJS.WorkerListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "beforeExit" | "exit" */, listener: process.global.NodeJS.BeforeExitListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "disconnect" */, listener: process.global.NodeJS.DisconnectListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "rejectionHandled" */, listener: process.global.NodeJS.RejectionHandledListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: process.global.NodeJS.UncaughtExceptionListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "unhandledRejection" */, listener: process.global.NodeJS.UnhandledRejectionListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "warning" */, listener: process.global.NodeJS.WarningListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "message" */, listener: process.global.NodeJS.MessageListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: process.global.NodeJS.SignalsListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "multipleResolves" */, listener: process.global.NodeJS.MultipleResolveListener): process.global.NodeJS.Process /* this */
    fun on(event: String /* "worker" */, listener: process.global.NodeJS.WorkerListener): process.global.NodeJS.Process /* this */
    override fun on(event: String, listener: (args: Any) -> Unit): process.global.NodeJS.Process /* this */
    override fun on(event: Any, listener: (args: Any) -> Unit): process.global.NodeJS.Process /* this */
    fun once(event: String /* "beforeExit" | "exit" */, listener: process.global.NodeJS.BeforeExitListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "disconnect" */, listener: process.global.NodeJS.DisconnectListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "rejectionHandled" */, listener: process.global.NodeJS.RejectionHandledListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: process.global.NodeJS.UncaughtExceptionListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "unhandledRejection" */, listener: process.global.NodeJS.UnhandledRejectionListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "warning" */, listener: process.global.NodeJS.WarningListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "message" */, listener: process.global.NodeJS.MessageListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: process.global.NodeJS.SignalsListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "multipleResolves" */, listener: process.global.NodeJS.MultipleResolveListener): process.global.NodeJS.Process /* this */
    fun once(event: String /* "worker" */, listener: process.global.NodeJS.WorkerListener): process.global.NodeJS.Process /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): process.global.NodeJS.Process /* this */
    override fun once(event: Any, listener: (args: Any) -> Unit): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "beforeExit" | "exit" */, listener: process.global.NodeJS.BeforeExitListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "disconnect" */, listener: process.global.NodeJS.DisconnectListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "rejectionHandled" */, listener: process.global.NodeJS.RejectionHandledListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: process.global.NodeJS.UncaughtExceptionListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "unhandledRejection" */, listener: process.global.NodeJS.UnhandledRejectionListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "warning" */, listener: process.global.NodeJS.WarningListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "message" */, listener: process.global.NodeJS.MessageListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: process.global.NodeJS.SignalsListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "multipleResolves" */, listener: process.global.NodeJS.MultipleResolveListener): process.global.NodeJS.Process /* this */
    fun prependListener(event: String /* "worker" */, listener: process.global.NodeJS.WorkerListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "beforeExit" | "exit" */, listener: process.global.NodeJS.BeforeExitListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "disconnect" */, listener: process.global.NodeJS.DisconnectListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "rejectionHandled" */, listener: process.global.NodeJS.RejectionHandledListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: process.global.NodeJS.UncaughtExceptionListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "unhandledRejection" */, listener: process.global.NodeJS.UnhandledRejectionListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "warning" */, listener: process.global.NodeJS.WarningListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "message" */, listener: process.global.NodeJS.MessageListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: process.global.NodeJS.SignalsListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "multipleResolves" */, listener: process.global.NodeJS.MultipleResolveListener): process.global.NodeJS.Process /* this */
    fun prependOnceListener(event: String /* "worker" */, listener: process.global.NodeJS.WorkerListener): process.global.NodeJS.Process /* this */
    override fun listeners(event: String /* "beforeExit" | "disconnect" | "exit" | "rejectionHandled" | "uncaughtException" | "uncaughtExceptionMonitor" | "unhandledRejection" | "warning" | "message" | "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | "multipleResolves" | "worker" */): dynamic /* Array */
}

external interface Timer : RefCounted {
    fun hasRef(): Boolean
    fun refresh(): timers.global.NodeJS.Timer /* this */
}

external interface Immediate : RefCounted {
    fun hasRef(): Boolean
    var _onImmediate: Function<*>
}

external interface Timeout : timers.global.NodeJS.Timer {
    override fun hasRef(): Boolean
    override fun refresh(): timers.global.NodeJS.Timeout /* this */
}