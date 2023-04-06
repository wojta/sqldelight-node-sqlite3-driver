@file:JsQualifier("fs.realpath")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.realpath

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
import buffer.global.Buffer
import url.URL
import fs.promises.`T$51`
import NodeJS.ErrnoException

external fun __promisify__(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun __promisify__(path: String): dynamic /* Promise | Promise */

external fun __promisify__(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun __promisify__(path: Buffer): dynamic /* Promise | Promise */

external fun __promisify__(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun __promisify__(path: URL): dynamic /* Promise | Promise */

external fun __promisify__(path: String, options: String /* "buffer" */): Promise<Buffer>

external fun __promisify__(path: String, options: `T$51`): Promise<Buffer>

external fun __promisify__(path: Buffer, options: String /* "buffer" */): Promise<Buffer>

external fun __promisify__(path: Buffer, options: `T$51`): Promise<Buffer>

external fun __promisify__(path: URL, options: String /* "buffer" */): Promise<Buffer>

external fun __promisify__(path: URL, options: `T$51`): Promise<Buffer>

external fun native(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun native(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun native(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun native(path: String, options: String /* "buffer" */, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun native(path: String, options: `T$51`, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun native(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun native(path: Buffer, options: `T$51`, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun native(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun native(path: URL, options: `T$51`, callback: (err: ErrnoException?, resolvedPath: Buffer) -> Unit)

external fun native(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: Any /* String | Buffer */) -> Unit)

external fun native(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: Any /* String | Buffer */) -> Unit)

external fun native(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */, callback: (err: ErrnoException?, resolvedPath: Any /* String | Buffer */) -> Unit)

external fun native(path: String, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun native(path: Buffer, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)

external fun native(path: URL, callback: (err: ErrnoException?, resolvedPath: String) -> Unit)