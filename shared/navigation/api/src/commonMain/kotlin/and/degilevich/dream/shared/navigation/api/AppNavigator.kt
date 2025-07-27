package and.degilevich.dream.shared.navigation.api

import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManager
import and.degilevich.dream.shared.navigation.api.model.config.NavbarConfig
import com.arkivanov.decompose.router.slot.SlotNavigator
import com.arkivanov.decompose.router.stack.StackNavigator

interface AppNavigator {
    val resultManager: NavigationResultManager
    val screenNavigator: StackNavigator<ScreenConfig>
    val navbarNavigator: SlotNavigator<NavbarConfig>
}