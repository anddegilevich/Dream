package and.degilevich.dream.shared.navigation.impl.navigator

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigatorAbs
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.dream.channel.ScreenNavigationActionChannel

internal class ScreenNavigator(
    screenNavigationActionChannel: ScreenNavigationActionChannel
) : StackNavigatorAbs<ScreenConfig>(
    navigationActionHandler = screenNavigationActionChannel
)