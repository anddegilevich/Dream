package and.degilevich.dream.shared.foundation.dispatcher.ext.flow

import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

fun <T> Flow<T>.flowOnMain(): Flow<T> {
    return this.flowOn(
        context = DefaultKMPDispatchers.main
    )
}

fun <T> Flow<T>.flowOnBackground(): Flow<T> {
    return this.flowOn(
        context = DefaultKMPDispatchers.background
    )
}