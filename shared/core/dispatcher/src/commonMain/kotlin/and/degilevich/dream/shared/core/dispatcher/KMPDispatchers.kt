package and.degilevich.dream.shared.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface KMPDispatchers {
    val main: CoroutineDispatcher
    val background: CoroutineDispatcher
}