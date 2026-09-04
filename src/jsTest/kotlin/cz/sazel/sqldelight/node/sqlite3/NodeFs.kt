package cz.sazel.sqldelight.node.sqlite3

@Suppress("UnusedParameter")
@JsModule("node:fs")
external object NodeFs {
    fun existsSync(path: String): Boolean
    fun unlinkSync(path: String)
}

internal fun unlinkSync(path: String) = NodeFs.unlinkSync(path)

internal fun deleteIfExists(path: String) {
    if (NodeFs.existsSync(path)) NodeFs.unlinkSync(path)
}
