package io.akryl.dom.css

interface Selector {
    val selector: String
}

data class CssClass(val name: String) : CharSequence by name, Selector {
    override val selector = ".$name"

    override fun toString() = name
    operator fun plus(other: CssClass) = ClassList(listOf(this, other))
}

data class ClassList(val classes: List<CssClass>) : Selector {
    override val selector get() = classes.joinToString("") { it.selector }
    override fun toString() = selector
    operator fun plus(other: CssClass) = ClassList(classes + other)
}

data class TagName(val value: String) : Selector {
    override val selector get() = value
    override fun toString() = value

    operator fun get(inner: ClassList) = ComplexSelector("$value${inner.selector}")
    operator fun get(inner: CssClass) = ComplexSelector("$value${inner.selector}")
}

data class PseudoSelector(val value: String) : Selector {
    override val selector get() = value
    override fun toString() = value
    operator fun plus(other: PseudoSelector) = PseudoSelector("$value${other.value}")
}

data class ComplexSelector(val value: String) : Selector {
    override val selector get() = value
    override fun toString() = value
}

fun tag(name: String) = TagName(name)
operator fun Selector.invoke(vararg items: CssElement) = SelectorStyles("& ${this.selector}", items.asList())
operator fun PseudoSelector.invoke(vararg items: CssElement) = SelectorStyles("&${this.selector}", items.asList())
