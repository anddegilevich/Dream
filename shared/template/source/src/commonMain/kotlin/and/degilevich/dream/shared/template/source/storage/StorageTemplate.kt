package and.degilevich.dream.shared.template.source.storage

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.foundation.serialization.decodeFromJson
import and.degilevich.dream.shared.foundation.serialization.encodeToJsonOrNull
import kotlinx.serialization.KSerializer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class StorageTemplate<T>(
    private val key: String,
    private val serializer: KSerializer<T>
) : Storage<T>, KoinComponent {

    private val preferenceStorage: PreferenceStorage by inject()

    override fun save(value: T) {
        val encodedValue = value.encodeToJsonOrNull(serializer = serializer) ?: return
        preferenceStorage.save(
            key = key,
            value = encodedValue
        )
    }

    override fun clear(): Boolean {
        return preferenceStorage.clear(key = key)
    }

    override fun read(): Result<T> {
        return preferenceStorage.readString(key = key)?.decodeFromJson(deserializer = serializer) ?: Result.failure(
            NullPointerException("There is no value with the key $key in preferences")
        )
    }

    override fun readOrNull(): T? {
        return read().getOrNull()
    }
}