package io.akryl.dom

import io.akryl.dom.css.*
import io.akryl.dom.css.properties.*
import io.akryl.dom.html.div
import io.akryl.dom.html.span
import org.w3c.dom.HTMLStyleElement
import org.w3c.dom.asList
import react_test_renderer.ReactTestRenderer
import react_test_renderer.aktCreate
import utils.assertJsonEquals
import kotlin.browser.document
import kotlin.js.json
import kotlin.test.*

val testClass by css(
    width(100.px),
    transform.translate(10.px, 20.px)
)

class CssTest {
    @Test
    fun testStyledDiv() {
        val root = ReactTestRenderer.aktCreate {
            div(
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
            div(
                div(css = css1),
                span(css = css2),
                span(css = css3)
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
    fun testConcatCssAndClassName() {
        val testClass by css(
            height(100.px)
        )

        val css = listOf(
            width(100.px)
        )

        val root = ReactTestRenderer.aktCreate {
            div(css = css, className = testClass)
        }

        val json = root.toJSON().asDynamic()
        val cssClassName = cssRegistry.findOrCreateClassName(css)
        val actualClassName = json.props.className
        val expectedClassName = "$testClass $cssClassName"

        assertEquals(expectedClassName, actualClassName)
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
            div(css = css)
        }

        val json = root.toJSON().asDynamic()
        val className = json.props.className as String

        assertEquals(
            ".$className {width:100px;height:200px;} .$className:hover {background:gray;} .$className > p.foo {font-size:12px;}",
            extractStyle(className)
        )
    }

    @Test
    fun testObjectDsl() {
        assertEquals("flex", flex.key)

        var style = flex(1, 1, 100.pct)
        assertEquals("1 1 100%", style.value)

        style = flex(0, 0, Linear.auto)
        assertEquals("0 0 auto", style.value)

        style = flex.auto()
        assertEquals("auto", style.value)
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
            div(
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

        assertEquals(
            ".$className {transform:translateY(10px) skew(45deg, 30deg);box-shadow:10px 20px 30px 40px black;transition:transform 10s ease 0s;}",
            extractStyle(className)
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

    @Test
    fun testClassList() {
        assertEquals(
            "foo bar ${testClass.name}",
            classList("foo", "bar", testClass)
        )
    }

    @Test
    fun testCssClass() {
        assertEquals(testClass.toString(), testClass.name)
        assertTrue(testClass.name.startsWith("testClass"))
        assertEquals(".${testClass.name}", testClass.selector)

        assertEquals(
            "${testClass.selector} {width:100px;transform:translate(10px, 20px);}",
            extractStyle(testClass.name)
        )
    }

    @Test
    fun testSelectors() {
        var selector = hover()
        assertEquals("&:hover", selector.selector)

        selector = not(hover)()
        assertEquals("&:not(:hover)", selector.selector)

        val foo = CssClass("foo")
        val bar = CssClass("bar")
        selector = (foo + bar)()
        assertEquals("& .foo.bar", selector.selector)

        selector = not(foo + bar)()
        assertEquals("& :not(.foo.bar)", selector.selector)

        selector = tag("div")[foo]()
        assertEquals("& div.foo", selector.selector)

        selector = div[foo]()
        assertEquals("& div.foo", selector.selector)
    }

    @Test
    fun testCssMap() {
        val first = listOf(
            width(100.px),
            transform.translateY(10.px)
        )

        val second = listOf(
            width(50.px),
            height(50.px)
        )

        val third = listOf(
            color.red()
        )

        var css = cssMap(
            first to true,
            second to false,
            third to true
        )
        assertEquals(
            listOf(
                width(100.px),
                transform.translateY(10.px),
                color.red()
            ),
            css
        )

        css = cssMap(
            first to true,
            second to true,
            third to false
        )
        assertEquals(
            listOf(
                width(100.px),
                transform.translateY(10.px),
                width(50.px),
                height(50.px)
            ),
            css
        )

        css = cssMap(
            first to true
        )
        assertEquals(first, css)
    }

    @Test
    fun testCssList() {
        val first = listOf(
            width(100.px),
            transform.translateY(10.px)
        )

        val second = listOf(
            color.red()
        )

        val css = cssList(first, second)
        assertEquals(
            listOf(
                width(100.px),
                transform.translateY(10.px),
                color.red()
            ),
            css
        )
    }

    @Test
    fun testImportant() {
        val actual = boxShadow(10.px, 20.px, 30.px, 40.px, Color.red).important()
        val expected = StyleProperty("boxShadow", "10px 20px 30px 40px red", true)
        val expectedStr = "10px 20px 30px 40px red !important"

        assertEquals(expected, actual)
        assertEquals(actual.toStringOrNull(), expectedStr)
    }

    private fun extractStyle(className: String): String? {
        return document.head
            ?.childNodes?.asList()
            ?.filterIsInstance<HTMLStyleElement>()
            ?.find { it.innerHTML.contains(className) }
            ?.innerHTML
    }
}