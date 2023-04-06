package cz.sazel.sqldelight.node.sqlite3

private fun <T> jsObject(block: T.() -> Unit): T {
    val o = js("{}").unsafeCast<T>()
    block(o)
    return o
}
