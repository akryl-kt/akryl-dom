package io.akryl.dom.css

/**
 * Represents a CSS selector.
 * @see [css] to create selectors for CSS classes.
 *
 * Examples:
 * ```
 * // .foo
 * val foo by css()
 *
 * // .bar
 * val bar by css()
 *
 * // .baz
 * val baz by css()
 *
 * // .foo.bar
 * val styles = (foo + bar)(
 *     color.red()
 *
 *     // .foo.bar:hover
 *     hover(
 *         color.green()
 *     )
 *
 *     // .foo.bar .baz
 *     baz(
 *         color.blue()
 *     )
 *
 *     // .foo.bar div
 *     tag("div")(
 *         color.orange()
 *     )
 * )
 * ```
 */
interface Selector {
    val selector: String
}

/**
 * Class name CSS selector.
 */
data class CssClass(val name: String) : CharSequence by name, Selector {
    override val selector = ".$name"

    override fun toString() = name
    operator fun plus(other: CssClass) = ClassList(listOf(this, other))
}

/**
 * Class list CSS selector.
 */
data class ClassList(val classes: List<CssClass>) : Selector {
    override val selector get() = classes.joinToString("") { it.selector }
    override fun toString() = selector
    operator fun plus(other: CssClass) = ClassList(classes + other)
}

/**
 * Tag name CSS selector.
 */
open class TagName(val value: String) : Selector {
    override val selector get() = value
    override fun toString() = value
    override fun equals(other: Any?) = other is TagName && other.value == value
    override fun hashCode() = value.hashCode()

    operator fun get(inner: ClassList) = ComplexSelector("$value${inner.selector}")
    operator fun get(inner: CssClass) = ComplexSelector("$value${inner.selector}")
}

/**
 * Pseudo class CSS selector.
 */
data class PseudoSelector(val value: String) : Selector {
    override val selector get() = value
    override fun toString() = value
    operator fun plus(other: PseudoSelector) = PseudoSelector("$value${other.value}")
}

/**
 * Combination of other CSS selectors: classes, tags, pseudo-selectors.
 */
data class ComplexSelector(val value: String) : Selector {
    override val selector get() = value
    override fun toString() = value
}

/**
 * Returns a tag [name] selector.
 */
fun tag(name: String) = TagName(name)

/**
 * Returns a CSS with [this] selector and [items] styles.
 * If you put this CSS inside another CSS, then the selector will be applied to children elements.
 */
operator fun Selector.invoke(vararg items: CssElement) = SelectorStyles("& ${this.selector}", items.asList())

/**
 * Returns a CSS with [this] pseudo-selector and [items] styles.
 * If you put this CSS inside another CSS, then the selector will be applied to a parent element.
 */
operator fun PseudoSelector.invoke(vararg items: CssElement) = SelectorStyles("&${this.selector}", items.asList())
