package cz.sazel.sqldelight.node.sqlite3

import node.sqlite3.Sqlite3

internal fun sqlite3Exports(): dynamic = unwrapDefault(Sqlite3)

internal fun unwrapDefault(module: dynamic): dynamic =
    if (module != null && module.Database == undefined && module.default != undefined) module.default else module

@Suppress("UnusedParameter")
internal fun newDatabase(constructor: dynamic, filename: String, mode: Number): Sqlite3.Database =
    js("new constructor(filename, mode)").unsafeCast<Sqlite3.Database>()

internal fun openFlags(): Int {
    val exports = sqlite3Exports()
    return (exports.OPEN_CREATE as Number).toInt() or (exports.OPEN_READWRITE as Number).toInt()
}
