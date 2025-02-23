package and.degilevich.dream.shared.navigation.impl.navigator

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigatorAbs
import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.dream.channel.ScreenNavigationActionChannel

internal class ScreenNavigator(
    private val screenNavigationActionChannel: ScreenNavigationActionChannel
) : StackNavigatorAbs<ScreenConfig>() {
    override fun navigate(action: StackNavigationAction<ScreenConfig>) {
        screenNavigationActionChannel.trySend(action)
    }
}