@file:JsQualifier("fs.opendir")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.opendir

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
import fs.OpenDirOptions
import fs.Dir
import buffer.global.Buffer
import url.URL

external fun __promisify__(path: String, options: OpenDirOptions = definedExternally): Promise<Dir>

external fun __promisify__(path: String): Promise<Dir>

external fun __promisify__(path: Buffer, options: OpenDirOptions = definedExternally): Promise<Dir>

external fun __promisify__(path: Buffer): Promise<Dir>

external fun __promisify__(path: URL, options: OpenDirOptions = definedExternally): Promise<Dir>

external fun __promisify__(path: URL): Promise<Dir>