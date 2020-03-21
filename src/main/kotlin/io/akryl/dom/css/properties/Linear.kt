@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class Linear(val value: String) {
    companion object {
        private const val ZERO = "0"

        val none = Linear("none")
        val auto = Linear("auto")
        val initial = Linear("initial")
        val inherit = Linear("inherit")
    }

    constructor(value: Number, unit: String) : this("$value$unit")

    private val valueCalcSafe: String
        get() = if (value == ZERO) "0px" else value

    operator fun unaryMinus() = Linear(when {
        value.startsWith('-') -> value.substring(1)
        value.startsWith("calc") -> "calc(0px - $value)"
        value == ZERO -> value
        else -> "-$value"
    })

    operator fun plus(other: Linear) = Linear("calc($valueCalcSafe + ${other.valueCalcSafe})")
    operator fun minus(other: Linear) = Linear("calc($valueCalcSafe - ${other.valueCalcSafe})")
    operator fun times(times: Number) = Linear("calc($valueCalcSafe * $times)")
    operator fun div(times: Number) = Linear("calc($valueCalcSafe / $times)")

    override fun toString() = value
}

class DimensionPropertyBuilder(name: String) : PropertyBuilder(name) {
    fun none() = this("none")
    fun auto() = this("auto")
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun available() = this("available") // old name
    fun fillAvailable() = this("fill-available") // new name
    fun borderBox() = this("border-box")
    fun contentBox() = this("content-box")
    fun maxContent() = this("max-content")
    fun minContent() = this("min-content")
    fun fitContent() = this("fit-content")

    operator fun invoke(value: Linear) = this(value.toString())
}

class LinearPropertyBuilder(name: String) : PropertyBuilder(name) {
    fun none() = this("none")
    fun auto() = this("auto")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    operator fun invoke(value: Linear) = this(value.toString())
}

val Number.cm: Linear get() = Linear(this, "cm")       // Centimeter
val Number.em: Linear get() = Linear(this, "em")
val Number.ex: Linear get() = Linear(this, "ex")
val Number.fr: Linear get() = Linear(this, "fr")       // Fraction
val Number.mm: Linear get() = Linear(this, "mm")       // Millimeter
val Number.pc: Linear get() = Linear(this, "pc")       // Pica
val Number.pct: Linear get() = Linear(this, "%")
val Number.pt: Linear get() = Linear(this, "pt")       // Point
val Number.px: Linear get() = Linear(this, "px")       // Pixel
val Number.rem: Linear get() = Linear(this, "rem")     // Root em
val Number.vmin: Linear get() = Linear(this, "vmin")   // 1/100th of the smallest side
val Number.vmax: Linear get() = Linear(this, "vmax")   // 1/100th of the largest side
val Number.vh: Linear get() = Linear(this, "vh")       // 1/100th of the viewport height
val Number.vw: Linear get() = Linear(this, "vw")       // 1/100th of the viewport width
val Number.inch: Linear get() = Linear(this, "in")     // Inch

val borderBottomLeftRadius get() = LinearPropertyBuilder("borderBottomLeftRadius")
val borderBottomRightRadius get() = LinearPropertyBuilder("borderBottomRightRadius")
val borderBottomWidth get() = LinearPropertyBuilder("borderBottomWidth")
val borderLeftWidth get() = LinearPropertyBuilder("borderLeftWidth")
val borderRadius get() = LinearPropertyBuilder("borderRadius")
val borderRightWidth get() = LinearPropertyBuilder("borderRightWidth")
val borderTopLeftRadius get() = LinearPropertyBuilder("borderTopLeftRadius")
val borderTopRightRadius get() = LinearPropertyBuilder("borderTopRightRadius")
val borderTopWidth get() = LinearPropertyBuilder("borderTopWidth")
val borderWidth get() = LinearPropertyBuilder("borderWidth")
val bottom get() = LinearPropertyBuilder("bottom")
val flexBasis get() = LinearPropertyBuilder("flexBasis")
val fontSize get() = LinearPropertyBuilder("fontSize")
val left get() = LinearPropertyBuilder("left")
val marginBottom get() = LinearPropertyBuilder("marginBottom")
val marginLeft get() = LinearPropertyBuilder("marginLeft")
val marginRight get() = LinearPropertyBuilder("marginRight")
val marginTop get() = LinearPropertyBuilder("marginTop")
val maxHeight get() = LinearPropertyBuilder("maxHeight")
val maxWidth get() = LinearPropertyBuilder("maxWidth")
val minHeight get() = LinearPropertyBuilder("minHeight")
val minWidth get() = LinearPropertyBuilder("minWidth")
val outlineWidth get() = LinearPropertyBuilder("outlineWidth")
val paddingBottom get() = LinearPropertyBuilder("paddingBottom")
val paddingLeft get() = LinearPropertyBuilder("paddingLeft")
val paddingRight get() = LinearPropertyBuilder("paddingRight")
val paddingTop get() = LinearPropertyBuilder("paddingTop")
val right get() = LinearPropertyBuilder("right")
val top get() = LinearPropertyBuilder("top")

val height get() = DimensionPropertyBuilder("height")
val width get() = DimensionPropertyBuilder("width")
