@file:JsQualifier("fs.realpathSync")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.realpathSync

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

external fun native(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun native(path: String): dynamic /* String */

external fun native(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun native(path: Buffer): dynamic /* String */

external fun native(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* String */

external fun native(path: URL): dynamic /* String */

external fun native(path: String, options: String /* "buffer" */): Buffer

external fun native(path: String, options: `T$51`): Buffer

external fun native(path: Buffer, options: String /* "buffer" */): Buffer

external fun native(path: Buffer, options: `T$51`): Buffer

external fun native(path: URL, options: String /* "buffer" */): Buffer

external fun native(path: URL, options: `T$51`): Buffer