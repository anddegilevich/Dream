package and.degilevich.dream.shared.foundation.model.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class ValueChannelAbs<T> : ValueChannel<T> {
    private val channel: Channel<T> = Channel()
    override val value: Flow<T> = channel.receiveAsFlow()

    private val mutex = Mutex()

    override suspend fun send(value: T) {
        mutex.withLock {
            channel.send(value)
        }
    }

    override fun trySend(value: T) {
        if (mutex.isLocked) return
        channel.trySend(value)
    }
}