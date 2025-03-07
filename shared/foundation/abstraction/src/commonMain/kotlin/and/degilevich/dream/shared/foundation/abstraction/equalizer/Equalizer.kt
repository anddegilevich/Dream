package and.degilevich.dream.shared.foundation.abstraction.equalizer

interface Equalizer<T> {
    fun compare(
        one: T,
        other: T
    ): Boolean
}