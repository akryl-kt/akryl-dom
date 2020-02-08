package io.akryl.dom.css

import kotlin.browser.document
import kotlin.random.Random

class DomCssRegistry {
    private val prefix = "css-"

    private val items = HashMap<List<CssElement?>, String>()

    private fun generateClassName(): String {
        val random = (Random.nextLong() and 0xFFFFFFFFL)
            .toString(16)
            .padStart(8, '0')
        return prefix + random
    }

    fun findOrCreateClassName(css: List<CssElement?>?): String? {
        if (css == null) return null

        var className = items[css]
        if (className == null) {
            className = generateClassName()
            injectCss(".$className", css)
            items[css] = className
        }

        return className
    }

    private fun injectCss(selector: String, css: List<CssElement?>) {
        val str = buildString {
            buildCss(selector, css)
        }
        val el = document.createElement("style")
        el.innerHTML = str
        document.head?.appendChild(el)
    }

    private fun StringBuilder.buildCss(selector: String, css: List<CssElement?>) {
        append(selector)
        append(" {")
        for ((k, v) in css.filterIsInstance<StyleProperty>()) {
            append(k)
            append(':')
            append(v)
            append(';')
        }
        append('}')

        for (inner in css.filterIsInstance<SelectorStyles>()) {
            val innerSelector = inner.selector.replace("&", selector)
            append(' ')
            buildCss(innerSelector, inner.elements)
        }
    }
}

val cssRegistry = DomCssRegistry()
