package and.degilevich.dream.shared.foundation.coroutine.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

fun <T> Flow<T>.flowOnMain(): Flow<T> {
    return this.flowOn(
        context = Dispatchers.Main
    )
}

fun <T> Flow<T>.flowOnDefault(): Flow<T> {
    return this.flowOn(
        context = Dispatchers.Default
    )
}

fun <T> Flow<T>.flowOnIO(): Flow<T> {
    return this.flowOn(
        context = Dispatchers.IO
    )
}
