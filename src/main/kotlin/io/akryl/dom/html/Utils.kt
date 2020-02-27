@file:Suppress("FunctionName")

package io.akryl.dom.html

/**
 * Maps [items] using [mapper] and returns an array of mapped elements.
 * Useful when element's children contains multiple iterable items or some headers/footers.
 *
 * Examples:
 *
 * ```
 * Div(
 *     Text("Header"),
 *     *For(items) { itemView(it) },
 *     Text("Footer")
 * )
 * ```
 *
 * ```
 * Div(children = listOf(
 *     *For(first) { firstView(it) },
 *     *For(second) { secondView(it) },
 * ))
 * ```
 */
fun <T, R> For(items: Iterable<T>, mapper: (T) -> R): Array<R> = items.map(mapper).toTypedArray()

/**
 * Overload of [For] that accepts [items] in Array instead of Iterable.
 */
fun <T, R> For(items: Array<T>, mapper: (T) -> R): Array<R> = items.map(mapper).toTypedArray()

/**
 * Overload of [For] that accepts vararg [items] instead of Iterable.
 */
fun <T, R> ForOf(vararg items: T, mapper: (T) -> R): Array<R> = items.map(mapper).toTypedArray()

/**
 * If [condition] is true, then returns an array with a single element of [onTrue] result.
 * Otherwise, returns empty array.
 *
 * Example:
 * ```
 * val condition = true
 *
 * // <div>condition is true</div>
 * Div(
 *     *If(condition) {
 *         Text("condition is true")
 *     }
 * )
 * ```
 */
fun <R> If(condition: Boolean, onTrue: () -> R): Array<R> = if (condition) arrayOf(onTrue()) else emptyArray()

/**
 * If [condition] is not null, then calls [onTrue] with [condition] as an argument and
 * returns an array with a result of the [onTrue] call.
 * Otherwise, returns empty array.
 *
 * Example:
 * ```
 * val item = "test"
 *
 * // <div>'test' is not null</div>
 * Div(
 *     *IfNotNull(item) {
 *         Text("'$it' is not null")
 *     }
 * )
 * ```
 */
fun <T, R> IfNotNull(condition: T?, onTrue: (T) -> R): Array<R> = if (condition != null) arrayOf(onTrue(condition)) else emptyArray()

/**
 * If [this] is empty, then returns result of [onElse] call.
 * Otherwise, returns an empty array.
 * Can be paired with [If], [IfNotNull] or [For] calls.
 *
 * Examples:
 *
 * ```
 * Div(
 *     *If(condition) {
 *         Text("condition is true")
 *     } Else {
 *         Text("condition is false")
 *     }
 * )
 * ```
 *
 * ```
 * Div(
 *     *For(items) {
 *         itemView(it)
 *     } Else {
 *         Text("items is empty")
 *     }
 * )
 * ```
 */
infix fun <R> Array<out R>.Else(onElse: () -> R): Array<out R> = if (this.isNotEmpty()) this else arrayOf(onElse())
