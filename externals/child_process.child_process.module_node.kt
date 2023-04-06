@file:JsModule("child_process")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package child_process

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
import stream.internal.Writable
import stream.internal.Readable
import stream.internal.Pipe
import net.Socket
import net.Server
import events.EventEmitter
import events.EventEmitter.Abortable
import process.global.NodeJS.ProcessEnv
import tsstdlib.AbortSignal
import buffer.global.Buffer
import fs.ObjectEncodingOptions

external open class ChildProcess : EventEmitter {
    open var stdin: Writable?
    open var stdout: Readable?
    open var stderr: Readable?
    open var channel: Pipe?
    open var stdio: dynamic /* JsTuple<Writable?, Readable?, Readable?, dynamic, dynamic> */
    open var killed: Boolean
    open var pid: Number?
    open var connected: Boolean
    open var exitCode: Number?
    open var signalCode: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */
    open var spawnargs: Array<String>
    open var spawnfile: String
    open fun kill(signal: Any /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | Number */ = definedExternally): Boolean
    open fun send(message: String?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?): Boolean
    open fun send(message: Any?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?): Boolean
    open fun send(message: Number?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?): Boolean
    open fun send(message: Boolean?, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?): Boolean
    open fun send(message: String?, sendHandle: Socket = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Socket = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: String?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Any?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Number?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Socket = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally, callback: (error: Error?) -> Unit = definedExternally): Boolean
    open fun send(message: Boolean?, sendHandle: Server = definedExternally, options: MessageOptions = definedExternally): Boolean
    open fun disconnect()
    open fun unref()
    open fun ref()
    override fun addListener(event: String, listener: (args: Any) -> Unit): ChildProcess /* this */
    open fun addListener(event: String /* "close" | "exit" */, listener: (code: Number?, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */) -> Unit): ChildProcess /* this */
    open fun addListener(event: String /* "disconnect" | "spawn" */, listener: () -> Unit): ChildProcess /* this */
    open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): ChildProcess /* this */
    open fun addListener(event: String /* "message" */, listener: (message: Any? /* String? | Any? | Number? | Boolean? | Any? */, sendHandle: Any /* net.Socket | net.Server */) -> Unit): ChildProcess /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "close" | "exit" */, code: Number?, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */): Boolean
    open fun emit(event: String /* "disconnect" */): Boolean
    open fun emit(event: String /* "error" */, err: Error): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    open fun emit(event: String /* "message" */, message: String?, sendHandle: Socket): Boolean
    open fun emit(event: String /* "message" */, message: String?, sendHandle: Server): Boolean
    open fun emit(event: String /* "message" */, message: Any?, sendHandle: Socket): Boolean
    open fun emit(event: String /* "message" */, message: Any?, sendHandle: Server): Boolean
    open fun emit(event: String /* "message" */, message: Number?, sendHandle: Socket): Boolean
    open fun emit(event: String /* "message" */, message: Number?, sendHandle: Server): Boolean
    open fun emit(event: String /* "message" */, message: Boolean?, sendHandle: Socket): Boolean
    open fun emit(event: String /* "message" */, message: Boolean?, sendHandle: Server): Boolean
    open fun emit(event: String /* "spawn" */, listener: () -> Unit): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): ChildProcess /* this */
    open fun on(event: String /* "close" | "exit" */, listener: (code: Number?, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */) -> Unit): ChildProcess /* this */
    open fun on(event: String /* "disconnect" | "spawn" */, listener: () -> Unit): ChildProcess /* this */
    open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): ChildProcess /* this */
    open fun on(event: String /* "message" */, listener: (message: Any? /* String? | Any? | Number? | Boolean? | Any? */, sendHandle: Any /* net.Socket | net.Server */) -> Unit): ChildProcess /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): ChildProcess /* this */
    open fun once(event: String /* "close" | "exit" */, listener: (code: Number?, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */) -> Unit): ChildProcess /* this */
    open fun once(event: String /* "disconnect" | "spawn" */, listener: () -> Unit): ChildProcess /* this */
    open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): ChildProcess /* this */
    open fun once(event: String /* "message" */, listener: (message: Any? /* String? | Any? | Number? | Boolean? | Any? */, sendHandle: Any /* net.Socket | net.Server */) -> Unit): ChildProcess /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): ChildProcess /* this */
    open fun prependListener(event: String /* "close" | "exit" */, listener: (code: Number?, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */) -> Unit): ChildProcess /* this */
    open fun prependListener(event: String /* "disconnect" | "spawn" */, listener: () -> Unit): ChildProcess /* this */
    open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): ChildProcess /* this */
    open fun prependListener(event: String /* "message" */, listener: (message: Any? /* String? | Any? | Number? | Boolean? | Any? */, sendHandle: Any /* net.Socket | net.Server */) -> Unit): ChildProcess /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): ChildProcess /* this */
    open fun prependOnceListener(event: String /* "close" | "exit" */, listener: (code: Number?, signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */) -> Unit): ChildProcess /* this */
    open fun prependOnceListener(event: String /* "disconnect" | "spawn" */, listener: () -> Unit): ChildProcess /* this */
    open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): ChildProcess /* this */
    open fun prependOnceListener(event: String /* "message" */, listener: (message: Any? /* String? | Any? | Number? | Boolean? | Any? */, sendHandle: Any /* net.Socket | net.Server */) -> Unit): ChildProcess /* this */
}

