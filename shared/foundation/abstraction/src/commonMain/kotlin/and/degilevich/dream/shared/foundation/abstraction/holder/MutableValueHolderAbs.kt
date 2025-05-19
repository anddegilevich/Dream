package and.degilevich.dream.shared.foundation.abstraction.holder

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class MutableValueHolderAbs<T>(
    initialValue: T
) : MutableValueHolder<T> {

    private val mutex = Mutex()

    private val valueMutable: MutableStateFlow<T> = MutableStateFlow(initialValue)
    override val value: StateFlow<T> = valueMutable.asStateFlow()
    override val currentValue: T get() = value.value

    override suspend fun reduce(block: T.() -> T) {
        mutex.withLock {
            valueMutable.value = currentValue.block()
        }
    }

    override fun tryReduce(block: T.() -> T) {
        if (mutex.isLocked) return
        valueMutable.value = currentValue.block()
    }
}