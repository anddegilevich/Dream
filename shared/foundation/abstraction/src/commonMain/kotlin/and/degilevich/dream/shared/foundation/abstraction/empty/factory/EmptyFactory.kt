package and.degilevich.dream.shared.foundation.abstraction.empty.factory

interface EmptyFactory<out T> {
    fun empty(): T
}