package and.degilevich.dream.shared.navigation.impl.navigator

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.AbstractStackNavigator
import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.impl.manager.NavigationActionManager

internal class DreamScreenNavigator(
    private val navigationActionManager: NavigationActionManager
) : AbstractStackNavigator<ScreenConfig>() {
    override fun navigate(action: StackNavigationAction<ScreenConfig>) {
        navigationActionManager.navigate(action)
    }
}