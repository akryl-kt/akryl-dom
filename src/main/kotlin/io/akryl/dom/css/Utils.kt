package io.akryl.dom.css

fun classMap(vararg classes: Pair<CharSequence, Boolean>) = classes
    .filter { it.second }
    .joinToString(" ") { it.first }

fun classList(vararg classes: CharSequence) = classes.joinToString(" ")
