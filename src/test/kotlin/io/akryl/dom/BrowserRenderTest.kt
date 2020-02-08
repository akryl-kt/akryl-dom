package io.akryl.dom

import io.akryl.component
import io.akryl.dom.html.Div
import io.akryl.dom.html.Text
import react_dom.ReactDom
import kotlin.browser.document
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private fun testComponent() = component {
    Div(Text("Text from component"))
}

class BrowserRenderTest {
    @Test
    fun render() {
        val element = Div(Text("Hello, World!"))
        val result = ReactDom.render(element, document.body)
        assertEquals(document.body, result.parentElement)
        assertEquals("<div>Hello, World!</div>", document.body?.innerHTML)
    }

    @Test
    fun renderWithCallback() {
        var called = false
        val element = Div(Text("Hello, World!"))
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