package and.degilevich.dream.shared.feature.base.data.api.storage

import kotlinx.coroutines.flow.Flow

interface Storage<T> {
    suspend fun save(value: T)
    suspend fun read(): T?
    suspend fun clear()
    fun observe(): Flow<T?>
}