external interface ChildProcessWithoutNullStreams : ChildProcess {
    override var stdio: dynamic /* JsTuple<Writable, Readable, Readable, dynamic, dynamic> */
        get() = definedExternally
        set(value) = definedExternally
}

external interface ChildProcessByStdio<I : Writable?, O : Readable?, E : Readable?> : ChildProcess {
    override var stdio: dynamic /* JsTuple<I, O, E, dynamic, dynamic> */
        get() = definedExternally
        set(value) = definedExternally
}

external interface MessageOptions {
    var keepOpen: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MessagingOptions : Abortable {
    var serialization: String? /* "json" | "advanced" */
        get() = definedExternally
        set(value) = definedExternally
    var killSignal: dynamic /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ProcessEnvOptions {
    var uid: Number?
        get() = definedExternally
        set(value) = definedExternally
    var gid: Number?
        get() = definedExternally
        set(value) = definedExternally
    var cwd: dynamic /* String? | URL? */
        get() = definedExternally
        set(value) = definedExternally
    var env: ProcessEnv?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommonOptions : ProcessEnvOptions {
    var windowsHide: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommonSpawnOptions : CommonOptions, MessagingOptions, Abortable {
    var argv0: String?
        get() = definedExternally
        set(value) = definedExternally
    var stdio: dynamic /* "overlapped" | "pipe" | "ignore" | "inherit" | Array<dynamic /* "overlapped" | "pipe" | "ignore" | "inherit" | "ipc" | Stream? | Number? */>? */
        get() = definedExternally
        set(value) = definedExternally
    var shell: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var windowsVerbatimArguments: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    override var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SpawnOptions : CommonSpawnOptions {
    var detached: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SpawnOptionsWithoutStdio : SpawnOptions {
    override var stdio: dynamic /* "pipe" | "overlapped" | Array<String /* "pipe" | "overlapped" */>? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SpawnOptionsWithStdioTuple<Stdin, Stdout, Stderr> : SpawnOptions {
    override var stdio: dynamic /* JsTuple<Stdin, Stdout, Stderr> */
        get() = definedExternally
        set(value) = definedExternally
}

external fun spawn(command: String, options: SpawnOptionsWithoutStdio = definedExternally): ChildProcessWithoutNullStreams

external fun spawn(command: String): ChildProcessWithoutNullStreams

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Writable, Readable, Readable>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Writable, Readable, Nothing?>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Writable, Nothing?, Readable>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Nothing?, Readable, Readable>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Writable, Nothing?, Nothing?>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Nothing?, Readable, Nothing?>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Nothing?, Nothing?, Readable>

external fun spawn(command: String, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Nothing?, Nothing?, Nothing?>

external fun spawn(command: String, options: SpawnOptions): ChildProcess

external fun spawn(command: String, args: Array<String> = definedExternally, options: SpawnOptionsWithoutStdio = definedExternally): ChildProcessWithoutNullStreams

external fun spawn(command: String, args: Array<String> = definedExternally): ChildProcessWithoutNullStreams

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Writable, Readable, Readable>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Writable, Readable, Nothing?>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Writable, Nothing?, Readable>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Nothing?, Readable, Readable>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Writable, Nothing?, Nothing?>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Nothing?, Readable, Nothing?>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */, String /* "pipe" | "overlapped" */>): ChildProcessByStdio<Nothing?, Nothing?, Readable>

external fun spawn(command: String, args: Array<String>, options: SpawnOptionsWithStdioTuple<Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */, Any /* "inherit" | "ignore" | Stream */>): ChildProcessByStdio<Nothing?, Nothing?, Nothing?>

external fun spawn(command: String, args: Array<String>, options: SpawnOptions): ChildProcess

external interface ExecOptions : CommonOptions {
    var shell: String?
        get() = definedExternally
        set(value) = definedExternally
    var signal: AbortSignal?
        get() = definedExternally
        set(value) = definedExternally
    var maxBuffer: Number?
        get() = definedExternally
        set(value) = definedExternally
    var killSignal: dynamic /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | Number? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExecOptionsWithStringEncoding : ExecOptions {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
}

external interface ExecOptionsWithBufferEncoding : ExecOptions {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
}

external fun exec(command: String, callback: (error: ExecException?, stdout: String, stderr: String) -> Unit = definedExternally): ChildProcess

external fun exec(command: String): ChildProcess

external interface `T$65` {
    var encoding: String /* "buffer" */
}

external fun exec(command: String, options: `T$65` /* `T$65` & ExecOptions */, callback: (error: ExecException?, stdout: Buffer, stderr: Buffer) -> Unit = definedExternally): ChildProcess

external fun exec(command: String, options: `T$65` /* `T$65` & ExecOptions */): ChildProcess

external interface `T$66` {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
}

external fun exec(command: String, options: `T$66` /* `T$66` & ExecOptions */, callback: (error: ExecException?, stdout: String, stderr: String) -> Unit = definedExternally): ChildProcess

external fun exec(command: String, options: `T$66` /* `T$66` & ExecOptions */): ChildProcess

external fun exec(command: String, options: `T$66` /* `T$66` & ExecOptions */, callback: (error: ExecException?, stdout: Any /* String | Buffer */, stderr: Any /* String | Buffer */) -> Unit = definedExternally): ChildProcess

external fun exec(command: String, options: ExecOptions, callback: (error: ExecException?, stdout: String, stderr: String) -> Unit = definedExternally): ChildProcess

external fun exec(command: String, options: ExecOptions): ChildProcess

external fun exec(command: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecOptions */, callback: (error: ExecException?, stdout: Any /* String | Buffer */, stderr: Any /* String | Buffer */) -> Unit = definedExternally): ChildProcess

external fun exec(command: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecOptions */): ChildProcess

external interface PromiseWithChild<T> : Promise<T> {
    var child: ChildProcess
}

external interface ExecFileOptions : CommonOptions, Abortable {
    var maxBuffer: Number?
        get() = definedExternally
        set(value) = definedExternally
    var killSignal: dynamic /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var windowsVerbatimArguments: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var shell: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    override var signal: AbortSignal?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExecFileOptionsWithStringEncoding : ExecFileOptions {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
}

external interface ExecFileOptionsWithBufferEncoding : ExecFileOptions {
    var encoding: String /* "buffer" */
}

external interface ExecFileOptionsWithOtherEncoding : ExecFileOptions {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
}

external fun execFile(file: String): ChildProcess

external fun execFile(file: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecFileOptions */): ChildProcess

external fun execFile(file: String, args: Array<String>? = definedExternally): ChildProcess

external fun execFile(file: String, args: Array<String>?, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecFileOptions */): ChildProcess

external fun execFile(file: String, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: String, stderr: String) -> Unit): ChildProcess

external fun execFile(file: String, args: Array<String>?, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: String, stderr: String) -> Unit): ChildProcess

external fun execFile(file: String, options: ExecFileOptionsWithBufferEncoding, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: Buffer, stderr: Buffer) -> Unit): ChildProcess

external fun execFile(file: String, args: Array<String>?, options: ExecFileOptionsWithBufferEncoding, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: Buffer, stderr: Buffer) -> Unit): ChildProcess

external fun execFile(file: String, options: ExecFileOptionsWithStringEncoding, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: String, stderr: String) -> Unit): ChildProcess

external fun execFile(file: String, args: Array<String>?, options: ExecFileOptionsWithStringEncoding, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: String, stderr: String) -> Unit): ChildProcess

external fun execFile(file: String, options: ExecFileOptionsWithOtherEncoding, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: Any /* String | Buffer */, stderr: Any /* String | Buffer */) -> Unit): ChildProcess

external fun execFile(file: String, args: Array<String>?, options: ExecFileOptionsWithOtherEncoding, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: Any /* String | Buffer */, stderr: Any /* String | Buffer */) -> Unit): ChildProcess

external fun execFile(file: String, options: ExecFileOptions, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: String, stderr: String) -> Unit): ChildProcess

