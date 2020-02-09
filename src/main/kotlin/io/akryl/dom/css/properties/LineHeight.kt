@file:Suppress("ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

object lineHeight : PropertyBuilder("lineHeight") {
    fun normal() = this("normal")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(value: Linear) = this(value.toString())
    operator fun invoke(value: Number) = this(value.toString())
}
