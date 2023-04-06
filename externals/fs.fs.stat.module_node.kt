@file:JsQualifier("fs.stat")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.stat

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
import fs.StatOptions
import buffer.global.Buffer
import url.URL

external fun __promisify__(path: String, options: StatOptions /* StatOptions & `T$41` | StatOptions & `T$42` */ = definedExternally): dynamic /* Promise */

external fun __promisify__(path: String): dynamic /* Promise | Promise */

external fun __promisify__(path: Buffer, options: StatOptions /* StatOptions & `T$41` | StatOptions & `T$42` */ = definedExternally): dynamic /* Promise */

external fun __promisify__(path: Buffer): dynamic /* Promise | Promise */

external fun __promisify__(path: URL, options: StatOptions /* StatOptions & `T$41` | StatOptions & `T$42` */ = definedExternally): dynamic /* Promise */

external fun __promisify__(path: URL): dynamic /* Promise | Promise */