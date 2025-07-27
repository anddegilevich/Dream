package and.degilevich.dream.shared.navigation.impl

import and.degilevich.dream.shared.navigation.api.model.config.NavbarConfig
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.NavigationSource
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.stack.StackNavigation

interface AppNavigationComponent : ComponentContext {
    val screenNavigationSource: NavigationSource<StackNavigation.Event<ScreenConfig>>
    val navbarNavigationSource: NavigationSource<SlotNavigation.Event<NavbarConfig>>
}