package and.degilevich.dream.shared.core.storage.api

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

interface PreferenceStorage {

    suspend fun <T> save(
        key: String,
        serializer: SerializationStrategy<T>,
        value: T
    )

    suspend fun <T> read(
        key: String,
        serializer: DeserializationStrategy<T>
    ): T?

    suspend fun clear(key: String)

    fun <T> observe(
        key: String,
        serializer: DeserializationStrategy<T>
    ): Flow<T?>
}