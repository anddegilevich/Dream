package and.degilevich.dream.shared.navigation.api

import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManager
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.router.stack.StackNavigator

interface AppNavigator {
    val resultManager: NavigationResultManager
    val screenNavigator: StackNavigator<ScreenConfig>
}