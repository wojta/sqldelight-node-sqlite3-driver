@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package process.global.NodeJS

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
import NodeJS.Dict
import worker_threads.Worker
import NodeJS.ReadWriteStream
import NodeJS.Module
import tsstdlib.ReadonlySet
import events.global.NodeJS.EventEmitter

external interface ReadStream : tty.ReadStream

external interface WriteStream : tty.WriteStream

external interface MemoryUsageFn {
    @nativeInvoke
    operator fun invoke(): MemoryUsage
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
    var target_defaults: `T$7`
    var variables: `T$8`
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

external interface Process : EventEmitter {
    var stdout: WriteStream /* WriteStream & `T$9` */
    var stderr: WriteStream /* WriteStream & `T$10` */
    var stdin: ReadStream /* ReadStream & `T$11` */
    fun openStdin(): Socket
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
    fun emitWarning(warning: String, options: EmitWarningOptions = definedExternally)
    fun emitWarning(warning: Error, options: EmitWarningOptions = definedExternally)
    var env: ProcessEnv
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
    var versions: ProcessVersions
    var config: ProcessConfig
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
    var memoryUsage: MemoryUsageFn
    fun cpuUsage(previousValue: CpuUsage = definedExternally): CpuUsage
    fun nextTick(callback: Function<*>, vararg args: Any)
    var release: ProcessRelease
    var features: `T$12`
    fun umask(): Number
    fun umask(mask: String): Number
    fun umask(mask: Number): Number
    fun uptime(): Number
    var hrtime: HRTime
    val send: ((message: Any, sendHandle: Any, options: `T$13`, callback: (error: Error?) -> Unit) -> Boolean)?
    fun disconnect()
    var connected: Boolean
    var allowedNodeEnvironmentFlags: ReadonlySet<String>
    var report: ProcessReport?
        get() = definedExternally
        set(value) = definedExternally
    fun resourceUsage(): ResourceUsage
    var traceDeprecation: Boolean
    fun addListener(event: String /* "beforeExit" | "exit" */, listener: BeforeExitListener): Process /* this */
    fun addListener(event: String /* "disconnect" */, listener: DisconnectListener): Process /* this */
    fun addListener(event: String /* "rejectionHandled" */, listener: RejectionHandledListener): Process /* this */
    fun addListener(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: UncaughtExceptionListener): Process /* this */
    fun addListener(event: String /* "unhandledRejection" */, listener: UnhandledRejectionListener): Process /* this */
    fun addListener(event: String /* "warning" */, listener: WarningListener): Process /* this */
    fun addListener(event: String /* "message" */, listener: MessageListener): Process /* this */
    fun addListener(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: SignalsListener): Process /* this */
    fun addListener(event: String /* "multipleResolves" */, listener: MultipleResolveListener): Process /* this */
    fun addListener(event: String /* "worker" */, listener: WorkerListener): Process /* this */
    fun emit(event: String /* "beforeExit" | "exit" */, code: Number): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    fun emit(event: String /* "disconnect" */): Boolean
    fun emit(event: String /* "rejectionHandled" */, promise: Promise<Any>): Boolean
    fun emit(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" | "warning" */, error: Error): Boolean
    fun emit(event: String /* "unhandledRejection" */, reason: Any, promise: Promise<Any>): Boolean
    fun emit(event: String /* "message" */, message: Any, sendHandle: Any): Process /* this */
    fun emit(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */): Boolean
    fun emit(event: String /* "multipleResolves" */, type: String /* "resolve" | "reject" */, promise: Promise<Any>, value: Any): Process /* this */
    fun emit(event: String /* "worker" */, listener: WorkerListener): Process /* this */
    fun on(event: String /* "beforeExit" | "exit" */, listener: BeforeExitListener): Process /* this */
    fun on(event: String /* "disconnect" */, listener: DisconnectListener): Process /* this */
    fun on(event: String /* "rejectionHandled" */, listener: RejectionHandledListener): Process /* this */
    fun on(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: UncaughtExceptionListener): Process /* this */
    fun on(event: String /* "unhandledRejection" */, listener: UnhandledRejectionListener): Process /* this */
    fun on(event: String /* "warning" */, listener: WarningListener): Process /* this */
    fun on(event: String /* "message" */, listener: MessageListener): Process /* this */
    fun on(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: SignalsListener): Process /* this */
    fun on(event: String /* "multipleResolves" */, listener: MultipleResolveListener): Process /* this */
    fun on(event: String /* "worker" */, listener: WorkerListener): Process /* this */
    override fun on(event: String, listener: (args: Any) -> Unit): Process /* this */
    override fun on(event: Any, listener: (args: Any) -> Unit): Process /* this */
    fun once(event: String /* "beforeExit" | "exit" */, listener: BeforeExitListener): Process /* this */
    fun once(event: String /* "disconnect" */, listener: DisconnectListener): Process /* this */
    fun once(event: String /* "rejectionHandled" */, listener: RejectionHandledListener): Process /* this */
    fun once(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: UncaughtExceptionListener): Process /* this */
    fun once(event: String /* "unhandledRejection" */, listener: UnhandledRejectionListener): Process /* this */
    fun once(event: String /* "warning" */, listener: WarningListener): Process /* this */
    fun once(event: String /* "message" */, listener: MessageListener): Process /* this */
    fun once(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: SignalsListener): Process /* this */
    fun once(event: String /* "multipleResolves" */, listener: MultipleResolveListener): Process /* this */
    fun once(event: String /* "worker" */, listener: WorkerListener): Process /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Process /* this */
    override fun once(event: Any, listener: (args: Any) -> Unit): Process /* this */
    fun prependListener(event: String /* "beforeExit" | "exit" */, listener: BeforeExitListener): Process /* this */
    fun prependListener(event: String /* "disconnect" */, listener: DisconnectListener): Process /* this */
    fun prependListener(event: String /* "rejectionHandled" */, listener: RejectionHandledListener): Process /* this */
    fun prependListener(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: UncaughtExceptionListener): Process /* this */
    fun prependListener(event: String /* "unhandledRejection" */, listener: UnhandledRejectionListener): Process /* this */
    fun prependListener(event: String /* "warning" */, listener: WarningListener): Process /* this */
    fun prependListener(event: String /* "message" */, listener: MessageListener): Process /* this */
    fun prependListener(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: SignalsListener): Process /* this */
    fun prependListener(event: String /* "multipleResolves" */, listener: MultipleResolveListener): Process /* this */
    fun prependListener(event: String /* "worker" */, listener: WorkerListener): Process /* this */
    fun prependOnceListener(event: String /* "beforeExit" | "exit" */, listener: BeforeExitListener): Process /* this */
    fun prependOnceListener(event: String /* "disconnect" */, listener: DisconnectListener): Process /* this */
    fun prependOnceListener(event: String /* "rejectionHandled" */, listener: RejectionHandledListener): Process /* this */
    fun prependOnceListener(event: String /* "uncaughtException" | "uncaughtExceptionMonitor" */, listener: UncaughtExceptionListener): Process /* this */
    fun prependOnceListener(event: String /* "unhandledRejection" */, listener: UnhandledRejectionListener): Process /* this */
    fun prependOnceListener(event: String /* "warning" */, listener: WarningListener): Process /* this */
    fun prependOnceListener(event: String /* "message" */, listener: MessageListener): Process /* this */
    fun prependOnceListener(event: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */, listener: SignalsListener): Process /* this */
    fun prependOnceListener(event: String /* "multipleResolves" */, listener: MultipleResolveListener): Process /* this */
    fun prependOnceListener(event: String /* "worker" */, listener: WorkerListener): Process /* this */
    override fun listeners(event: String /* "beforeExit" | "disconnect" | "exit" | "rejectionHandled" | "uncaughtException" | "uncaughtExceptionMonitor" | "unhandledRejection" | "warning" | "message" | "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | "multipleResolves" | "worker" */): dynamic /* Array */
}