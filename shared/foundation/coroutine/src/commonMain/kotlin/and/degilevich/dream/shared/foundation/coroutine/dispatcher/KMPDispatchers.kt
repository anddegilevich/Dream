package and.degilevich.dream.shared.foundation.coroutine.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface KMPDispatchers {
    val main: CoroutineDispatcher
    val background: CoroutineDispatcher
}