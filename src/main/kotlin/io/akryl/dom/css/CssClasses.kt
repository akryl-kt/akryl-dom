package io.akryl.dom.css

import kotlin.reflect.KProperty

class CssClassProperty(private val clazz: CssClass) {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>) = clazz
}

class CssClassProvider(private val items: List<CssElement>) {
    operator fun provideDelegate(
        thisRef: Any?,
        prop: KProperty<*>
    ): CssClassProperty {
        val name = cssRegistry.generateClassName("${prop.name}-")
        val clazz = CssClass(name)
        cssRegistry.injectCss(clazz.selector, items)
        return CssClassProperty(clazz)
    }
}

/**
 * Creates a CSS class based on [items] and inserts it into the document head.
 * You must assign the result of the [css] using delegated property.
 * The class name will be based on the assigned variable name and a random postfix.
 *
 * Example:
 * ```
 * val header by css(
 *     fontSize(24.px),
 *     lineHeight(30.px)
 * )
 * // header.name == "header-af76c91d"
 * ```
 *
 * Use the class to specify `className` of an HTML element or in a CSS selector.
 */
fun css(vararg items: CssElement) = CssClassProvider(items.asList())
