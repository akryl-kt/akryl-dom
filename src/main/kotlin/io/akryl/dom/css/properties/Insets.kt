@file:Suppress("unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class InsetsPropertyBuilder(name: String) : PropertyBuilder(name) {
    fun none() = this("0")
    fun auto() = this("auto")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(all: Linear) = this(all.toString())
    operator fun invoke(vertical: Linear, horizontal: Linear) = this("$vertical $horizontal")
    operator fun invoke(top: Linear, right: Linear, bottom: Linear, left: Linear) = this("$top $right $bottom $left")
}

val margin = InsetsPropertyBuilder("margin")
val padding = InsetsPropertyBuilder("padding")
