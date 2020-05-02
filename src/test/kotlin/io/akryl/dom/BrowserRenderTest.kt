package io.akryl.dom

import io.akryl.component
import io.akryl.dom.html.div
import io.akryl.dom.html.text
import react_dom.ReactDom
import kotlin.browser.document
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private fun testComponent() = component {
    div(text("Text from component"))
}

class BrowserRenderTest {
    @Test
    fun render() {
        val element = div(text("Hello, World!"))
        val result = ReactDom.render(element, document.body)
        assertEquals(document.body, result.parentElement)
        assertEquals("<div>Hello, World!</div>", document.body?.innerHTML)
    }

    @Test
    fun renderWithCallback() {
        var called = false
        val element = div(text("Hello, World!"))
        ReactDom.render(element, document.body) { called = true }
        assertTrue(called)
    }

    @Test
    fun renderComponent() {
        val element = testComponent()
        ReactDom.render(element, document.body)
        assertEquals("<div>Text from component</div>", document.body?.innerHTML)
    }
}