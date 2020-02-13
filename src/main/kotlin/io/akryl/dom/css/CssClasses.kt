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

fun css(vararg items: CssElement) = CssClassProvider(items.asList())
