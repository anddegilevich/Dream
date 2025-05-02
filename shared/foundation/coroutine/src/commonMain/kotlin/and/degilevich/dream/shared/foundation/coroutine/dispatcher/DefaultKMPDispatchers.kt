package and.degilevich.dream.shared.foundation.coroutine.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

object DefaultKMPDispatchers : KMPDispatchers {
    override val main: CoroutineDispatcher get() = Dispatchers.Main.immediate
    override val background: CoroutineDispatcher get() = Dispatchers.IO
}