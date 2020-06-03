package io.akryl.dom.css

import kotlin.js.Json

sealed class CssElement

typealias CssStyle = List<CssElement?>

abstract class AbstractStyleProperty : CssElement() {
    abstract val key: String
    abstract val value: String?
    abstract val important: Boolean

    @JsName("_important")
    fun important() = StyleProperty(key, value, true)

    fun toStringOrNull(): String? {
        var value = this.value ?: return null
        if (important) value += " !important"
        return value
    }
}

data class StyleProperty(
    override val key: String,
    override val value: String?,
    override val important: Boolean = false
) : AbstractStyleProperty()

data class SelectorStyles(val selector: String, val elements: List<CssElement?>) : CssElement()

interface PropertyKey {
    val key: String
}

abstract class PropertyBuilder(override val key: String) : PropertyKey {
    open operator fun invoke(value: String?) = StyleProperty(key, value, false)
}

fun <T : CssElement> List<T?>.toStyleJson(): Json? {
    val props = if (this.isNotEmpty()) js("{}") else undefined

    for (prop in this.filterIsInstance<AbstractStyleProperty>()) {
        prop.toStringOrNull()?.let { v -> props[prop.key] = v }
    }

    return props.unsafeCast<Json>()
}
