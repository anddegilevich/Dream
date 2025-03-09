package and.degilevich.dream.shared.foundation.coroutine.mutex

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

suspend inline fun <T> Mutex.withLockOrReturn(
    owner: Any? = null,
    block: () -> T
) {
    if (isLocked) return
    withLock(
        owner = owner,
        action = block
    )
}