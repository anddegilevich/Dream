package and.degilevich.dream.shared.core.storage.impl

import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.api.service.decrypt
import and.degilevich.dream.shared.core.crypto.api.service.encrypt
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.core.storage.api.exception.StorageReadException
import and.degilevich.dream.shared.core.storage.api.exception.StorageValueNotFoundException
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import and.degilevich.dream.shared.foundation.primitive.result.recoverResult
import and.degilevich.dream.shared.foundation.serialization.decodeFromJson
import and.degilevich.dream.shared.foundation.serialization.decodeFromJsonOrNull
import and.degilevich.dream.shared.foundation.serialization.encodeToJson
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.datastore.DataStoreSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

@OptIn(
    ExperimentalSettingsApi::class,
    ExperimentalSettingsImplementation::class
)
internal class PreferenceStorageImpl(
    private val settings: DataStoreSettings,
    private val cryptoService: CryptoService
) : PreferenceStorage {

    override suspend fun <T> save(
        key: String,
        serializer: SerializationStrategy<T>,
        value: T
    ) {
        value.encodeToJson(
            serializer = serializer
        ).foldResult { jsonValue ->
            cryptoService.encrypt(jsonValue)
        }.onSuccess { encryptedValue ->
            settings.putString(
                key = key,
                value = encryptedValue
            )
        }
    }

    override suspend fun <T> read(
        key: String,
        serializer: DeserializationStrategy<T>
    ): Result<T> {
        val encryptedValue = settings.getStringOrNull(key)
            ?: return Result.failure(StorageValueNotFoundException(key = key))
        return cryptoService.decrypt(encryptedValue)
            .foldResult { decryptedValue ->
                decryptedValue.decodeFromJson(deserializer = serializer)
            }.recoverResult { error ->
                Result.failure(
                    StorageReadException(
                        key = key,
                        cause = error
                    )
                )
            }
    }

    override suspend fun <T> readOrNull(
        key: String,
        serializer: DeserializationStrategy<T>
    ): T? {
        return read(
            key = key,
            serializer = serializer
        ).getOrNull()
    }

    override suspend fun clear(key: String) {
        settings.remove(key)
    }

    override suspend fun clearAll() {
        settings.clear()
    }

    override fun <T> observe(
        key: String,
        serializer: DeserializationStrategy<T>
    ): Flow<T?> {
        return settings.getStringOrNullFlow(
            key = key
        ).map { encryptedValue ->
            encryptedValue?.let { value ->
                cryptoService.decrypt(value).getOrNull()?.decodeFromJsonOrNull(
                    deserializer = serializer
                )
            }
        }.distinctUntilChanged()
    }
}