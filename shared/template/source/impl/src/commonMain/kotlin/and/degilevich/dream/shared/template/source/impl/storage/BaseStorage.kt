package and.degilevich.dream.shared.template.source.impl.storage

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.template.source.api.storage.Storage
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.KSerializer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseStorage<T>(
    private val key: String,
    private val serializer: KSerializer<T>
) : Storage<T>, KoinComponent {

    private val preferenceStorage: PreferenceStorage by inject()

    override suspend fun save(value: T) {
        preferenceStorage.save(
            key = key,
            value = value,
            serializer = serializer
        )
    }

    override suspend fun clear() {
        preferenceStorage.clear(key = key)
    }

    override suspend fun read(): T? {
        return preferenceStorage.read(
            key = key,
            serializer = serializer
        )
    }

    override fun observe(): Flow<T?> {
        return preferenceStorage.observe(
            key = key,
            serializer = serializer
        )
    }
}