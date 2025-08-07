package and.degilevich.dream.shared.template.source.impl.storage

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.foundation.serialization.decodeFromJson
import and.degilevich.dream.shared.foundation.serialization.encodeToJson
import and.degilevich.dream.shared.template.source.api.storage.Storage
import kotlinx.serialization.KSerializer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseStorage<T>(
    private val key: String,
    private val serializer: KSerializer<T>
) : Storage<T>, KoinComponent {

    private val preferenceStorage: PreferenceStorage by inject()

    override fun save(value: T) {
        value.encodeToJson(serializer = serializer).onSuccess { encodedValue ->
            preferenceStorage.save(
                key = key,
                value = encodedValue
            )
        }
    }

    override fun clear(): Boolean {
        return preferenceStorage.clear(key = key)
    }

    override fun read(): Result<T> {
        return preferenceStorage.read(key = key)?.decodeFromJson(deserializer = serializer) ?: Result.failure(
            NullPointerException("There is no value with the key $key in preferences")
        )
    }

    override fun readOrNull(): T? {
        return read().getOrNull()
    }
}