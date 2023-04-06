@file:JsQualifier("crypto.generateKeyPair")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package crypto.generateKeyPair

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
import crypto.RSAKeyPairOptions
import buffer.global.Buffer
import crypto.RSAKeyPairKeyObjectOptions
import crypto.KeyPairKeyObjectResult
import crypto.RSAPSSKeyPairOptions
import crypto.RSAPSSKeyPairKeyObjectOptions
import crypto.DSAKeyPairOptions
import crypto.DSAKeyPairKeyObjectOptions
import crypto.ECKeyPairOptions
import crypto.ECKeyPairKeyObjectOptions
import crypto.ED25519KeyPairOptions
import crypto.ED25519KeyPairKeyObjectOptions
import crypto.ED448KeyPairOptions
import crypto.ED448KeyPairKeyObjectOptions
import crypto.X25519KeyPairOptions
import crypto.X25519KeyPairKeyObjectOptions
import crypto.X448KeyPairOptions
import crypto.X448KeyPairKeyObjectOptions

external interface `T$33` {
    var publicKey: String
    var privateKey: String
}

external fun __promisify__(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external interface `T$34` {
    var publicKey: String
    var privateKey: Buffer
}

external interface `T$35` {
    var publicKey: Buffer
    var privateKey: String
}

external interface `T$36` {
    var publicKey: Buffer
    var privateKey: Buffer
}

external fun __promisify__(type: String /* "rsa" */, options: RSAKeyPairKeyObjectOptions): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "rsa-pss" */, options: RSAPSSKeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "rsa-pss" */, options: RSAPSSKeyPairKeyObjectOptions): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "dsa" */, options: DSAKeyPairKeyObjectOptions): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "ec" */, options: ECKeyPairKeyObjectOptions): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "ed25519" */, options: ED25519KeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "ed25519" */, options: ED25519KeyPairKeyObjectOptions = definedExternally): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "ed25519" | "ed448" | "x25519" | "x448" */): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "ed448" */, options: ED448KeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "ed448" */, options: ED448KeyPairKeyObjectOptions = definedExternally): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "x25519" */, options: X25519KeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "x25519" */, options: X25519KeyPairKeyObjectOptions = definedExternally): Promise<KeyPairKeyObjectResult>

external fun __promisify__(type: String /* "x448" */, options: X448KeyPairOptions<String /* "pem" | "der" | "der" */, String /* "pem" | "der" | "pem" | "der" */>): dynamic /* Promise */

external fun __promisify__(type: String /* "x448" */, options: X448KeyPairKeyObjectOptions = definedExternally): Promise<KeyPairKeyObjectResult>