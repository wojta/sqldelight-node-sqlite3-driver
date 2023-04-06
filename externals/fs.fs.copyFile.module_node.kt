@file:JsQualifier("fs.copyFile")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.copyFile

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

external fun __promisify__(src: String, dst: String, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: String, dst: String): Promise<Unit>

external fun __promisify__(src: String, dst: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: String, dst: Buffer): Promise<Unit>

external fun __promisify__(src: String, dst: URL, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: String, dst: URL): Promise<Unit>

external fun __promisify__(src: Buffer, dst: String, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: Buffer, dst: String): Promise<Unit>

external fun __promisify__(src: Buffer, dst: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: Buffer, dst: Buffer): Promise<Unit>

external fun __promisify__(src: Buffer, dst: URL, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: Buffer, dst: URL): Promise<Unit>

external fun __promisify__(src: URL, dst: String, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: URL, dst: String): Promise<Unit>

external fun __promisify__(src: URL, dst: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: URL, dst: Buffer): Promise<Unit>

external fun __promisify__(src: URL, dst: URL, mode: Number = definedExternally): Promise<Unit>

external fun __promisify__(src: URL, dst: URL): Promise<Unit>