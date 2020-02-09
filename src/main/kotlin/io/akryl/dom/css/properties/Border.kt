@file:Suppress("EnumEntryName", "unused", "ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class BorderPropertyBuilder(name: String) : PropertyBuilder(name) {
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

class BorderStylePropertyBuilder(name: String) : PropertyBuilder(name) {
  fun none() = this("none")
  fun initial() = this("initial")
  fun inherit() = this("inherit")

  fun hidden() = this("hidden")
  fun dotted() = this("dotted")
  fun dashed() = this("dashed")
  fun solid() = this("solid")
  fun double() = this("double")
  fun groove() = this("groove")
  fun ridge() = this("ridge")
  fun inset() = this("inset")
  fun outset() = this("outset")
}

val border = BorderPropertyBuilder("border")
val borderBottom = BorderPropertyBuilder("borderBottom")
val borderBottomStyle = BorderStylePropertyBuilder("borderBottomStyle")
val borderLeft = BorderPropertyBuilder("borderLeft")
val borderLeftStyle = BorderStylePropertyBuilder("borderLeftStyle")
val borderRight = BorderPropertyBuilder("borderRight")
val borderRightStyle = BorderStylePropertyBuilder("borderRightStyle")
val borderStyle = BorderStylePropertyBuilder("borderStyle")
val borderTop = BorderPropertyBuilder("borderTop")
val borderTopStyle = BorderStylePropertyBuilder("borderTopStyle")
