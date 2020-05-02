package io.akryl.dom.html

import io.akryl.dom.css.*
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

    props["className"] = concatStyle(css, attributes["className"]?.unsafeCast<CharSequence>())

    return createElement(tag, props, *(children?.toList()?.toTypedArray() ?: emptyArray()))
}

@Suppress("FunctionName")
fun text(value: String) = value.unsafeCast<ReactElement<*>>()

@Suppress("NOTHING_TO_INLINE")
inline fun concatChildren(children: Iterable<ReactElement<*>?>?, child: ReactElement<*>?, text: String?): List<ReactElement<*>>? {
    if (text == null && child == null && children == null) return null

    val result = ArrayList<ReactElement<*>>()
    if (text != null) result.add(text(text))
    if (child != null) result.add(child)
    children?.filterNotNullTo(result)
    return result
}

@Suppress("NOTHING_TO_INLINE")
inline fun concatStyle(css: CssStyle?, className: CharSequence?): String? {
    val cssClassName = cssRegistry.findOrCreateClassName(css)
    return listOfNotNull(className?.toString(), cssClassName)
        .takeIf { it.isNotEmpty() }
        ?.joinToString(" ")
        ?: undefined
}
