package cz.sazel.sqldelight.node.sqlite.test

@Suppress("UnusedParameter")
@JsModule("node:fs")
internal external object NodeFs {
    fun existsSync(path: String): Boolean
    fun unlinkSync(path: String)
}

fun unlinkSync(path: String) = NodeFs.unlinkSync(path)

fun deleteIfExists(path: String) {
    if (NodeFs.existsSync(path)) NodeFs.unlinkSync(path)
}

fun fileExists(path: String): Boolean = NodeFs.existsSync(path)
