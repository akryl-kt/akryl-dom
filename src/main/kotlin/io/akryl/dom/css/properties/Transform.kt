@file:Suppress("unused", "ClassName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.AbstractStyleProperty
import io.akryl.dom.css.PropertyBuilder
import io.akryl.dom.css.PropertyKey

data class TransformProperty(
    override val value: String?,
    override val important: Boolean = false
) : AbstractStyleProperty(), PropertyKey {
    override val key: String = "transform"

    fun none() = this("none")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun matrix(
        a: Number, b: Number,
        c: Number, d: Number,
        tx: Number, ty: Number
    ) = this("matrix", a, b, c, d, tx, ty)

    fun matrix3d(
        a1: Number, b1: Number, c1: Number, d1: Number,
        a2: Number, b2: Number, c2: Number, d2: Number,
        a3: Number, b3: Number, c3: Number, d3: Number,
        a4: Number, b4: Number, c4: Number, d4: Number
    ) = this("matrix3d", a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3, a4, b4, c4, d4)

    fun translate(tx: Linear, ty: Linear = 0.px) = this("translate", tx, ty)
    fun translateX(t: Linear) = this("translateX", t)
    fun translateY(t: Linear) = this("translateY", t)

    fun translate3d(tx: Linear, ty: Linear, tz: Linear) = this("translate3d", tx, ty, tz)
    fun translateZ(t: Linear) = this("translateZ", t)

    fun scale(sx: Number, sy: Number) = this("scale", sx, sy)
    fun scale(s: Number) = this("scale", s)
    fun scaleX(s: Number) = this("scaleX", s)
    fun scaleY(s: Number) = this("scaleY", s)

    fun scale3d(sx: Number, sy: Number, sz: Number) = this("scale3d", sx, sy, sz)
    fun scaleZ(s: Number) = this("scaleZ", s)

    fun rotate(a: Angle) = this("rotate", a)

    fun rotate3d(x: Number, y: Number, z: Number, a: Angle) = this("rotate3d", x, y, z, a)
    fun rotateX(a: Angle) = this("rotateX", a)
    fun rotateY(a: Angle) = this("rotateY", a)
    fun rotateZ(a: Angle) = this("rotateZ", a)

    fun skew(ax: Angle, ay: Angle = 0.deg) = this("skew", ax, ay)
    fun skewX(a: Angle) = this("skewX", a)
    fun skewY(a: Angle) = this("skewY", a)

    fun perspective(l: Linear) = this("perspective", l)

    operator fun invoke(fn: String, vararg args: Any): TransformProperty {
        val value = "$fn(${args.joinToString(", ")})"
        return TransformProperty(this.value?.let { "$it $value" } ?: value)
    }
}

val transform get() = TransformProperty(null)

class Angle(val value: String) {
    companion object {
        private const val ZERO = "0"
    }

    private val valueCalcSafe: String
        get() = if (value == ZERO) "0px" else value

    operator fun unaryMinus() = Angle(when {
        value.startsWith('-') -> value.substring(1)
        value.startsWith("calc") -> "calc(0px - $value)"
        value == ZERO -> value
        else -> "-$value"
    })

    operator fun plus(other: Angle) = Angle("calc($valueCalcSafe + ${other.valueCalcSafe})")
    operator fun minus(other: Angle) = Angle("calc($valueCalcSafe - ${other.valueCalcSafe})")
    operator fun times(times: Number) = Angle("calc($valueCalcSafe * $times)")
    operator fun div(times: Number) = Angle("calc($valueCalcSafe / $times)")

    override fun toString() = value
}

val Number.deg get() = Angle("${this}deg")
val Number.grad get() = Angle("${this}grad")
val Number.rad get() = Angle("${this}rad")
val Number.turn get() = Angle("${this}turn")

val transformOrigin get() = transformOriginPropertyBuilder()

class transformOriginPropertyBuilder : PropertyBuilder("transformOrigin") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    operator fun invoke(value: Linear?) = this(value?.toString())
    operator fun invoke(value: Horizontal?) = this(value?.toString())
    operator fun invoke(value: Vertical?) = this(value?.toString())
    operator fun invoke(horizontal: Horizontal, vertical: Vertical) = this("$horizontal $vertical")
    operator fun invoke(horizontal: Linear, vertical: Vertical) = this("$horizontal $vertical")
    operator fun invoke(horizontal: Horizontal, vertical: Linear) = this("$horizontal $vertical")
    operator fun invoke(horizontal: Linear, vertical: Linear) = this("$horizontal $vertical")
    operator fun invoke(horizontal: Horizontal, vertical: Vertical, depth: Linear) = this("$horizontal $vertical $depth")
    operator fun invoke(horizontal: Linear, vertical: Vertical, depth: Linear) = this("$horizontal $vertical $depth")
    operator fun invoke(horizontal: Horizontal, vertical: Linear, depth: Linear) = this("$horizontal $vertical $depth")
    operator fun invoke(horizontal: Linear, vertical: Linear, depth: Linear) = this("$horizontal $vertical $depth")
}
