@file:Suppress("EnumEntryName", "unused", "SpellCheckingInspection", "MemberVisibilityCanBePrivate")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class Color(val value: String) {
  companion object {
    val initial = Color("initial")
    val inherit = Color("inherit")
    val unset = Color("unset")

    val transparent = Color("transparent")
    val currentColor = Color("currentColor")

    // W3C predefined HTML colors (147), see the referenced specification above.
    val aliceBlue = Color("aliceblue")
    val antiqueWhite = Color("antiquewhite")
    val aqua = Color("aqua")
    val aquamarine = Color("aquamarine")
    val azure = Color("azure")
    val beige = Color("beige")
    val bisque = Color("bisque")
    val black = Color("black")
    val blanchedAlmond = Color("blanchedalmond")
    val blue = Color("blue")
    val blueViolet = Color("blueviolet")
    val brown = Color("brown")
    val burlyWood = Color("burlywood")
    val cadetBlue = Color("cadetblue")
    val chartreuse = Color("chartreuse")
    val chocolate = Color("chocolate")
    val coral = Color("coral")
    val cornflowerBlue = Color("cornflowerblue")
    val cornsilk = Color("cornsilk")
    val crimson = Color("crimson")
    val cyan = Color("cyan")
    val darkBlue = Color("darkblue")
    val darkCyan = Color("darkcyan")
    val darkGoldenrod = Color("darkgoldenrod")
    val darkGray = Color("darkgray")
    val darkGreen = Color("darkgreen")
    val darkGrey = Color("darkgrey")
    val darkKhaki = Color("darkkhaki")
    val darkMagenta = Color("darkmagenta")
    val darkOliveGreen = Color("darkolivegreen")
    val darkOrange = Color("darkorange")
    val darkOrchid = Color("darkorchid")
    val darkRed = Color("darkred")
    val darkSalmon = Color("darksalmon")
    val darkSeaGreen = Color("darkseagreen")
    val darkSlateBlue = Color("darkslateblue")
    val darkSlateGray = Color("darkslategray")
    val darkSlateGrey = Color("darkslategrey")
    val darkTurquoise = Color("darkturquoise")
    val darkViolet = Color("darkviolet")
    val deepPink = Color("deeppink")
    val deepSkyBlue = Color("deepskyblue")
    val dimGray = Color("dimgray")
    val dimGrey = Color("dimgrey")
    val dodgerBlue = Color("dodgerblue")
    val firebrick = Color("firebrick")
    val floralWhite = Color("floralwhite")
    val forestGreen = Color("forestgreen")
    val fuchsia = Color("fuchsia")
    val gainsboro = Color("gainsboro")
    val ghostWhite = Color("ghostwhite")
    val gold = Color("gold")
    val goldenrod = Color("goldenrod")
    val gray = Color("gray")
    val green = Color("green")
    val greenYellow = Color("greenyellow")
    val grey = Color("grey")
    val honeydew = Color("honeydew")
    val hotPink = Color("hotpink")
    val indianRed = Color("indianred")
    val indigo = Color("indigo")
    val ivory = Color("ivory")
    val khaki = Color("khaki")
    val lavender = Color("lavender")
    val lavenderBlush = Color("lavenderblush")
    val lawnGreen = Color("lawngreen")
    val lemonChiffon = Color("lemonchiffon")
    val lightBlue = Color("lightblue")
    val lightCoral = Color("lightcoral")
    val lightCyan = Color("lightcyan")
    val lightGoldenrodYellow = Color("lightgoldenrodyellow")
    val lightGray = Color("lightgray")
    val lightGreen = Color("lightgreen")
    val lightGrey = Color("lightgrey")
    val lightPink = Color("lightpink")
    val lightSalmon = Color("lightsalmon")
    val lightSeaGreen = Color("lightseagreen")
    val lightSkyBlue = Color("lightskyblue")
    val lightSlateGray = Color("lightslategray")
    val lightSlateGrey = Color("lightslategrey")
    val lightSteelBlue = Color("lightsteelblue")
    val lightYellow = Color("lightyellow")
    val lime = Color("lime")
    val limeGreen = Color("limegreen")
    val linen = Color("linen")
    val magenta = Color("magenta")
    val maroon = Color("maroon")
    val mediumAquamarine = Color("mediumaquamarine")
    val mediumBlue = Color("mediumblue")
    val mediumOrchid = Color("mediumorchid")
    val mediumPurple = Color("mediumpurple")
    val mediumSeaGreen = Color("mediumseagreen")
    val mediumSlateBlue = Color("mediumslateblue")
    val mediumSpringGreen = Color("mediumspringgreen")
    val mediumTurquoise = Color("mediumturquoise")
    val mediumVioletRed = Color("mediumvioletred")
    val midnightBlue = Color("midnightblue")
    val mintCream = Color("mintcream")
    val mistyRose = Color("mistyrose")
    val moccasin = Color("moccasin")
    val navajoWhite = Color("navajowhite")
    val navy = Color("navy")
    val oldLace = Color("oldlace")
    val olive = Color("olive")
    val oliveDrab = Color("olivedrab")
    val orange = Color("orange")
    val orangeRed = Color("orangered")
    val orchid = Color("orchid")
    val paleGoldenrod = Color("palegoldenrod")
    val paleGreen = Color("palegreen")
    val paleTurquoise = Color("paleturquoise")
    val paleVioletRed = Color("palevioletred")
    val papayaWhip = Color("papayawhip")
    val peachPuff = Color("peachpuff")
    val peru = Color("peru")
    val pink = Color("pink")
    val plum = Color("plum")
    val powderBlue = Color("powderblue")
    val purple = Color("purple")
    val red = Color("red")
    val rosyBrown = Color("rosybrown")
    val royalBlue = Color("royalblue")
    val saddleBrown = Color("saddlebrown")
    val salmon = Color("salmon")
    val sandyBrown = Color("sandybrown")
    val seaGreen = Color("seagreen")
    val seaShell = Color("seashell")
    val sienna = Color("sienna")
    val silver = Color("silver")
    val skyBlue = Color("skyblue")
    val slateBlue = Color("slateblue")
    val slateGray = Color("slategray")
    val slateGrey = Color("slategrey")
    val snow = Color("snow")
    val springGreen = Color("springgreen")
    val steelBlue = Color("steelblue")
    val tan = Color("tan")
    val teal = Color("teal")
    val thistle = Color("thistle")
    val tomato = Color("tomato")
    val turquoise = Color("turquoise")
    val violet = Color("violet")
    val wheat = Color("wheat")
    val white = Color("white")
    val whiteSmoke = Color("whitesmoke")
    val yellow = Color("yellow")
    val yellowGreen = Color("yellowgreen")
  }

  constructor(value: Int) : this('#' + value.toString(16).padStart(6, '0'))
  constructor(value: Long) : this('#' + value.toString(16).padStart(6, '0'))

  override fun toString() = value
}

