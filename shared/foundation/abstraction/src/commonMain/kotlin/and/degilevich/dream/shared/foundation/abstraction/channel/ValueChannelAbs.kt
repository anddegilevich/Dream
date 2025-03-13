package and.degilevich.dream.shared.foundation.abstraction.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class ValueChannelAbs<T> : ValueChannel<T> {
    private val channel: Channel<T> = Channel()
    override val value: Flow<T> = channel.receiveAsFlow()

    override suspend fun send(value: T) {
        channel.send(value)
    }

    override fun trySend(value: T) {
        channel.trySend(value)
    }
}