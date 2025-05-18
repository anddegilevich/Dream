package and.degilevich.dream.shared.foundation.coroutine.dispatcher

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun <T> withMainContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = Dispatchers.Main,
        block = block
    )
}

suspend fun <T> withDefaultContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = Dispatchers.Default,
        block = block
    )
}

suspend fun <T> withIOContext(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(
        context = Dispatchers.IO,
        block = block
    )
}

fun CoroutineScope.launchOnMain(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = Dispatchers.Main,
        start = start,
        block = block
    )
}

fun CoroutineScope.launchOnDefault(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = Dispatchers.Default,
        start = start,
        block = block
    )
}

fun CoroutineScope.launchOnIO(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return launch(
        context = Dispatchers.IO,
        start = start,
        block = block
    )
}
