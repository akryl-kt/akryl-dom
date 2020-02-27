package io.akryl.dom.css

/**
 * Accepts CSS class names in [classes] and returns classes list string.
 * The result contains only classes that have `true` value in [Pair.second] in [classes].
 * Useful to conditionally apply classes to an HTML element.
 * This function also accepts [CssClass] as it is inherited from [CharSequence].
 *
 * Example:
 * ```
 * val classes = classMap(
 *     "foo" to true,
 *     "bar" to false,
 *     "baz" to true
 * )
 * // classes == "foo baz"
 * ```
 */
fun classMap(vararg classes: Pair<CharSequence, Boolean>) = classes
    .filter { it.second }
    .joinToString(" ") { it.first }

/**
 * Accepts CSS class names in [classes] and returns concatenated classes list.
 * The result contains all [classes].
 * This function also accepts [CssClass] as it is inherited from [CharSequence].
 *
 * Example:
 * ```
 * val classes = classList("foo", "bar")
 * // classes == "foo bar"
 * ```
 */
fun classList(vararg classes: CharSequence) = classes.joinToString(" ")

/**
 * Accepts CSS elements in [css] and returns CSS with the elements combined.
 * The result contains only elements that have `true` value in [Pair.second] in [css].
 * Useful to conditionally apply CSS to an HTML element.
 *
 * Example:
 * ```
 * val foo = listOf(
 *     color.red()
 * )
 * val bar = listOf(
 *     width(100.px)
 * )
 * val baz = listOf(
 *     height(100.px)
 * )
 *
 * val result = cssMap(
 *     foo to true,
 *     bar to false,
 *     baz to true
 * )
 * // result == listOf(
 * //     color.red(),
 * //     height(100.px)
 * // )
 * ```
 */
fun cssMap(vararg css: Pair<List<CssElement>, Boolean>) = css
    .filter { it.second }
    .flatMap { it.first }

/**
 * Accepts CSS elements in [css] and returns CSS with the elements combined.
 * The result contains all [css] elements.
 *
 * Example:
 * ```
 * val foo = listOf(
 *     color.red()
 * )
 * val bar = listOf(
 *     width(100.px)
 * )
 *
 * val result = cssList(foo, bar)
 * // result == listOf(
 * //     color.red(),
 * //     width(100.px)
 * // )
 * ```
 */
fun cssList(vararg css: List<CssElement>) = css.asList().flatten()
