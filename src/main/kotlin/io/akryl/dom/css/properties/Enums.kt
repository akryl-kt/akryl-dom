@file:Suppress("ClassName", "unused", "EnumEntryName")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

enum class Horizontal {
    left,
    center,
    right,
}

enum class Vertical {
    top,
    center,
    bottom
}

val textAlign get() = textAlignPropertyBuilder()

class textAlignPropertyBuilder : PropertyBuilder("textAlign") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    fun left() = this("left")
    fun right() = this("right")
    fun center() = this("center")
    fun justify() = this("justify")
    fun justifyAll() = this("justify-all")
    fun start() = this("start")
    fun end() = this("end")
    fun matchParent() = this("match-parent")
}

val boxSizing get() = boxSizingPropertyBuilder()

class boxSizingPropertyBuilder : PropertyBuilder("boxSizing") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    fun contentBox() = this("content-box")
    fun borderBox() = this("border-box")
}

val fontStyle get() = fontStylePropertyBuilder()

class fontStylePropertyBuilder : PropertyBuilder("fontStyle") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun normal() = this("normal")
    fun italic() = this("italic")
    fun oblique() = this("oblique")
}

val listStyleType get() = listStyleTypePropertyBuilder()

class listStyleTypePropertyBuilder : PropertyBuilder("listStyleType") {
    fun none() = this("none")
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun disc() = this("disc")
    fun armenian() = this("armenian")
    fun circle() = this("circle")
    fun cjkIdeographic() = this("cjk-ideographic")
    fun decimal() = this("decimal")
    fun decimalLeadingZero() = this("decimal-leading-zero")
    fun georgian() = this("georgian")
    fun hebrew() = this("hebrew")
    fun hiragana() = this("hiragana")
    fun hiraganaIroha() = this("hiragana-iroha")
    fun katakana() = this("katakana")
    fun katakanaIroha() = this("katakana-iroha")
    fun lowerAlpha() = this("lower-alpha")
    fun lowerGreek() = this("lower-greek")
    fun lowerLatin() = this("lower-latin")
    fun lowerRoman() = this("lower-roman")
    fun square() = this("square")
    fun upperAlpha() = this("upper-alpha")
    fun upperGreek() = this("upper-greek")
    fun upperLatin() = this("upper-latin")
    fun upperRoman() = this("upper-roman")
}

val display get() = displayPropertyBuilder()

class displayPropertyBuilder : PropertyBuilder("display") {
    fun none() = this("none")
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun contents() = this("contents")

    fun block() = this("block")
    fun `inline`() = this("inline")
    fun runIn() = this("run-in")

    fun flow() = this("flow")
    fun flowRoot() = this("flow-root")
    fun table() = this("table")
    fun flex() = this("flex")
    fun grid() = this("grid")
    fun subgrid() = this("subgrid")

    fun listItem() = this("list-item")

    fun tableRowGroup() = this("table-row-group")
    fun tableHeaderGroup() = this("table-header-group")
    fun tableFooterGroup() = this("table-footer-group")
    fun tableRow() = this("table-row")
    fun tableCell() = this("table-cell")
    fun tableColumnGroup() = this("table-column-group")
    fun tableColumn() = this("table-column")
    fun tableCaption() = this("table-caption")

    fun inlineBlock() = this("inline-block")
    fun inlineListItem() = this("inline-list-item")
    fun inlineTable() = this("inline-table")
    fun inlineFlex() = this("inline-flex")
    fun inlineGrid() = this("inline-grid")
}

val wordBreak get() = wordBreakPropertyBuilder()

class wordBreakPropertyBuilder : PropertyBuilder("wordBreak") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun normal() = this("normal")
    fun breakAll() = this("break-all")
    fun keepAll() = this("keep-all")
    fun breakWord() = this("break-word")
}

val alignContent get() = alignContentPropertyBuilder()

class alignContentPropertyBuilder : PropertyBuilder("alignContent") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun stretch() = this("stretch")
    fun center() = this("center")
    fun flexStart() = this("flex-start")
    fun flexEnd() = this("flex-end")
    fun spaceBetween() = this("space-between")
    fun spaceAround() = this("space-around")
}

val alignItems get() = alignItemsPropertyBuilder()

class alignItemsPropertyBuilder : PropertyBuilder("alignItems") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun stretch() = this("stretch")
    fun center() = this("center")
    fun flexStart() = this("flex-start")
    fun flexEnd() = this("flex-end")
    fun baseline() = this("baseline")
}

