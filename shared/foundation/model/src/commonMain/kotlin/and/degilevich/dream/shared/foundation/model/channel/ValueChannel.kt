package and.degilevich.dream.shared.foundation.model.channel

import kotlinx.coroutines.flow.Flow

interface ValueChannel<T> {
    val value: Flow<T>

    suspend fun send(value: T)
    fun trySend(value: T)
}