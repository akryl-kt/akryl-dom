@file:Suppress("unused", "ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

object flex : PropertyBuilder("flex") {
    fun auto() = this("auto")
    fun none() = this("none")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(
        grow: Number,
        shrink: Number,
        basis: Linear
    ) = this("$grow $shrink $basis")
}
