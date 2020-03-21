@file:Suppress("ClassName", "unused")

package io.akryl.dom.css.properties

import io.akryl.dom.css.AbstractStyleProperty
import io.akryl.dom.css.PropertyKey

data class Transition(override val value: String?) : AbstractStyleProperty(), PropertyKey {
    override val key: String = "transition"

    fun initial() = this("initial")
    fun inherit() = this("inherit")

    fun add(
        property: PropertyKey,
        duration: Duration,
        timing: Timing = Timing.ease,
        delay: Duration = Duration.zero
    ): Transition {
        val value = "${property.key} $duration $timing $delay"
        return Transition(this.value?.let { "$it, $value" } ?: value)
    }

    operator fun invoke(
        property: PropertyKey,
        duration: Duration,
        timing: Timing = Timing.ease,
        delay: Duration = Duration.zero
    ) = add(
        property,
        duration,
        timing,
        delay
    )

    operator fun invoke(value: String?) = Transition(value)
}

val transition get() = Transition(null)

class Timing(val value: String) {
    companion object {
        val ease = Timing("ease")
        val linear = Timing("linear")
        val easeIn	 = Timing("ease-in")
        val easeOut = Timing("ease-out")
        val easeInOut = Timing("ease-in-out")
        val stepStart = Timing("step-start")
        val stepEnd = Timing("stepEnd")
    }

    override fun toString() = value
}

class Duration(val value: String) {
    companion object {
        val zero = Duration("0s")
    }

    override fun toString() = value
}

val Number.s get() = Duration("${this}s")
val Number.ms get() = Duration("${this}ms")
