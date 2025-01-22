package and.degilevich.dream.shared.navigation.impl.manager

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import kotlinx.coroutines.flow.Flow

interface NavigationActionManager {
    val screenAction: Flow<StackNavigationAction<ScreenConfig>>

    fun navigate(action: StackNavigationAction<ScreenConfig>)
}