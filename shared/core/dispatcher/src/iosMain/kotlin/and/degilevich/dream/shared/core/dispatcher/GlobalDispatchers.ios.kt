//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.core.dispatcher

import kotlinx.coroutines.Dispatchers

actual object GlobalDispatchers : KMPDispatchers {
    override val main = Dispatchers.Main
    override val background = Dispatchers.Default
}