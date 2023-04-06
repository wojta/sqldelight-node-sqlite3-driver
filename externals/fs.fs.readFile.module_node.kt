@file:JsQualifier("fs.readFile")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.readFile

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
import fs.`T$57`
import buffer.global.Buffer
import url.URL

external fun __promisify__(path: String, options: `T$57`? = definedExternally): Promise<Buffer>

external fun __promisify__(path: String): dynamic /* Promise | Promise */

external fun __promisify__(path: Buffer, options: `T$57`? = definedExternally): Promise<Buffer>

external fun __promisify__(path: Buffer): dynamic /* Promise | Promise */

external fun __promisify__(path: URL, options: `T$57`? = definedExternally): Promise<Buffer>

external fun __promisify__(path: URL): dynamic /* Promise | Promise */

external fun __promisify__(path: Number, options: `T$57`? = definedExternally): Promise<Buffer>

external fun __promisify__(path: Number): dynamic /* Promise | Promise */

external fun __promisify__(path: String, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun __promisify__(path: Buffer, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun __promisify__(path: URL, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun __promisify__(path: Number, options: Any /* `T$58` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun __promisify__(path: String, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun __promisify__(path: Buffer, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun __promisify__(path: URL, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun __promisify__(path: Number, options: Any? /* ObjectEncodingOptions & `T$59` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>