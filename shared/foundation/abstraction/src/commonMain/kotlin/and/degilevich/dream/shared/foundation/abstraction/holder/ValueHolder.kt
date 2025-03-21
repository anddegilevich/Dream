package and.degilevich.dream.shared.foundation.abstraction.holder

import kotlinx.coroutines.flow.StateFlow

interface ValueHolder<T> {
    val value: StateFlow<T>
    val currentValue: T

    suspend fun setValue(valueFactory: () -> T)
    suspend fun clear()

    fun trySetValue(valueFactory: () -> T)
    fun tryClear()
}