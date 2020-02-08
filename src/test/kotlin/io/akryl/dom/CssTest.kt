package io.akryl.dom

import io.akryl.dom.css.SelectorStyles
import io.akryl.dom.css.StyleProperty
import io.akryl.dom.css.cssRegistry
import io.akryl.dom.html.Div
import io.akryl.dom.html.Span
import org.w3c.dom.HTMLStyleElement
import org.w3c.dom.asList
import react_test_renderer.ReactTestRenderer
import react_test_renderer.aktCreate
import utils.assertJsonEquals
import kotlin.browser.document
import kotlin.js.json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class CssTest {
    @Test
    fun testStyledDiv() {
        val root = ReactTestRenderer.aktCreate {
            Div(
                style = listOf(
                    StyleProperty("width", "100px"),
                    StyleProperty("display", "grid"),
                    StyleProperty("gridTemplateColumn", "1fr auto")
                )
            )
        }

        assertJsonEquals(
            json(
                "type" to "div",
                "props" to json(
                    "style" to json(
                        "width" to "100px",
                        "display" to "grid",
                        "gridTemplateColumn" to "1fr auto"
                    )
                ),
                "children" to null
            ),
            root.toJSON()
        )
    }

    @Test
    fun testInlineCssCached() {
        val css1 = listOf(
            StyleProperty("width", "100px"),
            StyleProperty("height", "100px")
        )
        val css2 = listOf(
            StyleProperty("color", "red"),
            StyleProperty("fontSize", "32px")
        )
        val css3 = ArrayList(css2)

        val root = ReactTestRenderer.aktCreate {
            Div(
                Div(css = css1),
                Span(css = css2),
                Span(css = css3)
            )
        }

        val json = root.toJSON().asDynamic()
        val actualClasses = listOf(
            json.children[0].props.className,
            json.children[1].props.className,
            json.children[2].props.className
        )
        val expectedClasses = listOf(
            cssRegistry.findOrCreateClassName(css1),
            cssRegistry.findOrCreateClassName(css2),
            cssRegistry.findOrCreateClassName(css3)
        )

        assertEquals(actualClasses, expectedClasses)
        assertNotEquals(actualClasses[0], actualClasses[1])
        assertEquals(actualClasses[1], actualClasses[2])
    }

    @Test
    fun testInlineCssInjectedIntoDocument() {
        val css = listOf(
            StyleProperty("width", "100px"),
            StyleProperty("height", "200px"),
            SelectorStyles("&:hover", listOf(StyleProperty("background", "gray"))),
            SelectorStyles("& > p.foo", listOf(StyleProperty("fontSize", "12px")))
        )

        val root = ReactTestRenderer.aktCreate {
            Div(css = css)
        }

        val json = root.toJSON().asDynamic()
        val className = json.props.className as String

        val styleEl = document.head
            ?.childNodes?.asList()
            ?.filterIsInstance<HTMLStyleElement>()
            ?.find { it.innerHTML.contains(className) }

        assertEquals(
            ".$className {width:100px;height:200px;} .$className:hover {background:gray;} .$className > p.foo {fontSize:12px;}",
            styleEl?.innerHTML
        )
    }
}