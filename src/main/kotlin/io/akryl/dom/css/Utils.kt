package io.akryl.dom.css

fun classMap(vararg classes: Pair<CharSequence, Boolean>) = classes
    .filter { it.second }
    .joinToString(" ") { it.first }

fun classList(vararg classes: CharSequence) = classes.joinToString(" ")

fun cssMap(vararg css: Pair<List<CssElement>, Boolean>) = css
    .filter { it.second }
    .flatMap { it.first }

fun cssList(vararg css: List<CssElement>) = css.asList().flatten()
