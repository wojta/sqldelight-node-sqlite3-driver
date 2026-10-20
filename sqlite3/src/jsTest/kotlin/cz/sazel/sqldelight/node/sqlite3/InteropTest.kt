package cz.sazel.sqldelight.node.sqlite3

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class InteropTest {

    @Test
    fun commonJsNamespaceIsUsedAsIs() {
        val module = js("({ Database: function () {}, OPEN_CREATE: 4 })")
        assertSame(module, unwrapDefault(module))
    }

    @Test
    fun esModuleNamespaceIsUnwrappedToDefault() {
        val module = js("({ default: { Database: function () {}, OPEN_CREATE: 4 } })")
        assertSame(module.default, unwrapDefault(module))
    }

    @Test
    fun namespaceExposingBothPrefersOwnDatabase() {
        val module = js("({ Database: function () {}, default: { Database: function () {} } })")
        assertSame(module, unwrapDefault(module))
    }

    @Test
    fun openFlagsCombinesCreateAndReadWrite() {
        assertEquals(6, openFlags())
    }
}
