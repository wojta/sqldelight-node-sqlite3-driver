@file:JsModule("fs")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs

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
import NodeJS.ErrnoException
import AsyncIterable
import events.EventEmitter
import stream.internal.ReadableOptions
import stream.internal.Readable
import stream.internal.WritableOptions
import stream.internal.Writable
import buffer.global.Buffer
import url.URL
import fs.promises.`T$51`
import fs.promises.`T$48`
import BigUint64Array
import BigInt64Array
import events.EventEmitter.Abortable

external interface ObjectEncodingOptions {
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface StatsBase<T> {
    fun isFile(): Boolean
    fun isDirectory(): Boolean
    fun isBlockDevice(): Boolean
    fun isCharacterDevice(): Boolean
    fun isSymbolicLink(): Boolean
    fun isFIFO(): Boolean
    fun isSocket(): Boolean
    var dev: T
    var ino: T
    var mode: T
    var nlink: T
    var uid: T
    var gid: T
    var rdev: T
    var size: T
    var blksize: T
    var blocks: T
    var atimeMs: T
    var mtimeMs: T
    var ctimeMs: T
    var birthtimeMs: T
    var atime: Date
    var mtime: Date
    var ctime: Date
    var birthtime: Date
}

external open class Stats : StatsBase<Number> {
    override fun isFile(): Boolean
    override fun isDirectory(): Boolean
    override fun isBlockDevice(): Boolean
    override fun isCharacterDevice(): Boolean
    override fun isSymbolicLink(): Boolean
    override fun isFIFO(): Boolean
    override fun isSocket(): Boolean
    override var dev: Number
    override var ino: Number
    override var mode: Number
    override var nlink: Number
    override var uid: Number
    override var gid: Number
    override var rdev: Number
    override var size: Number
    override var blksize: Number
    override var blocks: Number
    override var atimeMs: Number
    override var mtimeMs: Number
    override var ctimeMs: Number
    override var birthtimeMs: Number
    override var atime: Date
    override var mtime: Date
    override var ctime: Date
    override var birthtime: Date
}

external open class Dirent {
    open fun isFile(): Boolean
    open fun isDirectory(): Boolean
    open fun isBlockDevice(): Boolean
    open fun isCharacterDevice(): Boolean
    open fun isSymbolicLink(): Boolean
    open fun isFIFO(): Boolean
    open fun isSocket(): Boolean
    open var name: String
}

external open class Dir : AsyncIterable<Dirent> {
    open var path: String
    open fun close(): Promise<Unit>
    open fun close(cb: NoParamCallback)
    open fun closeSync()
    open fun read(): Promise<Dirent?>
    open fun read(cb: (err: ErrnoException?, dirEnt: Dirent?) -> Unit)
    open fun readSync(): Dirent?
}

external interface StatWatcher : EventEmitter {
    fun ref(): StatWatcher /* this */
    fun unref(): StatWatcher /* this */
}

external interface FSWatcher : EventEmitter {
    fun close()
    override fun addListener(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun addListener(event: String /* "change" */, listener: (eventType: String, filename: Any /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun addListener(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    fun addListener(event: String /* "close" */, listener: () -> Unit): FSWatcher /* this */
    override fun on(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun on(event: String /* "change" */, listener: (eventType: String, filename: Any /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun on(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    fun on(event: String /* "close" */, listener: () -> Unit): FSWatcher /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun once(event: String /* "change" */, listener: (eventType: String, filename: Any /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun once(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    fun once(event: String /* "close" */, listener: () -> Unit): FSWatcher /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun prependListener(event: String /* "change" */, listener: (eventType: String, filename: Any /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun prependListener(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    fun prependListener(event: String /* "close" */, listener: () -> Unit): FSWatcher /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun prependOnceListener(event: String /* "change" */, listener: (eventType: String, filename: Any /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun prependOnceListener(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): FSWatcher /* this */
}

external open class ReadStream(opts: ReadableOptions = definedExternally) : Readable {
    open fun close(callback: (err: ErrnoException?) -> Unit = definedExternally)
    open var bytesRead: Number
    open var path: dynamic /* String | Buffer */
    open var pending: Boolean
    override fun addListener(event: String /* "close" | "end" | "pause" | "readable" | "ready" | "resume" */, listener: () -> Unit): ReadStream /* this */
    override fun addListener(event: String /* "data" */, listener: (chunk: Any /* Buffer | String */) -> Unit): ReadStream /* this */
    override fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): ReadStream /* this */
    open fun addListener(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */
    override fun addListener(event: Any, listener: (args: Any) -> Unit): ReadStream /* this */
    override fun on(event: String /* "close" | "end" | "pause" | "readable" | "ready" | "resume" */, listener: () -> Unit): ReadStream /* this */
    override fun on(event: String /* "data" */, listener: (chunk: Any /* Buffer | String */) -> Unit): ReadStream /* this */
    override fun on(event: String /* "error" */, listener: (err: Error) -> Unit): ReadStream /* this */
    open fun on(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */
    override fun on(event: Any, listener: (args: Any) -> Unit): ReadStream /* this */
    override fun once(event: String /* "close" | "end" | "pause" | "readable" | "ready" | "resume" */, listener: () -> Unit): ReadStream /* this */
    override fun once(event: String /* "data" */, listener: (chunk: Any /* Buffer | String */) -> Unit): ReadStream /* this */
    override fun once(event: String /* "error" */, listener: (err: Error) -> Unit): ReadStream /* this */
    open fun once(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */
    override fun once(event: Any, listener: (args: Any) -> Unit): ReadStream /* this */
    override fun prependListener(event: String /* "close" | "end" | "pause" | "readable" | "ready" | "resume" */, listener: () -> Unit): ReadStream /* this */
    override fun prependListener(event: String /* "data" */, listener: (chunk: Any /* Buffer | String */) -> Unit): ReadStream /* this */
    override fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): ReadStream /* this */
    open fun prependListener(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */
    override fun prependListener(event: Any, listener: (args: Any) -> Unit): ReadStream /* this */
    override fun prependOnceListener(event: String /* "close" | "end" | "pause" | "readable" | "ready" | "resume" */, listener: () -> Unit): ReadStream /* this */
    override fun prependOnceListener(event: String /* "data" */, listener: (chunk: Any /* Buffer | String */) -> Unit): ReadStream /* this */
    override fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): ReadStream /* this */
    open fun prependOnceListener(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */
    override fun prependOnceListener(event: Any, listener: (args: Any) -> Unit): ReadStream /* this */
}

external open class WriteStream(opts: WritableOptions = definedExternally) : Writable {
    open fun close(callback: (err: ErrnoException?) -> Unit = definedExternally)
    open var bytesWritten: Number
    open var path: dynamic /* String | Buffer */
    open var pending: Boolean
    override fun addListener(event: String /* "close" | "drain" | "finish" | "ready" */, listener: () -> Unit): WriteStream /* this */
    override fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): WriteStream /* this */
    open fun addListener(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */
    override fun addListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): WriteStream /* this */
    override fun addListener(event: String, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun addListener(event: Any, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun on(event: String /* "close" | "drain" | "finish" | "ready" */, listener: () -> Unit): WriteStream /* this */
    override fun on(event: String /* "error" */, listener: (err: Error) -> Unit): WriteStream /* this */
    open fun on(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */
    override fun on(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): WriteStream /* this */
    override fun on(event: String, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun on(event: Any, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun once(event: String /* "close" | "drain" | "finish" | "ready" */, listener: () -> Unit): WriteStream /* this */
    override fun once(event: String /* "error" */, listener: (err: Error) -> Unit): WriteStream /* this */
    open fun once(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */
    override fun once(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): WriteStream /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun once(event: Any, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun prependListener(event: String /* "close" | "drain" | "finish" | "ready" */, listener: () -> Unit): WriteStream /* this */
    override fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): WriteStream /* this */
    open fun prependListener(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */
    override fun prependListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): WriteStream /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun prependListener(event: Any, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun prependOnceListener(event: String /* "close" | "drain" | "finish" | "ready" */, listener: () -> Unit): WriteStream /* this */
    override fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): WriteStream /* this */
    open fun prependOnceListener(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */
    override fun prependOnceListener(event: String /* "pipe" | "unpipe" */, listener: (src: Readable) -> Unit): WriteStream /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): WriteStream /* this */
    override fun prependOnceListener(event: Any, listener: (args: Any) -> Unit): WriteStream /* this */
}

external fun rename(oldPath: String, newPath: String, callback: NoParamCallback)

external fun rename(oldPath: String, newPath: Buffer, callback: NoParamCallback)

external fun rename(oldPath: String, newPath: URL, callback: NoParamCallback)

external fun rename(oldPath: Buffer, newPath: String, callback: NoParamCallback)

external fun rename(oldPath: Buffer, newPath: Buffer, callback: NoParamCallback)

external fun rename(oldPath: Buffer, newPath: URL, callback: NoParamCallback)

external fun rename(oldPath: URL, newPath: String, callback: NoParamCallback)

external fun rename(oldPath: URL, newPath: Buffer, callback: NoParamCallback)

external fun rename(oldPath: URL, newPath: URL, callback: NoParamCallback)

external fun renameSync(oldPath: String, newPath: String)

external fun renameSync(oldPath: String, newPath: Buffer)

external fun renameSync(oldPath: String, newPath: URL)

external fun renameSync(oldPath: Buffer, newPath: String)

external fun renameSync(oldPath: Buffer, newPath: Buffer)

external fun renameSync(oldPath: Buffer, newPath: URL)

external fun renameSync(oldPath: URL, newPath: String)

external fun renameSync(oldPath: URL, newPath: Buffer)

external fun renameSync(oldPath: URL, newPath: URL)

external fun truncate(path: String, len: Number?, callback: NoParamCallback)

external fun truncate(path: Buffer, len: Number?, callback: NoParamCallback)

external fun truncate(path: URL, len: Number?, callback: NoParamCallback)

external fun truncate(path: String, callback: NoParamCallback)

external fun truncate(path: Buffer, callback: NoParamCallback)

external fun truncate(path: URL, callback: NoParamCallback)

external fun truncateSync(path: String, len: Number? = definedExternally)

external fun truncateSync(path: String)

external fun truncateSync(path: Buffer, len: Number? = definedExternally)

external fun truncateSync(path: Buffer)

external fun truncateSync(path: URL, len: Number? = definedExternally)

external fun truncateSync(path: URL)

external fun ftruncate(fd: Number, len: Number?, callback: NoParamCallback)

external fun ftruncate(fd: Number, callback: NoParamCallback)

external fun ftruncateSync(fd: Number, len: Number? = definedExternally)

external fun chown(path: String, uid: Number, gid: Number, callback: NoParamCallback)

external fun chown(path: Buffer, uid: Number, gid: Number, callback: NoParamCallback)

external fun chown(path: URL, uid: Number, gid: Number, callback: NoParamCallback)

external fun chownSync(path: String, uid: Number, gid: Number)

external fun chownSync(path: Buffer, uid: Number, gid: Number)

external fun chownSync(path: URL, uid: Number, gid: Number)

external fun fchown(fd: Number, uid: Number, gid: Number, callback: NoParamCallback)

external fun fchownSync(fd: Number, uid: Number, gid: Number)

external fun lchown(path: String, uid: Number, gid: Number, callback: NoParamCallback)

external fun lchown(path: Buffer, uid: Number, gid: Number, callback: NoParamCallback)

external fun lchown(path: URL, uid: Number, gid: Number, callback: NoParamCallback)

external fun lchownSync(path: String, uid: Number, gid: Number)

external fun lchownSync(path: Buffer, uid: Number, gid: Number)

external fun lchownSync(path: URL, uid: Number, gid: Number)

external fun lutimes(path: String, atime: String, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: String, atime: Number, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: String, atime: Date, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: Buffer, atime: String, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: URL, atime: String, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: URL, atime: Number, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimes(path: URL, atime: Date, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun lutimesSync(path: String, atime: String, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: String, atime: Number, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: String, atime: Date, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: Buffer, atime: String, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: URL, atime: String, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: URL, atime: Number, mtime: Any /* String | Number | Date */)

external fun lutimesSync(path: URL, atime: Date, mtime: Any /* String | Number | Date */)

external fun chmod(path: String, mode: Number, callback: NoParamCallback)

external fun chmod(path: String, mode: String, callback: NoParamCallback)

external fun chmod(path: Buffer, mode: Number, callback: NoParamCallback)

external fun chmod(path: Buffer, mode: String, callback: NoParamCallback)

external fun chmod(path: URL, mode: Number, callback: NoParamCallback)

external fun chmod(path: URL, mode: String, callback: NoParamCallback)

external fun chmodSync(path: String, mode: Number)

external fun chmodSync(path: String, mode: String)

external fun chmodSync(path: Buffer, mode: Number)

external fun chmodSync(path: Buffer, mode: String)

external fun chmodSync(path: URL, mode: Number)

external fun chmodSync(path: URL, mode: String)

external fun fchmod(fd: Number, mode: Number, callback: NoParamCallback)

external fun fchmod(fd: Number, mode: String, callback: NoParamCallback)

external fun fchmodSync(fd: Number, mode: Number)

external fun fchmodSync(fd: Number, mode: String)

external fun lchmod(path: String, mode: Number, callback: NoParamCallback)

external fun lchmod(path: String, mode: String, callback: NoParamCallback)

external fun lchmod(path: Buffer, mode: Number, callback: NoParamCallback)

external fun lchmod(path: Buffer, mode: String, callback: NoParamCallback)

external fun lchmod(path: URL, mode: Number, callback: NoParamCallback)

external fun lchmod(path: URL, mode: String, callback: NoParamCallback)

external fun lchmodSync(path: String, mode: Number)

external fun lchmodSync(path: String, mode: String)

external fun lchmodSync(path: Buffer, mode: Number)

external fun lchmodSync(path: Buffer, mode: String)

external fun lchmodSync(path: URL, mode: Number)

external fun lchmodSync(path: URL, mode: String)

external fun stat(path: String, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun stat(path: Buffer, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun stat(path: URL, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun stat(path: String, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun stat(path: Buffer, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun stat(path: URL, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun stat(path: String, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun stat(path: Buffer, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun stat(path: URL, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun stat(path: String, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external fun stat(path: Buffer, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external fun stat(path: URL, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external interface `T$52` {
    var bigint: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var throwIfNoEntry: Boolean
}

external interface `T$53` {
    var bigint: Boolean
    var throwIfNoEntry: Boolean
}

external interface `T$54` {
    var bigint: Boolean
    var throwIfNoEntry: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external var statSync: StatSyncFn

external fun fstat(fd: Number, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun fstat(fd: Number, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun fstat(fd: Number, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun fstat(fd: Number, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external fun fstatSync(fd: Number, options: StatOptions /* StatOptions & `T$41` | StatOptions & `T$42` */ = definedExternally): dynamic /* Stats | BigIntStats */

external fun fstatSync(fd: Number): dynamic /* Stats */

external fun lstat(path: String, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun lstat(path: Buffer, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun lstat(path: URL, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun lstat(path: String, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun lstat(path: Buffer, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun lstat(path: URL, options: StatOptions /* StatOptions & `T$41` */, callback: (err: ErrnoException?, stats: Stats) -> Unit)

external fun lstat(path: String, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun lstat(path: Buffer, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun lstat(path: URL, options: StatOptions /* StatOptions & `T$42` */, callback: (err: ErrnoException?, stats: BigIntStats) -> Unit)

external fun lstat(path: String, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external fun lstat(path: Buffer, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external fun lstat(path: URL, options: StatOptions?, callback: (err: ErrnoException?, stats: Any /* Stats | BigIntStats */) -> Unit)

external var lstatSync: StatSyncFn

external fun link(existingPath: String, newPath: String, callback: NoParamCallback)

external fun link(existingPath: String, newPath: Buffer, callback: NoParamCallback)

external fun link(existingPath: String, newPath: URL, callback: NoParamCallback)

external fun link(existingPath: Buffer, newPath: String, callback: NoParamCallback)

external fun link(existingPath: Buffer, newPath: Buffer, callback: NoParamCallback)

external fun link(existingPath: Buffer, newPath: URL, callback: NoParamCallback)

external fun link(existingPath: URL, newPath: String, callback: NoParamCallback)

external fun link(existingPath: URL, newPath: Buffer, callback: NoParamCallback)

external fun link(existingPath: URL, newPath: URL, callback: NoParamCallback)

external fun linkSync(existingPath: String, newPath: String)

external fun linkSync(existingPath: String, newPath: Buffer)

external fun linkSync(existingPath: String, newPath: URL)

external fun linkSync(existingPath: Buffer, newPath: String)

external fun linkSync(existingPath: Buffer, newPath: Buffer)

external fun linkSync(existingPath: Buffer, newPath: URL)

external fun linkSync(existingPath: URL, newPath: String)

external fun linkSync(existingPath: URL, newPath: Buffer)

external fun linkSync(existingPath: URL, newPath: URL)

external fun symlink(target: String, path: String, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: String, path: Buffer, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: String, path: URL, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: Buffer, path: String, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: Buffer, path: Buffer, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: Buffer, path: URL, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: URL, path: String, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: URL, path: Buffer, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: URL, path: URL, type: String /* "dir" | "file" | "junction" */, callback: NoParamCallback)

external fun symlink(target: String, path: String, callback: NoParamCallback)

external fun symlink(target: String, path: Buffer, callback: NoParamCallback)

external fun symlink(target: String, path: URL, callback: NoParamCallback)

external fun symlink(target: Buffer, path: String, callback: NoParamCallback)

external fun symlink(target: Buffer, path: Buffer, callback: NoParamCallback)

external fun symlink(target: Buffer, path: URL, callback: NoParamCallback)

external fun symlink(target: URL, path: String, callback: NoParamCallback)

external fun symlink(target: URL, path: Buffer, callback: NoParamCallback)

external fun symlink(target: URL, path: URL, callback: NoParamCallback)

external fun symlinkSync(target: String, path: String, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: String, path: String)

external fun symlinkSync(target: String, path: Buffer, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: String, path: Buffer)

external fun symlinkSync(target: String, path: URL, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: String, path: URL)

external fun symlinkSync(target: Buffer, path: String, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: Buffer, path: String)

external fun symlinkSync(target: Buffer, path: Buffer, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: Buffer, path: Buffer)

external fun symlinkSync(target: Buffer, path: URL, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: Buffer, path: URL)

external fun symlinkSync(target: URL, path: String, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: URL, path: String)

external fun symlinkSync(target: URL, path: Buffer, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: URL, path: Buffer)

external fun symlinkSync(target: URL, path: URL, type: String /* "dir" | "file" | "junction" */ = definedExternally)

external fun symlinkSync(target: URL, path: URL)

external fun readlink(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, linkString: String) -> Unit)

external fun readlink(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, linkString: String) -> Unit)

external fun readlink(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, linkString: String) -> Unit)

external fun readlink(path: String, options: String /* "buffer" */, callback: (err: ErrnoException?, linkString: Buffer) -> Unit)

external fun readlink(path: String, options: `T$51`, callback: (err: ErrnoException?, linkString: Buffer) -> Unit)

external fun readlink(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException?, linkString: Buffer) -> Unit)

external fun readlink(path: Buffer, options: `T$51`, callback: (err: ErrnoException?, linkString: Buffer) -> Unit)

external fun readlink(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException?, linkString: Buffer) -> Unit)

external fun readlink(path: URL, options: `T$51`, callback: (err: ErrnoException?, linkString: Buffer) -> Unit)

external fun readlink(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, linkString: Any /* String | Buffer */) -> Unit)

external fun readlink(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, linkString: Any /* String | Buffer */) -> Unit)

external fun readlink(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, linkString: Any /* String | Buffer */) -> Unit)

external fun readlink(path: String, callback: (err: ErrnoException?, linkString: String) -> Unit)

external fun readlink(path: Buffer, callback: (err: ErrnoException?, linkString: String) -> Unit)

external fun readlink(path: URL, callback: (err: ErrnoException?, linkString: String) -> Unit)

external fun readlinkSync(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun readlinkSync(path: String): dynamic /* String */

external fun readlinkSync(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun readlinkSync(path: Buffer): dynamic /* String */

external fun readlinkSync(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun readlinkSync(path: URL): dynamic /* String */

external fun readlinkSync(path: String, options: String /* "buffer" */): Buffer

external fun readlinkSync(path: String, options: `T$51`): Buffer

external fun readlinkSync(path: Buffer, options: String /* "buffer" */): Buffer

external fun readlinkSync(path: Buffer, options: `T$51`): Buffer

external fun readlinkSync(path: URL, options: String /* "buffer" */): Buffer

external fun readlinkSync(path: URL, options: `T$51`): Buffer

external fun realpath(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun realpath(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun realpath(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun realpath(path: String, options: String /* "buffer" */, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun realpath(path: String, options: `T$51`, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun realpath(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun realpath(path: Buffer, options: `T$51`, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun realpath(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun realpath(path: URL, options: `T$51`, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun realpath(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: Any /* String | Buffer */) -> Unit)

external fun realpath(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: Any /* String | Buffer */) -> Unit)

external fun realpath(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: Any /* String | Buffer */) -> Unit)

external fun realpath(path: String, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun realpath(path: Buffer, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun realpath(path: URL, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun realpathSync(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun realpathSync(path: String): dynamic /* String */

external fun realpathSync(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun realpathSync(path: Buffer): dynamic /* String */

external fun realpathSync(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun realpathSync(path: URL): dynamic /* String */

external fun realpathSync(path: String, options: String /* "buffer" */): Buffer

external fun realpathSync(path: String, options: `T$51`): Buffer

external fun realpathSync(path: Buffer, options: String /* "buffer" */): Buffer

external fun realpathSync(path: Buffer, options: `T$51`): Buffer

external fun realpathSync(path: URL, options: String /* "buffer" */): Buffer

external fun realpathSync(path: URL, options: `T$51`): Buffer

external fun unlink(path: String, callback: NoParamCallback)

external fun unlink(path: Buffer, callback: NoParamCallback)

external fun unlink(path: URL, callback: NoParamCallback)

external fun unlinkSync(path: String)

external fun unlinkSync(path: Buffer)

external fun unlinkSync(path: URL)

external interface RmDirOptions {
    var maxRetries: Number?
        get() = definedExternally
        set(value) = definedExternally
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var retryDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun rmdir(path: String, callback: NoParamCallback)

external fun rmdir(path: Buffer, callback: NoParamCallback)

external fun rmdir(path: URL, callback: NoParamCallback)

external fun rmdir(path: String, options: RmDirOptions, callback: NoParamCallback)

external fun rmdir(path: Buffer, options: RmDirOptions, callback: NoParamCallback)

external fun rmdir(path: URL, options: RmDirOptions, callback: NoParamCallback)

external fun rmdirSync(path: String, options: RmDirOptions = definedExternally)

external fun rmdirSync(path: String)

external fun rmdirSync(path: Buffer, options: RmDirOptions = definedExternally)

external fun rmdirSync(path: Buffer)

external fun rmdirSync(path: URL, options: RmDirOptions = definedExternally)

external fun rmdirSync(path: URL)

external interface RmOptions {
    var force: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var maxRetries: Number?
        get() = definedExternally
        set(value) = definedExternally
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var retryDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun rm(path: String, callback: NoParamCallback)

external fun rm(path: Buffer, callback: NoParamCallback)

external fun rm(path: URL, callback: NoParamCallback)

external fun rm(path: String, options: RmOptions, callback: NoParamCallback)

external fun rm(path: Buffer, options: RmOptions, callback: NoParamCallback)

external fun rm(path: URL, options: RmOptions, callback: NoParamCallback)

external fun rmSync(path: String, options: RmOptions = definedExternally)

external fun rmSync(path: String)

external fun rmSync(path: Buffer, options: RmOptions = definedExternally)

external fun rmSync(path: Buffer)

external fun rmSync(path: URL, options: RmOptions = definedExternally)

external fun rmSync(path: URL)

external interface MakeDirectoryOptions {
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var mode: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external fun mkdir(path: String, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$45` */, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: Buffer, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$45` */, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: URL, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$45` */, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: String, options: Number?, callback: NoParamCallback)

external fun mkdir(path: String, options: String?, callback: NoParamCallback)

external fun mkdir(path: String, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$46` */, callback: NoParamCallback)

external fun mkdir(path: Buffer, options: Number?, callback: NoParamCallback)

external fun mkdir(path: Buffer, options: String?, callback: NoParamCallback)

external fun mkdir(path: Buffer, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$46` */, callback: NoParamCallback)

external fun mkdir(path: URL, options: Number?, callback: NoParamCallback)

external fun mkdir(path: URL, options: String?, callback: NoParamCallback)

external fun mkdir(path: URL, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$46` */, callback: NoParamCallback)

external fun mkdir(path: String, options: Number?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: String, options: String?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: String, options: MakeDirectoryOptions?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: Buffer, options: Number?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: Buffer, options: String?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: Buffer, options: MakeDirectoryOptions?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: URL, options: Number?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: URL, options: String?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: URL, options: MakeDirectoryOptions?, callback: (err: ErrnoException?, path: String) -> Unit)

external fun mkdir(path: String, callback: NoParamCallback)

external fun mkdir(path: Buffer, callback: NoParamCallback)

external fun mkdir(path: URL, callback: NoParamCallback)

external fun mkdirSync(path: String, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$45` | MakeDirectoryOptions & `T$46` */): dynamic /* String | Unit */

external fun mkdirSync(path: Buffer, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$45` | MakeDirectoryOptions & `T$46` */): dynamic /* String | Unit */

external fun mkdirSync(path: URL, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$45` | MakeDirectoryOptions & `T$46` */): dynamic /* String | Unit */

external fun mkdirSync(path: String, options: Number? = definedExternally): dynamic /* Unit | String */

external fun mkdirSync(path: String): dynamic /* String */

external fun mkdirSync(path: String, options: String? = definedExternally): dynamic /* Unit | String */

external fun mkdirSync(path: Buffer, options: Number? = definedExternally): dynamic /* Unit | String */

external fun mkdirSync(path: Buffer): dynamic /* String */

external fun mkdirSync(path: Buffer, options: String? = definedExternally): dynamic /* Unit | String */

external fun mkdirSync(path: URL, options: Number? = definedExternally): dynamic /* Unit | String */

external fun mkdirSync(path: URL): dynamic /* String */

external fun mkdirSync(path: URL, options: String? = definedExternally): dynamic /* Unit | String */

external fun mkdirSync(path: String, options: MakeDirectoryOptions? = definedExternally): String?

external fun mkdirSync(path: Buffer, options: MakeDirectoryOptions? = definedExternally): String?

external fun mkdirSync(path: URL, options: MakeDirectoryOptions? = definedExternally): String?

external fun mkdtemp(prefix: String, options: ObjectEncodingOptions?, callback: (err: ErrnoException?, folder: String) -> Unit)

external fun mkdtemp(prefix: String, options: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, folder: String) -> Unit)

external fun mkdtemp(prefix: String, options: String /* "buffer" */, callback: (err: ErrnoException?, folder: Buffer) -> Unit)

external fun mkdtemp(prefix: String, options: `T$51`, callback: (err: ErrnoException?, folder: Buffer) -> Unit)

external fun mkdtemp(prefix: String, options: ObjectEncodingOptions?, callback: (err: ErrnoException?, folder: Any /* String | Buffer */) -> Unit)

external fun mkdtemp(prefix: String, options: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, folder: Any /* String | Buffer */) -> Unit)

external fun mkdtemp(prefix: String, callback: (err: ErrnoException?, folder: String) -> Unit)

external fun mkdtempSync(prefix: String, options: ObjectEncodingOptions? = definedExternally): dynamic /* String */

external fun mkdtempSync(prefix: String): dynamic /* String | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer | String | Buffer */

external fun mkdtempSync(prefix: String, options: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | "buffer" | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String | Buffer */

external fun mkdtempSync(prefix: String, options: `T$51`): Buffer

external interface `T$55` {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
    var withFileTypes: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun readdir(path: String, options: Any? /* `T$55`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, files: Array<String>) -> Unit)

external fun readdir(path: Buffer, options: Any? /* `T$55`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, files: Array<String>) -> Unit)

external fun readdir(path: URL, options: Any? /* `T$55`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, files: Array<String>) -> Unit)

external fun readdir(path: String, options: `T$48`, callback: (err: ErrnoException?, files: Array<Buffer>) -> Unit)

external fun readdir(path: String, options: String /* "buffer" */, callback: (err: ErrnoException?, files: Array<Buffer>) -> Unit)

external fun readdir(path: Buffer, options: `T$48`, callback: (err: ErrnoException?, files: Array<Buffer>) -> Unit)

external fun readdir(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException?, files: Array<Buffer>) -> Unit)

external fun readdir(path: URL, options: `T$48`, callback: (err: ErrnoException?, files: Array<Buffer>) -> Unit)

external fun readdir(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException?, files: Array<Buffer>) -> Unit)

external fun readdir(path: String, options: Any? /* ObjectEncodingOptions & `T$47` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, files: Any /* Array<String> | Array<Buffer> */) -> Unit)

external fun readdir(path: Buffer, options: Any? /* ObjectEncodingOptions & `T$47` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, files: Any /* Array<String> | Array<Buffer> */) -> Unit)

external fun readdir(path: URL, options: Any? /* ObjectEncodingOptions & `T$47` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, files: Any /* Array<String> | Array<Buffer> */) -> Unit)

external fun readdir(path: String, callback: (err: ErrnoException?, files: Array<String>) -> Unit)

external fun readdir(path: Buffer, callback: (err: ErrnoException?, files: Array<String>) -> Unit)

external fun readdir(path: URL, callback: (err: ErrnoException?, files: Array<String>) -> Unit)

external fun readdir(path: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$49` */, callback: (err: ErrnoException?, files: Array<Dirent>) -> Unit)

external fun readdir(path: Buffer, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$49` */, callback: (err: ErrnoException?, files: Array<Dirent>) -> Unit)

external fun readdir(path: URL, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$49` */, callback: (err: ErrnoException?, files: Array<Dirent>) -> Unit)

external fun readdirSync(path: String, options: Any? /* `T$55`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ObjectEncodingOptions & `T$47` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Array */

external fun readdirSync(path: String): dynamic /* Array */

external fun readdirSync(path: Buffer, options: Any? /* `T$55`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ObjectEncodingOptions & `T$47` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Array */

external fun readdirSync(path: Buffer): dynamic /* Array */

external fun readdirSync(path: URL, options: Any? /* `T$55`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ObjectEncodingOptions & `T$47` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Array */

external fun readdirSync(path: URL): dynamic /* Array */

external fun readdirSync(path: String, options: `T$48`): Array<Buffer>

external fun readdirSync(path: String, options: String /* "buffer" */): Array<Buffer>

external fun readdirSync(path: Buffer, options: `T$48`): Array<Buffer>

external fun readdirSync(path: Buffer, options: String /* "buffer" */): Array<Buffer>

external fun readdirSync(path: URL, options: `T$48`): Array<Buffer>

external fun readdirSync(path: URL, options: String /* "buffer" */): Array<Buffer>

external fun readdirSync(path: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$49` */): Array<Dirent>

external fun readdirSync(path: Buffer, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$49` */): Array<Dirent>

external fun readdirSync(path: URL, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$49` */): Array<Dirent>

external fun close(fd: Number, callback: NoParamCallback = definedExternally)

external fun closeSync(fd: Number)

external fun open(path: String, flags: Number, mode: Number?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: String, flags: Number, mode: String?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: String, flags: String, mode: Number?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: String, flags: String, mode: String?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: Buffer, flags: Number, mode: Number?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: Buffer, flags: Number, mode: String?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: Buffer, flags: String, mode: Number?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: Buffer, flags: String, mode: String?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: URL, flags: Number, mode: Number?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: URL, flags: Number, mode: String?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: URL, flags: String, mode: Number?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: URL, flags: String, mode: String?, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: String, flags: Number, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: String, flags: String, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: Buffer, flags: Number, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: Buffer, flags: String, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: URL, flags: Number, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun open(path: URL, flags: String, callback: (err: ErrnoException?, fd: Number) -> Unit)

external fun openSync(path: String, flags: Number, mode: Number? = definedExternally): Number

external fun openSync(path: String, flags: Number): Number

external fun openSync(path: String, flags: Number, mode: String? = definedExternally): Number

external fun openSync(path: String, flags: String, mode: Number? = definedExternally): Number

external fun openSync(path: String, flags: String): Number

external fun openSync(path: String, flags: String, mode: String? = definedExternally): Number

external fun openSync(path: Buffer, flags: Number, mode: Number? = definedExternally): Number

external fun openSync(path: Buffer, flags: Number): Number

external fun openSync(path: Buffer, flags: Number, mode: String? = definedExternally): Number

external fun openSync(path: Buffer, flags: String, mode: Number? = definedExternally): Number

external fun openSync(path: Buffer, flags: String): Number

external fun openSync(path: Buffer, flags: String, mode: String? = definedExternally): Number

external fun openSync(path: URL, flags: Number, mode: Number? = definedExternally): Number

external fun openSync(path: URL, flags: Number): Number

external fun openSync(path: URL, flags: Number, mode: String? = definedExternally): Number

external fun openSync(path: URL, flags: String, mode: Number? = definedExternally): Number

external fun openSync(path: URL, flags: String): Number

external fun openSync(path: URL, flags: String, mode: String? = definedExternally): Number

external fun utimes(path: String, atime: String, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: String, atime: Number, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: String, atime: Date, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: Buffer, atime: String, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: URL, atime: String, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: URL, atime: Number, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimes(path: URL, atime: Date, mtime: Any /* String | Number | Date */, callback: NoParamCallback)

external fun utimesSync(path: String, atime: String, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: String, atime: Number, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: String, atime: Date, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: Buffer, atime: String, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: URL, atime: String, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: URL, atime: Number, mtime: Any /* String | Number | Date */)

external fun utimesSync(path: URL, atime: Date, mtime: Any /* String | Number | Date */)

external fun futimes(fd: Number, atime: String, mtime: String, callback: NoParamCallback)

external fun futimes(fd: Number, atime: String, mtime: Number, callback: NoParamCallback)

external fun futimes(fd: Number, atime: String, mtime: Date, callback: NoParamCallback)

external fun futimes(fd: Number, atime: Number, mtime: String, callback: NoParamCallback)

external fun futimes(fd: Number, atime: Number, mtime: Number, callback: NoParamCallback)

external fun futimes(fd: Number, atime: Number, mtime: Date, callback: NoParamCallback)

external fun futimes(fd: Number, atime: Date, mtime: String, callback: NoParamCallback)

external fun futimes(fd: Number, atime: Date, mtime: Number, callback: NoParamCallback)

external fun futimes(fd: Number, atime: Date, mtime: Date, callback: NoParamCallback)

external fun futimesSync(fd: Number, atime: String, mtime: String)

external fun futimesSync(fd: Number, atime: String, mtime: Number)

external fun futimesSync(fd: Number, atime: String, mtime: Date)

external fun futimesSync(fd: Number, atime: Number, mtime: String)

external fun futimesSync(fd: Number, atime: Number, mtime: Number)

external fun futimesSync(fd: Number, atime: Number, mtime: Date)

external fun futimesSync(fd: Number, atime: Date, mtime: String)

external fun futimesSync(fd: Number, atime: Date, mtime: Number)

external fun futimesSync(fd: Number, atime: Date, mtime: Date)

external fun fsync(fd: Number, callback: NoParamCallback)

external fun fsyncSync(fd: Number)

external fun <TBuffer> write(fd: Number, buffer: TBuffer, offset: Number?, length: Number?, position: Number?, callback: (err: ErrnoException?, written: Number, buffer: TBuffer) -> Unit)

external fun <TBuffer> write(fd: Number, buffer: TBuffer, offset: Number?, length: Number?, callback: (err: ErrnoException?, written: Number, buffer: TBuffer) -> Unit)

external fun <TBuffer> write(fd: Number, buffer: TBuffer, offset: Number?, callback: (err: ErrnoException?, written: Number, buffer: TBuffer) -> Unit)

external fun <TBuffer> write(fd: Number, buffer: TBuffer, callback: (err: ErrnoException?, written: Number, buffer: TBuffer) -> Unit)

external fun write(fd: Number, string: String, position: Number?, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, written: Number, str: String) -> Unit)

external fun write(fd: Number, string: String, position: Number?, callback: (err: ErrnoException?, written: Number, str: String) -> Unit)

external fun write(fd: Number, string: String, callback: (err: ErrnoException?, written: Number, str: String) -> Unit)

external fun writeSync(fd: Number, buffer: Uint8Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint8Array): Number

external fun writeSync(fd: Number, buffer: Uint8Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint8Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint8ClampedArray, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint8ClampedArray): Number

external fun writeSync(fd: Number, buffer: Uint8ClampedArray, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint8ClampedArray, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint16Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint16Array): Number

external fun writeSync(fd: Number, buffer: Uint16Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint16Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint32Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint32Array): Number

external fun writeSync(fd: Number, buffer: Uint32Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Uint32Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int8Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int8Array): Number

external fun writeSync(fd: Number, buffer: Int8Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int8Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int16Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int16Array): Number

external fun writeSync(fd: Number, buffer: Int16Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int16Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int32Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int32Array): Number

external fun writeSync(fd: Number, buffer: Int32Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Int32Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: BigUint64Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: BigUint64Array): Number

external fun writeSync(fd: Number, buffer: BigUint64Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: BigUint64Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: BigInt64Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: BigInt64Array): Number

external fun writeSync(fd: Number, buffer: BigInt64Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: BigInt64Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Float32Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Float32Array): Number

external fun writeSync(fd: Number, buffer: Float32Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Float32Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Float64Array, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Float64Array): Number

external fun writeSync(fd: Number, buffer: Float64Array, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: Float64Array, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: DataView, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: DataView): Number

external fun writeSync(fd: Number, buffer: DataView, offset: Number? = definedExternally): Number

external fun writeSync(fd: Number, buffer: DataView, offset: Number? = definedExternally, length: Number? = definedExternally): Number

external fun writeSync(fd: Number, string: String, position: Number? = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Number

external fun writeSync(fd: Number, string: String): Number

external fun writeSync(fd: Number, string: String, position: Number? = definedExternally): Number

external fun <TBuffer> read(fd: Number, buffer: TBuffer, offset: Number, length: Number, position: Number?, callback: (err: ErrnoException?, bytesRead: Number, buffer: TBuffer) -> Unit)

external fun <TBuffer> read(fd: Number, buffer: TBuffer, offset: Number, length: Number, position: Any?, callback: (err: ErrnoException?, bytesRead: Number, buffer: TBuffer) -> Unit)

external interface ReadSyncOptions {
    var offset: Number?
        get() = definedExternally
        set(value) = definedExternally
    var length: Number?
        get() = definedExternally
        set(value) = definedExternally
    var position: dynamic /* Number? | Any? */
        get() = definedExternally
        set(value) = definedExternally
}

external fun readSync(fd: Number, buffer: Uint8Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Uint8ClampedArray, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Uint16Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Uint32Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Int8Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Int16Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Int32Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: BigUint64Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: BigInt64Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Float32Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Float64Array, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: DataView, offset: Number, length: Number, position: Any? /* Number? | Any? */): Number

external fun readSync(fd: Number, buffer: Uint8Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Uint8Array): Number

external fun readSync(fd: Number, buffer: Uint8ClampedArray, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Uint8ClampedArray): Number

external fun readSync(fd: Number, buffer: Uint16Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Uint16Array): Number

external fun readSync(fd: Number, buffer: Uint32Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Uint32Array): Number

external fun readSync(fd: Number, buffer: Int8Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Int8Array): Number

external fun readSync(fd: Number, buffer: Int16Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Int16Array): Number

external fun readSync(fd: Number, buffer: Int32Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Int32Array): Number

external fun readSync(fd: Number, buffer: BigUint64Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: BigUint64Array): Number

external fun readSync(fd: Number, buffer: BigInt64Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: BigInt64Array): Number

external fun readSync(fd: Number, buffer: Float32Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Float32Array): Number

external fun readSync(fd: Number, buffer: Float64Array, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: Float64Array): Number

external fun readSync(fd: Number, buffer: DataView, opts: ReadSyncOptions = definedExternally): Number

external fun readSync(fd: Number, buffer: DataView): Number

external interface `T$57` {
    var encoding: Any?
        get() = definedExternally
        set(value) = definedExternally
    var flag: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun readFile(path: String, options: `T$57` /* `T$57` & Abortable */, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFile(path: Buffer, options: `T$57` /* `T$57` & Abortable */, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFile(path: URL, options: `T$57` /* `T$57` & Abortable */, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFile(path: Number, options: `T$57` /* `T$57` & Abortable */, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external interface `T$58` {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
    var flag: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun readFile(path: String, options: Any /* `T$58` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: String) -> Unit)

external fun readFile(path: Buffer, options: Any /* `T$58` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: String) -> Unit)

external fun readFile(path: URL, options: Any /* `T$58` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: String) -> Unit)

external fun readFile(path: Number, options: Any /* `T$58` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: String) -> Unit)

external interface `T$59` {
    var flag: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun readFile(path: String, options: Any? /* ObjectEncodingOptions & `T$59` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: Any /* String | Buffer */) -> Unit)

external fun readFile(path: Buffer, options: Any? /* ObjectEncodingOptions & `T$59` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: Any /* String | Buffer */) -> Unit)

external fun readFile(path: URL, options: Any? /* ObjectEncodingOptions & `T$59` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: Any /* String | Buffer */) -> Unit)

external fun readFile(path: Number, options: Any? /* ObjectEncodingOptions & `T$59` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, data: Any /* String | Buffer */) -> Unit)

external fun readFile(path: String, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFile(path: Buffer, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFile(path: URL, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFile(path: Number, callback: (err: ErrnoException?, data: Buffer) -> Unit)

external fun readFileSync(path: String, options: `T$57`? = definedExternally): Buffer

external fun readFileSync(path: String): dynamic /* Buffer */

external fun readFileSync(path: Buffer, options: `T$57`? = definedExternally): Buffer

external fun readFileSync(path: Buffer): dynamic /* Buffer */

external fun readFileSync(path: URL, options: `T$57`? = definedExternally): Buffer

external fun readFileSync(path: URL): dynamic /* Buffer */

external fun readFileSync(path: Number, options: `T$57`? = definedExternally): Buffer

external fun readFileSync(path: Number): dynamic /* Buffer */

external fun readFileSync(path: String, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): String

external fun readFileSync(path: Buffer, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): String

external fun readFileSync(path: URL, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): String

external fun readFileSync(path: Number, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): String

external fun readFileSync(path: String, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String | Buffer */

external fun readFileSync(path: Buffer, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String | Buffer */

external fun readFileSync(path: URL, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String | Buffer */

external fun readFileSync(path: Number, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String | Buffer */

external interface `T$60` {
    var mode: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var flag: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun writeFile(file: String, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun writeFile(file: Buffer, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun writeFile(file: URL, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun writeFile(file: Number, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun writeFile(path: String, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, callback: NoParamCallback)

external fun writeFile(path: Buffer, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, callback: NoParamCallback)

external fun writeFile(path: URL, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, callback: NoParamCallback)

external fun writeFile(path: Number, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, callback: NoParamCallback)

external fun writeFileSync(file: String, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun writeFileSync(file: String, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */)

external fun writeFileSync(file: Buffer, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun writeFileSync(file: Buffer, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */)

external fun writeFileSync(file: URL, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun writeFileSync(file: URL, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */)

external fun writeFileSync(file: Number, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun writeFileSync(file: Number, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */)

external fun appendFile(path: String, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: String, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: Buffer, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: Buffer, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: URL, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: URL, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: Number, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(path: Number, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: NoParamCallback)

external fun appendFile(file: String, data: String, callback: NoParamCallback)

external fun appendFile(file: String, data: Uint8Array, callback: NoParamCallback)

external fun appendFile(file: Buffer, data: String, callback: NoParamCallback)

external fun appendFile(file: Buffer, data: Uint8Array, callback: NoParamCallback)

external fun appendFile(file: URL, data: String, callback: NoParamCallback)

external fun appendFile(file: URL, data: Uint8Array, callback: NoParamCallback)

external fun appendFile(file: Number, data: String, callback: NoParamCallback)

external fun appendFile(file: Number, data: Uint8Array, callback: NoParamCallback)

external fun appendFileSync(path: String, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: String, data: String)

external fun appendFileSync(path: String, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: String, data: Uint8Array)

external fun appendFileSync(path: Buffer, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: Buffer, data: String)

external fun appendFileSync(path: Buffer, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: Buffer, data: Uint8Array)

external fun appendFileSync(path: URL, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: URL, data: String)

external fun appendFileSync(path: URL, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: URL, data: Uint8Array)

external fun appendFileSync(path: Number, data: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: Number, data: String)

external fun appendFileSync(path: Number, data: Uint8Array, options: Any? /* ObjectEncodingOptions & Abortable & `T$60` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally)

external fun appendFileSync(path: Number, data: Uint8Array)

external interface WatchFileOptions {
    var bigint: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var persistent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var interval: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun watchFile(filename: String, options: WatchFileOptions /* WatchFileOptions & `T$41` */, listener: (curr: Stats, prev: Stats) -> Unit): StatWatcher

external fun watchFile(filename: Buffer, options: WatchFileOptions /* WatchFileOptions & `T$41` */, listener: (curr: Stats, prev: Stats) -> Unit): StatWatcher

external fun watchFile(filename: URL, options: WatchFileOptions /* WatchFileOptions & `T$41` */, listener: (curr: Stats, prev: Stats) -> Unit): StatWatcher

external fun watchFile(filename: String, options: WatchFileOptions /* WatchFileOptions & `T$42` */, listener: (curr: BigIntStats, prev: BigIntStats) -> Unit): StatWatcher

external fun watchFile(filename: Buffer, options: WatchFileOptions /* WatchFileOptions & `T$42` */, listener: (curr: BigIntStats, prev: BigIntStats) -> Unit): StatWatcher

external fun watchFile(filename: URL, options: WatchFileOptions /* WatchFileOptions & `T$42` */, listener: (curr: BigIntStats, prev: BigIntStats) -> Unit): StatWatcher

external fun watchFile(filename: String, listener: (curr: Stats, prev: Stats) -> Unit): StatWatcher

external fun watchFile(filename: Buffer, listener: (curr: Stats, prev: Stats) -> Unit): StatWatcher

external fun watchFile(filename: URL, listener: (curr: Stats, prev: Stats) -> Unit): StatWatcher

external fun unwatchFile(filename: String, listener: (curr: Stats, prev: Stats) -> Unit = definedExternally)

external fun unwatchFile(filename: String)

external fun unwatchFile(filename: Buffer, listener: (curr: Stats, prev: Stats) -> Unit = definedExternally)

external fun unwatchFile(filename: Buffer)

external fun unwatchFile(filename: URL, listener: (curr: Stats, prev: Stats) -> Unit = definedExternally)

external fun unwatchFile(filename: URL)

external interface WatchOptions : Abortable {
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | "buffer" */
        get() = definedExternally
        set(value) = definedExternally
    var persistent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun watch(filename: String, options: WatchOptions /* WatchOptions & `T$51` */, listener: WatchListener<Buffer> = definedExternally): FSWatcher

external fun watch(filename: String, options: WatchOptions /* WatchOptions & `T$51` */): FSWatcher

external fun watch(filename: String, options: String /* "buffer" */, listener: WatchListener<Buffer> = definedExternally): FSWatcher

external fun watch(filename: String, options: String /* "buffer" */): FSWatcher

external fun watch(filename: Buffer, options: WatchOptions /* WatchOptions & `T$51` */, listener: WatchListener<Buffer> = definedExternally): FSWatcher

external fun watch(filename: Buffer, options: WatchOptions /* WatchOptions & `T$51` */): FSWatcher

external fun watch(filename: Buffer, options: String /* "buffer" */, listener: WatchListener<Buffer> = definedExternally): FSWatcher

external fun watch(filename: Buffer, options: String /* "buffer" */): FSWatcher

external fun watch(filename: URL, options: WatchOptions /* WatchOptions & `T$51` */, listener: WatchListener<Buffer> = definedExternally): FSWatcher

external fun watch(filename: URL, options: WatchOptions /* WatchOptions & `T$51` */): FSWatcher

external fun watch(filename: URL, options: String /* "buffer" */, listener: WatchListener<Buffer> = definedExternally): FSWatcher

external fun watch(filename: URL, options: String /* "buffer" */): FSWatcher

external fun watch(filename: String, options: Any? /* WatchOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, listener: WatchListener<String> = definedExternally): FSWatcher

external fun watch(filename: String): FSWatcher

external fun watch(filename: String, options: Any? /* WatchOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): FSWatcher

external fun watch(filename: Buffer, options: Any? /* WatchOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, listener: WatchListener<String> = definedExternally): FSWatcher

external fun watch(filename: Buffer): FSWatcher

external fun watch(filename: Buffer, options: Any? /* WatchOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): FSWatcher

external fun watch(filename: URL, options: Any? /* WatchOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally, listener: WatchListener<String> = definedExternally): FSWatcher

external fun watch(filename: URL): FSWatcher

external fun watch(filename: URL, options: Any? /* WatchOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): FSWatcher

external fun watch(filename: String, options: WatchOptions, listener: WatchListener<Any /* String | Buffer */> = definedExternally): FSWatcher

external fun watch(filename: String, options: String, listener: WatchListener<Any /* String | Buffer */> = definedExternally): FSWatcher

external fun watch(filename: Buffer, options: WatchOptions, listener: WatchListener<Any /* String | Buffer */> = definedExternally): FSWatcher

external fun watch(filename: Buffer, options: String, listener: WatchListener<Any /* String | Buffer */> = definedExternally): FSWatcher

external fun watch(filename: URL, options: WatchOptions, listener: WatchListener<Any /* String | Buffer */> = definedExternally): FSWatcher

external fun watch(filename: URL, options: String, listener: WatchListener<Any /* String | Buffer */> = definedExternally): FSWatcher

external fun watch(filename: String, listener: WatchListener<String> = definedExternally): FSWatcher

external fun watch(filename: Buffer, listener: WatchListener<String> = definedExternally): FSWatcher

external fun watch(filename: URL, listener: WatchListener<String> = definedExternally): FSWatcher

external fun exists(path: String, callback: (exists: Boolean) -> Unit)

external fun exists(path: Buffer, callback: (exists: Boolean) -> Unit)

external fun exists(path: URL, callback: (exists: Boolean) -> Unit)

external fun existsSync(path: String): Boolean

external fun existsSync(path: Buffer): Boolean

external fun existsSync(path: URL): Boolean

external fun access(path: String, mode: Number?, callback: NoParamCallback)

external fun access(path: Buffer, mode: Number?, callback: NoParamCallback)

external fun access(path: URL, mode: Number?, callback: NoParamCallback)

external fun access(path: String, callback: NoParamCallback)

external fun access(path: Buffer, callback: NoParamCallback)

external fun access(path: URL, callback: NoParamCallback)

external fun accessSync(path: String, mode: Number = definedExternally)

external fun accessSync(path: String)

external fun accessSync(path: Buffer, mode: Number = definedExternally)

external fun accessSync(path: Buffer)

external fun accessSync(path: URL, mode: Number = definedExternally)

external fun accessSync(path: URL)

external interface StreamOptions {
    var flags: String?
        get() = definedExternally
        set(value) = definedExternally
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
        get() = definedExternally
        set(value) = definedExternally
    var fd: dynamic /* Number? | promises.FileHandle? */
        get() = definedExternally
        set(value) = definedExternally
    var mode: Number?
        get() = definedExternally
        set(value) = definedExternally
    var autoClose: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var emitClose: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var start: Number?
        get() = definedExternally
        set(value) = definedExternally
    var highWaterMark: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadStreamOptions : StreamOptions {
    var end: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun createReadStream(path: String, options: Any /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ReadStreamOptions */ = definedExternally): ReadStream

external fun createReadStream(path: String): ReadStream

external fun createReadStream(path: Buffer, options: Any /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ReadStreamOptions */ = definedExternally): ReadStream

external fun createReadStream(path: Buffer): ReadStream

external fun createReadStream(path: URL, options: Any /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ReadStreamOptions */ = definedExternally): ReadStream

external fun createReadStream(path: URL): ReadStream

external fun createWriteStream(path: String, options: Any /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | StreamOptions */ = definedExternally): WriteStream

external fun createWriteStream(path: String): WriteStream

external fun createWriteStream(path: Buffer, options: Any /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | StreamOptions */ = definedExternally): WriteStream

external fun createWriteStream(path: Buffer): WriteStream

external fun createWriteStream(path: URL, options: Any /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | StreamOptions */ = definedExternally): WriteStream

external fun createWriteStream(path: URL): WriteStream

external fun fdatasync(fd: Number, callback: NoParamCallback)

external fun fdatasyncSync(fd: Number)

external fun copyFile(src: String, dest: String, callback: NoParamCallback)

external fun copyFile(src: String, dest: Buffer, callback: NoParamCallback)

external fun copyFile(src: String, dest: URL, callback: NoParamCallback)

external fun copyFile(src: Buffer, dest: String, callback: NoParamCallback)

external fun copyFile(src: Buffer, dest: Buffer, callback: NoParamCallback)

external fun copyFile(src: Buffer, dest: URL, callback: NoParamCallback)

external fun copyFile(src: URL, dest: String, callback: NoParamCallback)

external fun copyFile(src: URL, dest: Buffer, callback: NoParamCallback)

external fun copyFile(src: URL, dest: URL, callback: NoParamCallback)

external fun copyFile(src: String, dest: String, mode: Number, callback: NoParamCallback)

external fun copyFile(src: String, dest: Buffer, mode: Number, callback: NoParamCallback)

external fun copyFile(src: String, dest: URL, mode: Number, callback: NoParamCallback)

external fun copyFile(src: Buffer, dest: String, mode: Number, callback: NoParamCallback)

external fun copyFile(src: Buffer, dest: Buffer, mode: Number, callback: NoParamCallback)

external fun copyFile(src: Buffer, dest: URL, mode: Number, callback: NoParamCallback)

external fun copyFile(src: URL, dest: String, mode: Number, callback: NoParamCallback)

external fun copyFile(src: URL, dest: Buffer, mode: Number, callback: NoParamCallback)

external fun copyFile(src: URL, dest: URL, mode: Number, callback: NoParamCallback)

external fun copyFileSync(src: String, dest: String, mode: Number = definedExternally)

external fun copyFileSync(src: String, dest: String)

external fun copyFileSync(src: String, dest: Buffer, mode: Number = definedExternally)

external fun copyFileSync(src: String, dest: Buffer)

external fun copyFileSync(src: String, dest: URL, mode: Number = definedExternally)

external fun copyFileSync(src: String, dest: URL)

external fun copyFileSync(src: Buffer, dest: String, mode: Number = definedExternally)

external fun copyFileSync(src: Buffer, dest: String)

external fun copyFileSync(src: Buffer, dest: Buffer, mode: Number = definedExternally)

external fun copyFileSync(src: Buffer, dest: Buffer)

external fun copyFileSync(src: Buffer, dest: URL, mode: Number = definedExternally)

external fun copyFileSync(src: Buffer, dest: URL)

external fun copyFileSync(src: URL, dest: String, mode: Number = definedExternally)

external fun copyFileSync(src: URL, dest: String)

external fun copyFileSync(src: URL, dest: Buffer, mode: Number = definedExternally)

external fun copyFileSync(src: URL, dest: Buffer)

external fun copyFileSync(src: URL, dest: URL, mode: Number = definedExternally)

external fun copyFileSync(src: URL, dest: URL)

external fun writev(fd: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, cb: (err: ErrnoException?, bytesWritten: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>) -> Unit)

external fun writev(fd: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, position: Number, cb: (err: ErrnoException?, bytesWritten: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>) -> Unit)

external interface WriteVResult {
    var bytesWritten: Number
    var buffers: Array<dynamic /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>
}

external fun writevSync(fd: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, position: Number = definedExternally): Number

external fun readv(fd: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, cb: (err: ErrnoException?, bytesRead: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>) -> Unit)

external fun readv(fd: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, position: Number, cb: (err: ErrnoException?, bytesRead: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>) -> Unit)

external interface ReadVResult {
    var bytesRead: Number
    var buffers: Array<dynamic /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>
}

external fun readvSync(fd: Number, buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, position: Number = definedExternally): Number

external interface OpenDirOptions {
    var encoding: String? /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
        get() = definedExternally
        set(value) = definedExternally
    var bufferSize: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external fun opendirSync(path: String, options: OpenDirOptions = definedExternally): Dir

external fun opendirSync(path: String): Dir

external fun opendirSync(path: Buffer, options: OpenDirOptions = definedExternally): Dir

external fun opendirSync(path: Buffer): Dir

external fun opendirSync(path: URL, options: OpenDirOptions = definedExternally): Dir

external fun opendirSync(path: URL): Dir

external fun opendir(path: String, cb: (err: ErrnoException?, dir: Dir) -> Unit)

external fun opendir(path: Buffer, cb: (err: ErrnoException?, dir: Dir) -> Unit)

external fun opendir(path: URL, cb: (err: ErrnoException?, dir: Dir) -> Unit)

external fun opendir(path: String, options: OpenDirOptions, cb: (err: ErrnoException?, dir: Dir) -> Unit)

external fun opendir(path: Buffer, options: OpenDirOptions, cb: (err: ErrnoException?, dir: Dir) -> Unit)

external fun opendir(path: URL, options: OpenDirOptions, cb: (err: ErrnoException?, dir: Dir) -> Unit)

external interface BigIntStats : StatsBase<Any> {
    var atimeNs: Any
    var mtimeNs: Any
    var ctimeNs: Any
    var birthtimeNs: Any
}

external interface BigIntOptions {
    var bigint: Boolean
}

external interface StatOptions {
    var bigint: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface StatSyncOptions : StatOptions {
    var throwIfNoEntry: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CopyOptions {
    var dereference: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var errorOnExist: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val filter: ((source: String, destination: String) -> Boolean)?
    var force: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var preserveTimestamps: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun cp(source: String, destination: String, callback: (err: ErrnoException?) -> Unit)

external fun cp(source: String, destination: String, opts: CopyOptions, callback: (err: ErrnoException?) -> Unit)

external fun cpSync(source: String, destination: String, opts: CopyOptions = definedExternally)