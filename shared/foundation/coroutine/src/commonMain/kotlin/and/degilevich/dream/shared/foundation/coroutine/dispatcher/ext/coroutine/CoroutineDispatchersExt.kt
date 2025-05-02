package and.degilevich.dream.shared.foundation.coroutine.dispatcher.ext.coroutine

import and.degilevich.dream.shared.foundation.coroutine.dispatcher.DefaultKMPDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun <T> withMainContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = DefaultKMPDispatchers.main,
        block = block
    )
}

suspend fun <T> withBackgroundContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = DefaultKMPDispatchers.background,
        block = block
    )
}

fun CoroutineScope.launchOnMain(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = DefaultKMPDispatchers.main,
        start = start,
        block = block
    )
}

fun CoroutineScope.launchOnBackground(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = DefaultKMPDispatchers.background,
        start = start,
        block = block
    )
}