package io.akryl.dom.css

import kotlin.browser.document
import kotlin.random.Random

class DomCssRegistry {
    private val prefix = "css-"

    private val items = HashMap<List<CssElement?>, String>()

    fun generateClassName(prefix: String): String {
        val random = (Random.nextLong() and 0xFFFFFFFFL)
            .toString(16)
            .padStart(8, '0')
        return prefix + random
    }

    fun findOrCreateClassName(css: List<CssElement?>?): String? {
        if (css == null) return null

        var className = items[css]
        if (className == null) {
            className = generateClassName(prefix)
            injectCss(".$className", css)
            items[css] = className
        }

        return className
    }

    fun injectCss(selector: String, css: List<CssElement?>) {
        val str = buildString {
            appendCss(selector, css)
        }
        val el = document.createElement("style")
        el.innerHTML = str
        document.head?.appendChild(el)
    }

    private fun StringBuilder.appendCss(selector: String, css: List<CssElement?>) {
        append(selector)
        append(" {")
        for (prop in css.filterIsInstance<AbstractStyleProperty>()) {
            appendCssKey(prop.key)
            append(':')
            append(prop.value)
            append(';')
        }
        append('}')

        for (inner in css.filterIsInstance<SelectorStyles>()) {
            val innerSelector = inner.selector.replace("&", selector)
            append(' ')
            appendCss(innerSelector, inner.elements)
        }
    }

    private fun StringBuilder.appendCssKey(key: String) {
        for (c in key) {
            val lower = c.toLowerCase()
            if (lower != c) {
                append('-')
                append(lower)
            } else {
                append(c)
            }
        }
    }
}

val cssRegistry = DomCssRegistry()
