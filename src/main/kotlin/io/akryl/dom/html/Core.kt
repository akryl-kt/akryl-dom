package io.akryl.dom.html

import org.w3c.dom.events.Event
import react.MutableRefObject
import react.React.createElement
import react.ReactElement
import kotlin.js.json

fun html(
    tag: String,
    attributes: Map<String, Any?> = emptyMap(),
    style: Map<String, String?> = emptyMap(),
    listeners: Map<String, (event: Event) -> Unit> = emptyMap(),
    children: Iterable<ReactElement<*>?>? = null,
    innerHtml: String? = null,
    key: Any? = null,
    ref: MutableRefObject<*>? = null
): ReactElement<*> {
    val styleProps = if (style.isNotEmpty()) js("{}") else undefined

    for ((k, v) in style) {
        if (v != null) styleProps[k] = v
    }

    val props = js("{}")
    props["style"] = styleProps

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

    return createElement(tag, props, *(children?.toList()?.toTypedArray() ?: emptyArray()))
}

@Suppress("FunctionName")
fun Text(value: String) = value.unsafeCast<ReactElement<*>>()
