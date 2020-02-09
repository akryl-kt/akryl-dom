package io.akryl.dom.html

import io.akryl.dom.css.AbstractStyleProperty
import io.akryl.dom.css.CssElement
import io.akryl.dom.css.cssRegistry
import io.akryl.dom.css.toStyleJson
import org.w3c.dom.events.Event
import react.MutableRefObject
import react.React.createElement
import react.ReactElement
import kotlin.js.json

fun html(
    tag: String,
    attributes: Map<String, Any?> = emptyMap(),
    style: List<AbstractStyleProperty?>? = null,
    css: List<CssElement?>? = null,
    listeners: Map<String, (event: Event) -> Unit> = emptyMap(),
    children: Iterable<ReactElement<*>?>? = null,
    innerHtml: String? = null,
    key: Any? = null,
    ref: MutableRefObject<*>? = null
): ReactElement<*> {
    val props = js("{}")
    props["style"] = style?.toStyleJson() ?: undefined

    for ((k, v) in attributes) {
        if (v != null) props[k] = v
    }

    for ((k, v) in listeners) {
        props[k] = v
    }

    if (innerHtml != null) {
        props["dangerouslySetInnerHTML"] = json("__html" to innerHtml)
    }

    if (key != null) {
        props["key"] = key
    }

    if (ref != null) {
        props["ref"] = ref
    }

    val cssClassName = cssRegistry.findOrCreateClassName(css)
    props["className"] = listOfNotNull(attributes["className"], cssClassName)
        .takeIf { it.isNotEmpty() }
        ?.joinToString(" ")
        ?: undefined

    return createElement(tag, props, *(children?.toList()?.toTypedArray() ?: emptyArray()))
}

@Suppress("FunctionName")
fun Text(value: String) = value.unsafeCast<ReactElement<*>>()
