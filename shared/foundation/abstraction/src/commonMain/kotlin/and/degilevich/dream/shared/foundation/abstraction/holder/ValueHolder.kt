package and.degilevich.dream.shared.foundation.abstraction.holder

import kotlinx.coroutines.flow.StateFlow

interface ValueHolder<T> {
    val value: StateFlow<T>
    val currentValue: T
}