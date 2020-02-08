package io.akryl.dom.css

import kotlin.js.Json

sealed class CssElement

data class StyleProperty(val key: String, val value: String?) : CssElement()

data class SelectorStyles(val selector: String, val elements: List<CssElement?>) : CssElement()

fun <T : CssElement> List<T?>.toStyleJson(): Json? {
    val props = if (this.isNotEmpty()) js("{}") else undefined

    for ((k, v) in this.filterIsInstance<StyleProperty>()) {
        if (v != null) props[k] = v
    }

    return props.unsafeCast<Json>()
}
