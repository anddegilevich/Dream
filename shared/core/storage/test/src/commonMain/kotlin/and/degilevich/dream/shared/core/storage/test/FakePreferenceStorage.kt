package and.degilevich.dream.shared.core.storage.test

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

class FakePreferenceStorage(
    private val onSave: (key: String, value: Any?) -> Unit = { _, _ -> fakeImplementationError() },
    private val onRead: (key: String) -> Result<Any?> = { fakeImplementationError() },
    private val onReadOrNull: (key: String) -> Any? = { fakeImplementationError() },
    private val onClear: (key: String) -> Unit = { fakeImplementationError() },
    private val onClearAll: () -> Unit = { fakeImplementationError() },
    private val onObserve: (key: String) -> Flow<Any?> = { fakeImplementationError() }
) : PreferenceStorage {

    override suspend fun <T> save(
        key: String,
        serializer: SerializationStrategy<T>,
        value: T
    ) {
        onSave(key, value)
    }

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T> read(
        key: String,
        serializer: DeserializationStrategy<T>
    ): Result<T> {
        return onRead(key) as Result<T>
    }

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T> readOrNull(
        key: String,
        serializer: DeserializationStrategy<T>
    ): T? {
        return onReadOrNull(key) as T?
    }

    override suspend fun clear(key: String) {
        onClear(key)
    }

    override suspend fun clearAll() {
        onClearAll()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> observe(
        key: String,
        serializer: DeserializationStrategy<T>
    ): Flow<T?> {
        return onObserve(key) as Flow<T?>
    }
}
