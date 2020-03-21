@file:Suppress("unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class PositionAlignPropertyBuilder(name: String) : PropertyBuilder(name) {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(horizontal: Horizontal, vertical: Vertical) = this("$horizontal $vertical")
    operator fun invoke(horizontal: Linear, vertical: Linear) = this("$horizontal $vertical")
}

val backgroundPosition get() = PositionAlignPropertyBuilder("backgroundPosition")
val objectPosition get() = PositionAlignPropertyBuilder("objectPosition")