val alignSelf get() = alignSelfPropertyBuilder()

class alignSelfPropertyBuilder : PropertyBuilder("alignSelf") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun auto() = this("auto")
    fun stretch() = this("stretch")
    fun center() = this("center")
    fun flexStart() = this("flex-start")
    fun flexEnd() = this("flex-end")
    fun baseline() = this("baseline")
}

val extend get() = extendPropertyBuilder()

class extendPropertyBuilder : PropertyBuilder("extend") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun borderBox() = this("border-box")
    fun paddingBox() = this("padding-box")
    fun contentBox() = this("content-box")
}

val backgroundAttachment get() = backgroundAttachmentPropertyBuilder()

class backgroundAttachmentPropertyBuilder : PropertyBuilder("backgroundAttachment") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun scroll() = this("scroll")
    fun fixed() = this("fixed")
    fun local() = this("local")
}

val blendMode get() = blendModePropertyBuilder()

class blendModePropertyBuilder : PropertyBuilder("blendMode") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun normal() = this("normal")
    fun multiply() = this("multiply")
    fun screen() = this("screen")
    fun overlay() = this("overlay")
    fun darken() = this("darken")
    fun lighten() = this("lighten")
    fun colorDodge() = this("color-dodge")
    fun saturation() = this("saturation")
    fun color() = this("color")
    fun luminosity() = this("luminosity")
}

val position get() = positionPropertyBuilder()

class positionPropertyBuilder : PropertyBuilder("position") {
    fun static() = this("static")
    fun absolute() = this("absolute")
    fun fixed() = this("fixed")
    fun relative() = this("relative")
    fun sticky() = this("sticky")
    fun initial() = this("initial")
    fun inherit() = this("inherit")
}

val fontWeight get() = fontWeightPropertyBuilder()

class fontWeightPropertyBuilder : PropertyBuilder("fontWeight") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    fun normal() = this("normal")
    fun bold() = this("bold")
    fun bolder() = this("bolder")
    fun lighter() = this("lighter")
    fun w900() = this("900")
    fun w800() = this("800")
    fun w700() = this("700")
    fun w600() = this("600")
    fun w500() = this("500")
    fun w400() = this("400")
    fun w300() = this("300")
    fun w200() = this("200")
    fun w100() = this("100")
}

val flexDirection get() = flexDirectionPropertyBuilder()

class flexDirectionPropertyBuilder : PropertyBuilder("flexDirection") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun row() = this("row")
    fun rowReverse() = this("row-reverse")
    fun column() = this("column")
    fun columnReverse() = this("column-reverse")
}

val flexWrap get() = flexWrapPropertyBuilder()

class flexWrapPropertyBuilder : PropertyBuilder("flexWrap") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun nowrap() = this("nowrap")
    fun wrap() = this("wrap")
    fun wrapReverse() = this("wrap-reverse")
}

val textDecoration get() = textDecorationPropertyBuilder()

class textDecorationPropertyBuilder : PropertyBuilder("textDecoration") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun none() = this("none")

    fun underline() = this("underline")
    fun overline() = this("overline")
    fun lineThrough() = this("line-through")
}

val textDecorationStyle get() = textDecorationStylePropertyBuilder()

class textDecorationStylePropertyBuilder : PropertyBuilder("textDecorationStyle") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun none() = this("none")

    fun solid() = this("solid")
    fun double() = this("double")
    fun dotted() = this("dotted")
    fun dashed() = this("dashed")
    fun wavy() = this("wavy")
}

val textDecorationLine get() = textDecorationLinePropertyBuilder()

class textDecorationLinePropertyBuilder : PropertyBuilder("textDecorationLine") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun none() = this("none")

    fun underline() = this("underline")
    fun overline() = this("overline")
    fun lineThrough() = this("line-through")
}

val cursor get() = cursorPropertyBuilder()

