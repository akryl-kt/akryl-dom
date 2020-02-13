@file:Suppress("unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.ComplexSelector
import io.akryl.dom.css.PseudoSelector
import io.akryl.dom.css.Selector

val active get() = PseudoSelector(":active")
val checked get() = PseudoSelector(":checked")
val default get() = PseudoSelector(":default")
val disabled get() = PseudoSelector(":disabled")
val empty get() = PseudoSelector(":empty")
val enabled get() = PseudoSelector(":enabled")
val firstChild get() = PseudoSelector(":first-child")
val firstOfType get() = PseudoSelector(":first-of-type")
val focus get() = PseudoSelector(":focus")
val hover get() = PseudoSelector(":hover")
val indeterminate get() = PseudoSelector(":indeterminate")
val inRange get() = PseudoSelector(":in-range")
val invalid get() = PseudoSelector(":invalid")
val lastChild get() = PseudoSelector(":last-child")
val lastOfType get() = PseudoSelector(":last-of-type")
val link get() = PseudoSelector(":link")
val onlyChild get() = PseudoSelector(":only-child")
val onlyOfType get() = PseudoSelector(":only-of-type")
val optional get() = PseudoSelector(":optional")
val outOfRange get() = PseudoSelector(":out-of-range")
val readOnly get() = PseudoSelector(":read-only")
val readWrite get() = PseudoSelector(":read-write")
val required get() = PseudoSelector(":required")
val valid get() = PseudoSelector(":valid")
val visited get() = PseudoSelector(":visited")
val after get() = PseudoSelector("::after")
val before get() = PseudoSelector("::before")
val placeholder get() = PseudoSelector("::placeholder")

fun not(selector: PseudoSelector) = PseudoSelector(":not(${selector.selector})")
fun not(selector: Selector) = ComplexSelector(":not(${selector.selector})")
