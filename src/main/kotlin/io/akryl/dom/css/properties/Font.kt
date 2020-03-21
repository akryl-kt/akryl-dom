@file:Suppress("unused", "ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder
import io.akryl.dom.css.StyleProperty

val font get() = fontPropertyBuilder()

class fontPropertyBuilder : PropertyBuilder("font") {
    operator fun invoke(size: Linear, vararg family: String): StyleProperty {
        val familyStr = family.joinToString { "'$it'" }
        return this("$size $familyStr")
    }
}

val fontFamily get() = fontFamilyPropertyBuilder()

class fontFamilyPropertyBuilder : PropertyBuilder("fontFamily") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun serif() = this("serif")
    fun sansSerif() = this("sans-serif")
    fun monospace() = this("monospace")
}