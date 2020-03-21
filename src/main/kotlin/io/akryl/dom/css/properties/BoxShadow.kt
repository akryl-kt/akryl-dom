@file:Suppress("unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.AbstractStyleProperty

data class BoxShadow(override val value: String?) : AbstractStyleProperty() {
    override val key: String = "boxShadow"

    fun none() = this("none")

    operator fun invoke(
        inset: Boolean,
        offsetX: Linear,
        offsetY: Linear,
        blurRadius: Linear,
        spreadRadius: Linear,
        color: Color
    ): BoxShadow {
        val value = "${if (inset) "inset " else ""}$offsetX $offsetY $blurRadius $spreadRadius $color"
        return BoxShadow(this.value?.let { "$it, $value" } ?: value)
    }

    operator fun invoke(
        offsetX: Linear,
        offsetY: Linear,
        blurRadius: Linear,
        spreadRadius: Linear,
        color: Color
    ): BoxShadow {
        val value = "$offsetX $offsetY $blurRadius $spreadRadius $color"
        return BoxShadow(this.value?.let { "$it, $value" } ?: value)
    }

    fun add(
        inset: Boolean,
        offsetX: Linear,
        offsetY: Linear,
        blurRadius: Linear,
        spreadRadius: Linear,
        color: Color
    ) = this(
        inset,
        offsetX,
        offsetY,
        blurRadius,
        spreadRadius,
        color
    )

    fun add(
        offsetX: Linear,
        offsetY: Linear,
        blurRadius: Linear,
        spreadRadius: Linear,
        color: Color
    ) = this(
        offsetX,
        offsetY,
        blurRadius,
        spreadRadius,
        color
    )

    operator fun invoke(value: String?) = BoxShadow(value)
}

val boxShadow get() = BoxShadow(null)
