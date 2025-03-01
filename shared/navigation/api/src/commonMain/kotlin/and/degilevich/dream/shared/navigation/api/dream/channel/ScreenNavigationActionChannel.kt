package and.degilevich.dream.shared.navigation.api.dream.channel

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationActionHandler
import and.degilevich.dream.shared.foundation.model.channel.ValueChannel
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig

interface ScreenNavigationActionChannel :
    ValueChannel<StackNavigationAction<ScreenConfig>>,
    StackNavigationActionHandler<ScreenConfig>