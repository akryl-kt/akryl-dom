@file:Suppress("unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class IntPropertyBuilder(name: String) : PropertyBuilder(name) {
    fun auto() = this("auto")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(value: Int) = this(value.toString())
}

class NumberPropertyBuilder(name: String) : PropertyBuilder(name) {
    fun auto() = this("auto")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(value: Number) = this(value.toString())
}

val flexGrow get() = NumberPropertyBuilder("flexGrow")
val flexShrink get() = NumberPropertyBuilder("flexShrink")
val opacity get() = NumberPropertyBuilder("opacity")
val strokeWidth get() = NumberPropertyBuilder("strokeWidth")

val zIndex get() = IntPropertyBuilder("zIndex")
