//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.foundation.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual object DefaultKMPDispatchers : KMPDispatchers {
    override val main = Dispatchers.Main as CoroutineDispatcher
    override val background = Dispatchers.Default
}