package and.degilevich.dream.shared.navigation.impl.manager

import and.degilevich.dream.shared.foundation.dispatcher.ext.flow.flowOnMain
import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal class NavigationActionManagerImpl : NavigationActionManager {

    private val screenActionChannel = Channel<StackNavigationAction<ScreenConfig>>()
    override val screenAction: Flow<StackNavigationAction<ScreenConfig>> = screenActionChannel
        .receiveAsFlow()
        .flowOnMain()

    override fun navigate(action: StackNavigationAction<ScreenConfig>) {
        screenActionChannel.trySend(action)
    }
}