package and.degilevich.dream.shared.foundation.model.equalizer

interface Equalizer<T> {
    fun compare(
        one: T,
        other: T
    ): Boolean
}