@file:Suppress("unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.PropertyBuilder

class QuotedStringPropertyBuilder(name: String) : PropertyBuilder(name) {
    override operator fun invoke(value: String?) = super.invoke(value?.let { "'$it'" })
}

val content = QuotedStringPropertyBuilder("content")
