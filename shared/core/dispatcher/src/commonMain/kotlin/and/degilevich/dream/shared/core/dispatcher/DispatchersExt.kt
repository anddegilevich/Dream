package and.degilevich.dream.shared.core.dispatcher

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun <T> withMainContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = GlobalDispatchers.main,
        block = block
    )
}

suspend fun <T> withBackgroundContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = GlobalDispatchers.background,
        block = block
    )
}

fun CoroutineScope.launchOnMain(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = GlobalDispatchers.main,
        start = start,
        block = block
    )
}

fun CoroutineScope.launchOnBackground(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = GlobalDispatchers.main,
        start = start,
        block = block
    )
}