class ColorPropertyBuilder(name: String) : PropertyBuilder(name) {
  fun initial() = this("initial")
  fun inherit() = this("inherit")
  fun unset() = this("unset")

  fun transparent() = this("transparent")
  fun currentColor() = this("current-color")

  fun aliceBlue() = this("aliceblue")
  fun antiqueWhite() = this("antiquewhite")
  fun aqua() = this("aqua")
  fun aquamarine() = this("aquamarine")
  fun azure() = this("azure")
  fun beige() = this("beige")
  fun bisque() = this("bisque")
  fun black() = this("black")
  fun blanchedAlmond() = this("blanchedalmond")
  fun blue() = this("blue")
  fun blueViolet() = this("blueviolet")
  fun brown() = this("brown")
  fun burlyWood() = this("burlywood")
  fun cadetBlue() = this("cadetblue")
  fun chartreuse() = this("chartreuse")
  fun chocolate() = this("chocolate")
  fun coral() = this("coral")
  fun cornflowerBlue() = this("cornflowerblue")
  fun cornsilk() = this("cornsilk")
  fun crimson() = this("crimson")
  fun cyan() = this("cyan")
  fun darkBlue() = this("darkblue")
  fun darkCyan() = this("darkcyan")
  fun darkGoldenrod() = this("darkgoldenrod")
  fun darkGray() = this("darkgray")
  fun darkGreen() = this("darkgreen")
  fun darkGrey() = this("darkgrey")
  fun darkKhaki() = this("darkkhaki")
  fun darkMagenta() = this("darkmagenta")
  fun darkOliveGreen() = this("darkolivegreen")
  fun darkOrange() = this("darkorange")
  fun darkOrchid() = this("darkorchid")
  fun darkRed() = this("darkred")
  fun darkSalmon() = this("darksalmon")
  fun darkSeaGreen() = this("darkseagreen")
  fun darkSlateBlue() = this("darkslateblue")
  fun darkSlateGray() = this("darkslategray")
  fun darkSlateGrey() = this("darkslategrey")
  fun darkTurquoise() = this("darkturquoise")
  fun darkViolet() = this("darkviolet")
  fun deepPink() = this("deeppink")
  fun deepSkyBlue() = this("deepskyblue")
  fun dimGray() = this("dimgray")
  fun dimGrey() = this("dimgrey")
  fun dodgerBlue() = this("dodgerblue")
  fun firebrick() = this("firebrick")
  fun floralWhite() = this("floralwhite")
  fun forestGreen() = this("forestgreen")
  fun fuchsia() = this("fuchsia")
  fun gainsboro() = this("gainsboro")
  fun ghostWhite() = this("ghostwhite")
  fun gold() = this("gold")
  fun goldenrod() = this("goldenrod")
  fun gray() = this("gray")
  fun green() = this("green")
  fun greenYellow() = this("greenyellow")
  fun grey() = this("grey")
  fun honeydew() = this("honeydew")
  fun hotPink() = this("hotpink")
  fun indianRed() = this("indianred")
  fun indigo() = this("indigo")
  fun ivory() = this("ivory")
  fun khaki() = this("khaki")
  fun lavender() = this("lavender")
  fun lavenderBlush() = this("lavenderblush")
  fun lawnGreen() = this("lawngreen")
  fun lemonChiffon() = this("lemonchiffon")
  fun lightBlue() = this("lightblue")
  fun lightCoral() = this("lightcoral")
  fun lightCyan() = this("lightcyan")
  fun lightGoldenrodYellow() = this("lightgoldenrodyellow")
  fun lightGray() = this("lightgray")
  fun lightGreen() = this("lightgreen")
  fun lightGrey() = this("lightgrey")
  fun lightPink() = this("lightpink")
  fun lightSalmon() = this("lightsalmon")
  fun lightSeaGreen() = this("lightseagreen")
  fun lightSkyBlue() = this("lightskyblue")
  fun lightSlateGray() = this("lightslategray")
  fun lightSlateGrey() = this("lightslategrey")
  fun lightSteelBlue() = this("lightsteelblue")
  fun lightYellow() = this("lightyellow")
  fun lime() = this("lime")
  fun limeGreen() = this("limegreen")
  fun linen() = this("linen")
  fun magenta() = this("magenta")
  fun maroon() = this("maroon")
  fun mediumAquamarine() = this("mediumaquamarine")
  fun mediumBlue() = this("mediumblue")
  fun mediumOrchid() = this("mediumorchid")
  fun mediumPurple() = this("mediumpurple")
  fun mediumSeaGreen() = this("mediumseagreen")
  fun mediumSlateBlue() = this("mediumslateblue")
  fun mediumSpringGreen() = this("mediumspringgreen")
  fun mediumTurquoise() = this("mediumturquoise")
  fun mediumVioletRed() = this("mediumvioletred")
  fun midnightBlue() = this("midnightblue")
  fun mintCream() = this("mintcream")
  fun mistyRose() = this("mistyrose")
  fun moccasin() = this("moccasin")
  fun navajoWhite() = this("navajowhite")
  fun navy() = this("navy")
  fun oldLace() = this("oldlace")
  fun olive() = this("olive")
  fun oliveDrab() = this("olivedrab")
  fun orange() = this("orange")
  fun orangeRed() = this("orangered")
  fun orchid() = this("orchid")
  fun paleGoldenrod() = this("palegoldenrod")
  fun paleGreen() = this("palegreen")
  fun paleTurquoise() = this("paleturquoise")
  fun paleVioletRed() = this("palevioletred")
  fun papayaWhip() = this("papayawhip")
  fun peachPuff() = this("peachpuff")
  fun peru() = this("peru")
  fun pink() = this("pink")
  fun plum() = this("plum")
  fun powderBlue() = this("powderblue")
  fun purple() = this("purple")
  fun red() = this("red")
  fun rosyBrown() = this("rosybrown")
  fun royalBlue() = this("royalblue")
  fun saddleBrown() = this("saddlebrown")
  fun salmon() = this("salmon")
  fun sandyBrown() = this("sandybrown")
  fun seaGreen() = this("seagreen")
  fun seaShell() = this("seashell")
  fun sienna() = this("sienna")
  fun silver() = this("silver")
  fun skyBlue() = this("skyblue")
  fun slateBlue() = this("slateblue")
  fun slateGray() = this("slategray")
  fun slateGrey() = this("slategrey")
  fun snow() = this("snow")
  fun springGreen() = this("springgreen")
  fun steelBlue() = this("steelblue")
  fun tan() = this("tan")
  fun teal() = this("teal")
  fun thistle() = this("thistle")
  fun tomato() = this("tomato")
  fun turquoise() = this("turquoise")
  fun violet() = this("violet")
  fun wheat() = this("wheat")
  fun white() = this("white")
  fun whiteSmoke() = this("whitesmoke")
  fun yellow() = this("yellow")
  fun yellowGreen() = this("yellowgreen")

