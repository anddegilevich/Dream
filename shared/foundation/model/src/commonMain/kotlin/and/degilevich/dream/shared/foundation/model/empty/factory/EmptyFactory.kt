package and.degilevich.dream.shared.foundation.model.empty.factory

interface EmptyFactory<out T> {
    fun empty(): T
}