package and.degilevich.dream.shared.foundation.abstraction.holder

interface MutableValueHolder<T> : ValueHolder<T> {
    suspend fun reduce(block: T.() -> T)
    fun tryReduce(block: T.() -> T)
}