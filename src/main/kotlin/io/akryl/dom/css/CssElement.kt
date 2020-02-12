package io.akryl.dom.css

import kotlin.js.Json

sealed class CssElement

abstract class AbstractStyleProperty : CssElement() {
    abstract val key: String
    abstract val value: String?
}

data class StyleProperty(override val key: String, override val value: String?) : AbstractStyleProperty()

data class SelectorStyles(val selector: String, val elements: List<CssElement?>) : CssElement()

interface PropertyKey {
    val key: String
}

abstract class PropertyBuilder(override val key: String) : PropertyKey {
    open operator fun invoke(value: String?) = StyleProperty(key, value)
}

fun <T : CssElement> List<T?>.toStyleJson(): Json? {
    val props = if (this.isNotEmpty()) js("{}") else undefined

    for (prop in this.filterIsInstance<AbstractStyleProperty>()) {
        prop.value?.let { v -> props[prop.key] = v }
    }

    return props.unsafeCast<Json>()
}