external fun execFile(file: String, args: Array<String>?, options: ExecFileOptions, callback: (error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: String, stderr: String) -> Unit): ChildProcess

external fun execFile(file: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecFileOptions */, callback: ((error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: Any /* String | Buffer */, stderr: Any /* String | Buffer */) -> Unit)?): ChildProcess

external fun execFile(file: String, args: Array<String>?, options: ObjectEncodingOptions /* ObjectEncodingOptions & ExecFileOptions */, callback: ((error: ExecException /* ExecException & NodeJS.ErrnoException */, stdout: Any /* String | Buffer */, stderr: Any /* String | Buffer */) -> Unit)?): ChildProcess

external interface ForkOptions : ProcessEnvOptions, MessagingOptions, Abortable {
    var execPath: String?
        get() = definedExternally
        set(value) = definedExternally
    var execArgv: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var silent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var stdio: dynamic /* "overlapped" | "pipe" | "ignore" | "inherit" | Array<dynamic /* "overlapped" | "pipe" | "ignore" | "inherit" | "ipc" | Stream? | Number? */>? */
        get() = definedExternally
        set(value) = definedExternally
    var detached: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var windowsVerbatimArguments: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun fork(modulePath: String, options: ForkOptions = definedExternally): ChildProcess

external fun fork(modulePath: String): ChildProcess

external fun fork(modulePath: String, args: Array<String> = definedExternally, options: ForkOptions = definedExternally): ChildProcess

external fun fork(modulePath: String, args: Array<String> = definedExternally): ChildProcess

external interface SpawnSyncOptions : CommonSpawnOptions {
    var input: dynamic /* String? | Uint8Array? | Uint8ClampedArray? | Uint16Array? | Uint32Array? | Int8Array? | Int16Array? | Int32Array? | BigUint64Array? | BigInt64Array? | Float32Array? | Float64Array? | DataView? */
        get() = definedExternally
        set(value) = definedExternally
    var maxBuffer: Number?
        get() = definedExternally
        set(value) = definedExternally
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | "buffer" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SpawnSyncOptionsWithStringEncoding : SpawnSyncOptions

external interface SpawnSyncOptionsWithBufferEncoding : SpawnSyncOptions {
    override var encoding: String? /* "buffer" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SpawnSyncReturns<T> {
    var pid: Number
    var output: Array<T?>
    var stdout: T
    var stderr: T
    var status: Number?
    var signal: String /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" */
    var error: Error?
        get() = definedExternally
        set(value) = definedExternally
}

external fun spawnSync(command: String): dynamic /* SpawnSyncReturns */

external fun spawnSync(command: String, options: SpawnSyncOptionsWithStringEncoding): SpawnSyncReturns<String>

external fun spawnSync(command: String, options: SpawnSyncOptionsWithBufferEncoding): SpawnSyncReturns<Buffer>

external fun spawnSync(command: String, options: SpawnSyncOptions = definedExternally): SpawnSyncReturns<dynamic /* String | Buffer */>

external fun spawnSync(command: String, args: Array<String>): dynamic /* SpawnSyncReturns | SpawnSyncReturns */

external fun spawnSync(command: String, args: Array<String>, options: SpawnSyncOptionsWithStringEncoding): SpawnSyncReturns<String>

external fun spawnSync(command: String, args: Array<String>, options: SpawnSyncOptionsWithBufferEncoding): SpawnSyncReturns<Buffer>

external fun spawnSync(command: String, args: Array<String> = definedExternally, options: SpawnSyncOptions = definedExternally): SpawnSyncReturns<dynamic /* String | Buffer */>

external interface CommonExecOptions : CommonOptions {
    var input: dynamic /* String? | Uint8Array? | Uint8ClampedArray? | Uint16Array? | Uint32Array? | Int8Array? | Int16Array? | Int32Array? | BigUint64Array? | BigInt64Array? | Float32Array? | Float64Array? | DataView? */
        get() = definedExternally
        set(value) = definedExternally
    var stdio: dynamic /* "overlapped" | "pipe" | "ignore" | "inherit" | Array<dynamic /* "overlapped" | "pipe" | "ignore" | "inherit" | "ipc" | Stream? | Number? */>? */
        get() = definedExternally
        set(value) = definedExternally
    var killSignal: dynamic /* "SIGABRT" | "SIGALRM" | "SIGBUS" | "SIGCHLD" | "SIGCONT" | "SIGFPE" | "SIGHUP" | "SIGILL" | "SIGINT" | "SIGIO" | "SIGIOT" | "SIGKILL" | "SIGPIPE" | "SIGPOLL" | "SIGPROF" | "SIGPWR" | "SIGQUIT" | "SIGSEGV" | "SIGSTKFLT" | "SIGSTOP" | "SIGSYS" | "SIGTERM" | "SIGTRAP" | "SIGTSTP" | "SIGTTIN" | "SIGTTOU" | "SIGUNUSED" | "SIGURG" | "SIGUSR1" | "SIGUSR2" | "SIGVTALRM" | "SIGWINCH" | "SIGXCPU" | "SIGXFSZ" | "SIGBREAK" | "SIGLOST" | "SIGINFO" | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var maxBuffer: Number?
        get() = definedExternally
        set(value) = definedExternally
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | "buffer" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExecSyncOptions : CommonExecOptions {
    var shell: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExecSyncOptionsWithStringEncoding : ExecSyncOptions

external interface ExecSyncOptionsWithBufferEncoding : ExecSyncOptions {
    override var encoding: String? /* "buffer" */
        get() = definedExternally
        set(value) = definedExternally
}

external fun execSync(command: String): dynamic /* Buffer */

external fun execSync(command: String, options: ExecSyncOptionsWithStringEncoding): String

external fun execSync(command: String, options: ExecSyncOptionsWithBufferEncoding): Buffer

external fun execSync(command: String, options: ExecSyncOptions = definedExternally): dynamic /* String | Buffer */

external interface ExecFileSyncOptions : CommonExecOptions {
    var shell: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExecFileSyncOptionsWithStringEncoding : ExecFileSyncOptions

external interface ExecFileSyncOptionsWithBufferEncoding : ExecFileSyncOptions {
    override var encoding: String? /* "buffer" */
        get() = definedExternally
        set(value) = definedExternally
}

external fun execFileSync(file: String): dynamic /* Buffer | String | Buffer */

external fun execFileSync(file: String, options: ExecFileSyncOptionsWithStringEncoding): String

external fun execFileSync(file: String, options: ExecFileSyncOptionsWithBufferEncoding): Buffer

external fun execFileSync(file: String, options: ExecFileSyncOptions = definedExternally): dynamic /* String | Buffer */

external fun execFileSync(file: String, args: Array<String>): dynamic /* Buffer */

external fun execFileSync(file: String, args: Array<String>, options: ExecFileSyncOptionsWithStringEncoding): String

external fun execFileSync(file: String, args: Array<String>, options: ExecFileSyncOptionsWithBufferEncoding): Buffer

external fun execFileSync(file: String, args: Array<String> = definedExternally, options: ExecFileSyncOptions = definedExternally): dynamic /* String | Buffer */