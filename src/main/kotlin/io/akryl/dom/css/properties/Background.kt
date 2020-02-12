@file:Suppress("EnumEntryName", "unused", "ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

object background : PropertyBuilder("background") {
  fun none() = this("none")
  fun initial() = this("initial")
  fun inherit() = this("inherit")
}

object image : PropertyBuilder("image") {
  fun none() = this("none")
  fun initial() = this("initial")
  fun inherit() = this("inherit")

  fun url(value: String) = this("url('$value')")
}

object backgroundSize : PropertyBuilder("backgroundSize") {
  fun auto() = this("auto")
  fun cover() = this("cover")
  fun contain() = this("contain")
  fun initial() = this("initial")
  fun inherit() = this("inherit")

  operator fun invoke(value: Linear) = this("$value")
  operator fun invoke(width: Linear, height: Linear) = this("$width $height")
}

object backgroundRepeat : PropertyBuilder("backgroundRepeat") {
  fun repeat() = this("repeat")
  fun repeatX() = this("repeat-x")
  fun repeatY() = this("repeat-y")
  fun noRepeat() = this("no-repeat")
  fun initial() = this("initial")
  fun inherit() = this("inherit")
}

object backgroundImage : PropertyBuilder("backgroundImage") {
  fun none() = this("none")
  fun initial() = this("initial")
  fun inherit() = this("inherit")

  fun url(value: String) = this("url('$value')")
}
