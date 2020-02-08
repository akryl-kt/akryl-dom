package io.akryl.dom

import io.akryl.component
import io.akryl.dom.html.Div
import io.akryl.dom.html.Img
import io.akryl.dom.html.Span
import io.akryl.dom.html.Text
import react_test_renderer.ReactTestRenderer
import react_test_renderer.aktCreate
import utils.assertJsonEquals
import kotlin.js.json
import kotlin.test.Test

private fun componentWithHtml() = component {
    Div(className = "root", children = listOf(
        Div(className = "item", children = listOf(
            Img(src = "first.svg", className = "item-image"),
            Span(children = listOf(Text("First Item")))
        )),
        Div(className = "item", children = listOf(
            Img(src = "second.svg", className = "item-image"),
            Span(children = listOf(Text("Second Item")))
        ))
    ))
}

class HtmlTest {
    @Test
    fun testDivWithChildren() {
        val root = ReactTestRenderer.aktCreate {
            Div(
                Text("Hello, World!"),
                Text("Second child")
            )
        }

        assertJsonEquals(
            json(
                "type" to "div",
                "props" to json(),
                "children" to arrayOf(
                    "Hello, World!",
                    "Second child"
                )
            ),
            root.toJSON()
        )
    }

    @Test
    fun testEmptyDiv() {
        val root = ReactTestRenderer.aktCreate {
            Div()
        }

        assertJsonEquals(
            json(
                "type" to "div",
                "props" to json(),
                "children" to null
            ),
            root.toJSON()
        )
    }

    @Test
    fun testText() {
        val root = ReactTestRenderer.aktCreate {
            Text("text node")
        }

        assertJsonEquals(
            "text node",
            root.toJSON()
        )
    }

    @Test
    fun testDivWithProps() {
        val root = ReactTestRenderer.aktCreate {
            Div(id = "foo", title = "bar", className = "baz")
        }

        assertJsonEquals(
            json(
                "type" to "div",
                "props" to json(
                    "id" to "foo",
                    "title" to "bar",
                    "className" to "baz"
                ),
                "children" to null
            ),
            root.toJSON()
        )
    }

    @Test
    fun testComponentWithHtml() {
        val root = ReactTestRenderer.aktCreate {
            componentWithHtml()
        }

        assertJsonEquals(
            json(
                "type" to "div",
                "props" to json("className" to "root"),
                "children" to arrayOf(
                    json(
                        "type" to "div",
                        "props" to json("className" to "item"),
                        "children" to arrayOf(
                            json(
                                "type" to "img",
                                "props" to json("src" to "first.svg", "className" to "item-image"),
                                "children" to null
                            ),
                            json(
                                "type" to "span",
                                "props" to json(),
                                "children" to arrayOf("First Item")
                            )
                        )
                    ),
                    json(
                        "type" to "div",
                        "props" to json("className" to "item"),
                        "children" to arrayOf(
                            json(
                                "type" to "img",
                                "props" to json("src" to "second.svg", "className" to "item-image"),
                                "children" to null
                            ),
                            json(
                                "type" to "span",
                                "props" to json(),
                                "children" to arrayOf("Second Item")
                            )
                        )
                    )
                )
            ),
            root.toJSON()
        )
    }
}