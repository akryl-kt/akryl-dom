package io.akryl.dom

import io.akryl.dom.css.SelectorStyles
import io.akryl.dom.css.StyleProperty
import io.akryl.dom.css.classMap
import io.akryl.dom.css.cssRegistry
import io.akryl.dom.css.properties.*
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
import kotlin.test.assertNull

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
            width(100.px),
            height(100.px)
        )
        val css2 = listOf(
            color.red(),
            fontSize(32.px)
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
            width(100.px),
            height(200.px),
            SelectorStyles("&:hover", listOf(background("gray"))),
            SelectorStyles("& > p.foo", listOf(fontSize(12.px)))
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
            ".$className {width:100px;height:200px;} .$className:hover {background:gray;} .$className > p.foo {font-size:12px;}",
            styleEl?.innerHTML
        )
    }

    @Test
    fun testTransformDsl() {
        assertEquals("transform", transform.key)
        assertNull(transform.value)

        val simple = transform.translate(100.px, 200.px)
        assertEquals("transform", simple.key)
        assertEquals("translate(100px, 200px)", simple.value)

        val complex = transform
            .translate(200.px, 300.px)
            .rotate(10.deg)
            .scale(4)
        assertEquals("transform", complex.key)
        assertEquals("translate(200px, 300px) rotate(10deg) scale(4)", complex.value)
    }

    @Test
    fun testTransitionDsl() {
        val simple = transition(transform, 500.ms)
        assertEquals("transition", simple.key)
        assertEquals("transform 500ms ease 0s", simple.value)

        val complex = transition
            .add(transform, 500.ms, Timing.linear, 100.ms)
            .add(color, 1.s, Timing.easeIn, 200.ms)
        assertEquals("transition", complex.key)
        assertEquals("transform 500ms linear 100ms, color 1s ease-in 200ms", complex.value)
    }

    @Test
    fun testCssTyping() {
        val root = ReactTestRenderer.aktCreate {
            Div(
                css = listOf(
                    transform.translateY(10.px).skew(45.deg, 30.deg),
                    boxShadow.add(10.px, 20.px, 30.px, 40.px, Color.black),
                    transition.add(transform, 10.s)
                ),
                style = listOf(
                    transform.translateY(10.px).skew(45.deg, 30.deg),
                    boxShadow.add(10.px, 20.px, 30.px, 40.px, Color.black),
                    transition.add(transform, 10.s)
                )
            )
        }

        val json = root.toJSON().asDynamic()

        val style = json.props.style
        assertJsonEquals(
            json(
                "transform" to "translateY(10px) skew(45deg, 30deg)",
                "boxShadow" to "10px 20px 30px 40px black",
                "transition" to "transform 10s ease 0s"
            ),
            style
        )

        val className = json.props.className as String
        val styleEl = document.head
            ?.childNodes?.asList()
            ?.filterIsInstance<HTMLStyleElement>()
            ?.find { it.innerHTML.contains(className) }
        assertEquals(
            ".$className {transform:translateY(10px) skew(45deg, 30deg);box-shadow:10px 20px 30px 40px black;transition:transform 10s ease 0s;}",
            styleEl?.innerHTML
        )
    }

    @Test
    fun testClassMap() {
        val firstClass = classMap(
            "foo" to true,
            "bar" to true
        )
        assertEquals("foo bar", firstClass)

        val secondClass = classMap(
            "foo" to true,
            "bar" to false,
            "baz" to true
        )
        assertEquals("foo baz", secondClass)

        val thirdClass = classMap(
            "foo" to false,
            "bar" to false,
            "baz" to false
        )
        assertEquals("", thirdClass)
    }
}