class cursorPropertyBuilder : PropertyBuilder("cursor") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun none() = this("none")

    fun alias() = this("alias")
    fun allScroll() = this("all-scroll")
    fun auto() = this("auto")
    fun cell() = this("cell")
    fun contextMenu() = this("context-menu")
    fun colResize() = this("col-resize")
    fun copy() = this("copy")
    fun crosshair() = this("crosshair")
    fun default() = this("default")
    fun eResize() = this("e-resize")
    fun ewResize() = this("ew-resize")
    fun grab() = this("grab")
    fun grabbing() = this("grabbing")
    fun help() = this("help")
    fun move() = this("move")
    fun nResize() = this("n-resize")
    fun neResize() = this("ne-resize")
    fun neswResize() = this("nesw-resize")
    fun nsResize() = this("ns-resize")
    fun nwResize() = this("nw-resize")
    fun nwseResize() = this("nwse-resize")
    fun noDrop() = this("no-drop")
    fun notAllowed() = this("not-allowed")
    fun pointer() = this("pointer")
    fun progress() = this("progress")
    fun rowResize() = this("row-resize")
    fun sResize() = this("s-resize")
    fun seResize() = this("se-resize")
    fun swResize() = this("sw-resize")
    fun text() = this("text")
    fun verticalText() = this("vertical-text")
    fun wResize() = this("w-resize")
    fun wait() = this("wait")
    fun zoomIn() = this("zoom-in")
    fun zoomOut() = this("zoom-out")
}

val overflow get() = overflowPropertyBuilder()

class overflowPropertyBuilder : PropertyBuilder("overflow") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun visible() = this("visible")
    fun hidden() = this("hidden")
    fun scroll() = this("scroll")
    fun auto() = this("auto")
}

val float get() = floatPropertyBuilder()

class floatPropertyBuilder : PropertyBuilder("float") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun none() = this("none")

    fun left() = this("left")
    fun right() = this("right")
}

val verticalAlign get() = verticalAlignPropertyBuilder()

class verticalAlignPropertyBuilder : PropertyBuilder("verticalAlign") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun baseline() = this("baseline")
    fun sub() = this("sub")
    fun `super`() = this("super")
    fun top() = this("top")
    fun textTop() = this("text-top")
    fun middle() = this("middle")
    fun bottom() = this("bottom")
    fun textBottom() = this("text-bottom")

    operator fun invoke(value: Linear) = this(value.toString())
}

val textOverflow get() = textOverflowPropertyBuilder()

class textOverflowPropertyBuilder : PropertyBuilder("textOverflow") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun clip() = this("clip")
    fun ellipsis() = this("ellipsis")
}

val whiteSpace get() = whiteSpacePropertyBuilder()

class whiteSpacePropertyBuilder : PropertyBuilder("whiteSpace") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun normal() = this("normal")
    fun nowrap() = this("nowrap")
    fun pre() = this("pre")
    fun preLine() = this("pre-line")
    fun preWrap() = this("pre-wrap")
}

val objectFit get() = objectFitPropertyBuilder()

class objectFitPropertyBuilder : PropertyBuilder("objectFit") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun none() = this("none")

    fun fill() = this("fill")
    fun contain() = this("contain")
    fun cover() = this("cover")
    fun scaleDown() = this("scale-down")
}

val userSelect get() = userSelectPropertyBuilder()

class userSelectPropertyBuilder : PropertyBuilder("userSelect") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    fun none() = this("none")
    fun auto() = this("auto")
    fun text() = this("text")
    fun contain() = this("contain")
    fun all() = this("all")
}

val justifyContent get() = justifyContentPropertyBuilder()

class justifyContentPropertyBuilder : PropertyBuilder("justifyContent") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    fun center() = this("center")
    fun start() = this("start")
    fun end() = this("end")
    fun flexStart() = this("flex-start")
    fun flexEnd() = this("flex-end")
    fun left() = this("left")
    fun right() = this("right")

    fun baseline() = this("baseline")
    fun firstBaseline() = this("first baseline")
    fun lastBaseline() = this("last baseline")

    fun spaceBetween() = this("space-between")
    fun spaceAround() = this("space-around")
    fun spaceEvenly() = this("space-evenly")
    fun stretch() = this("stretch")

    fun safeCenter() = this("safe center")
    fun unsafeCenter() = this("unsafe center")
}

val pointerEvents get() = pointerEventsPropertyBuilder()

class pointerEventsPropertyBuilder : PropertyBuilder("pointerEvents") {
    fun initial() = this("initial")
    fun inherit() = this("inherit")
    fun unset() = this("unset")

    fun auto() = this("auto")
    fun none() = this("none")
    fun visiblePainted() = this("visiblePainted")
    fun visibleFill() = this("visibleFill")
    fun visibleStroke() = this("visibleStroke")
    fun visible() = this("visible")
    fun painted() = this("painted")
    fun fill() = this("fill")
    fun stroke() = this("stroke")
    fun all() = this("all")
}