  operator fun invoke(value: Int) = this('#' + value.toString(16).padStart(6, '0'))
  operator fun invoke(value: Long) = this('#' + value.toString(16).padStart(6, '0'))
  operator fun invoke(value: Color) = this(value.toString())

  fun rgb(red: Int, green: Int, blue: Int) = this("rgb($red, $green, $blue)")
  fun rgba(red: Int, green: Int, blue: Int, alpha: Double) = this("rgba($red, $green, $blue, $alpha)")
  fun hsl(hue: Int, saturation: Int, lightness: Int) = this("hsl($hue, $saturation%, $lightness%)")
  fun hsla(hue: Int, saturation: Int, lightness: Int, alpha: Double) = this("hsla($hue, $saturation%, $lightness%, $alpha)")
}

fun rgb(red: Int, green: Int, blue: Int) = Color("rgb($red, $green, $blue)")
fun rgba(red: Int, green: Int, blue: Int, alpha: Double) = Color("rgba($red, $green, $blue, $alpha)")
fun hsl(hue: Int, saturation: Int, lightness: Int) = Color("hsl($hue, $saturation%, $lightness%)")
fun hsla(hue: Int, saturation: Int, lightness: Int, alpha: Double) = Color("hsla($hue, $saturation%, $lightness%, $alpha)")

val backgroundColor = ColorPropertyBuilder("backgroundColor")
val borderBottomColor = ColorPropertyBuilder("borderBottomColor")
val borderColor = ColorPropertyBuilder("borderColor")
val borderLeftColor = ColorPropertyBuilder("borderLeftColor")
val borderRightColor = ColorPropertyBuilder("borderRightColor")
val borderTopColor = ColorPropertyBuilder("borderTopColor")
val color = ColorPropertyBuilder("color")
val outlineColor = ColorPropertyBuilder("outlineColor")
val textDecorationColor = ColorPropertyBuilder("textDecorationColor")
val stroke = ColorPropertyBuilder("stroke")
val fill = ColorPropertyBuilder("fill")