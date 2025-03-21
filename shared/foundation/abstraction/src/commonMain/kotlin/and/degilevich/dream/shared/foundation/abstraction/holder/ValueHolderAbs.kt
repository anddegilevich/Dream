package and.degilevich.dream.shared.foundation.abstraction.holder

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class ValueHolderAbs<T>(
    private val defaultValueFactory: () -> T
) : ValueHolder<T> {

    constructor(defaultValue: T) : this(
        defaultValueFactory = { defaultValue }
    )

    private val mutex = Mutex()

    private val valueMutable = MutableStateFlow(defaultValueFactory())
    override val value = valueMutable.asStateFlow()
    override val currentValue get() = value.value

    override suspend fun clear() {
        setValue(defaultValueFactory)
    }

    override suspend fun setValue(valueFactory: () -> T) {
        mutex.withLock {
            valueMutable.value = valueFactory()
        }
    }

    override fun trySetValue(valueFactory: () -> T) {
        if (mutex.isLocked) return
        valueMutable.value = valueFactory()
    }

    override fun tryClear() {
        trySetValue(defaultValueFactory)
    }
}