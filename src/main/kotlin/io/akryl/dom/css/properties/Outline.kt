@file:Suppress("ClassName", "unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

object outline : PropertyBuilder("outline") {
    fun none() = this("none")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun hidden(width: Linear, color: Color) = this(width, "hidden", color)
    fun dotted(width: Linear, color: Color) = this(width, "dotted", color)
    fun dashed(width: Linear, color: Color) = this(width, "dashed", color)
    fun solid(width: Linear, color: Color) = this(width, "solid", color)
    fun double(width: Linear, color: Color) = this(width, "double", color)
    fun groove(width: Linear, color: Color) = this(width, "groove", color)
    fun ridge(width: Linear, color: Color) = this(width, "ridge", color)
    fun inset(width: Linear, color: Color) = this(width, "inset", color)
    fun outset(width: Linear, color: Color) = this(width, "outset", color)

    operator fun invoke(width: Linear, style: String, color: Color) = this("$width $style $color")
}