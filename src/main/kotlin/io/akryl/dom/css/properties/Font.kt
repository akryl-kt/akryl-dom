@file:Suppress("unused", "ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder
import io.akryl.dom.css.StyleProperty

object font : PropertyBuilder("font") {
    operator fun invoke(size: Linear, vararg family: String): StyleProperty {
        val familyStr = family.joinToString { "'$it'" }
        return this("$size $familyStr")
    }
}

object fontFamily : PropertyBuilder("fontFamily") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun serif() = this("serif")
    fun sansSerif() = this("sans-serif")
    fun monospace() = this("monospace")
}