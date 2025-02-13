package and.degilevich.dream.shared.navigation.impl.channel

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import and.degilevich.dream.shared.foundation.model.channel.AbstractValueChannel
import and.degilevich.dream.shared.navigation.api.dream.channel.ScreenNavigationActionChannel
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig

internal class ScreenNavigationActionChannelImpl : ScreenNavigationActionChannel,
    AbstractValueChannel<StackNavigationAction<ScreenConfig>>()