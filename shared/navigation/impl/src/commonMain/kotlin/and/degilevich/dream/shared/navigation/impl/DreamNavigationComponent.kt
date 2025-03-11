package and.degilevich.dream.shared.navigation.impl

import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.NavigationSource
import com.arkivanov.decompose.router.stack.StackNavigation.Event

interface DreamNavigationComponent : ComponentContext {
    val screenNavigationSource: NavigationSource<Event<ScreenConfig>>
}