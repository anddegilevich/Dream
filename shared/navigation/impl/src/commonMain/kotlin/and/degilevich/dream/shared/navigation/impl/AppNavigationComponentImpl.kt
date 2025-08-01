package and.degilevich.dream.shared.navigation.impl

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManager
import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManagerState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.model.config.NavbarConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.NavigationSource
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.SlotNavigator
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.StackNavigator
import org.koin.core.component.KoinComponent

class AppNavigationComponentImpl(
    componentContext: ComponentContext
) : AppNavigationComponent,
    KoinComponent,
    AppNavigator,
    ComponentContext by componentContext {

    private val screenNavigation: StackNavigation<ScreenConfig> = StackNavigation()
    private val navbarNavigation: SlotNavigation<NavbarConfig> = SlotNavigation()
    override val screenNavigationSource: NavigationSource<StackNavigation.Event<ScreenConfig>> = screenNavigation
    override val navbarNavigationSource: NavigationSource<SlotNavigation.Event<NavbarConfig>> = navbarNavigation
    override val screenNavigator: StackNavigator<ScreenConfig> = screenNavigation
    override val navbarNavigator: SlotNavigator<NavbarConfig> = navbarNavigation

    override val resultManager: NavigationResultManager = NavigationResultManager(
        initialState = stateKeeper.consume(
            key = NavigationResultManagerState::class.className(),
            strategy = NavigationResultManagerState.serializer()
        ).orEmpty(NavigationResultManagerState),
    )

    init {
        registerResultManagerState()
        getKoin().declare<AppNavigator>(instance = this)
    }

    private fun registerResultManagerState() {
        stateKeeper.register(
            key = NavigationResultManagerState::class.className(),
            strategy = NavigationResultManagerState.serializer()
        ) { resultManager.state }
    }
}