package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueById
import and.degilevich.dream.shared.navigation.api.ActiveScreenConfigValueHolder
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.inject

internal class NavbarDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<
    NavbarState,
    NavbarIntent,
    NavbarSideEffect
    >(
    componentContext = componentContext,
    stateConservator = NavbarStateConservator()
) {

    private val activeScreenConfigValueHolder: ActiveScreenConfigValueHolder by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: NavbarIntent) {
        when (intent) {
            is NavbarIntent.OnItemClicked -> onItemClicked(intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnStart {
            collectActiveScreenConfig()
        }
    }

    private fun collectActiveScreenConfig() {
        activeScreenConfigValueHolder.value
            .onEach { screenConfig ->
                handleActiveScreenConfig(screenConfig = screenConfig)
            }
            .launchIn(scope)
    }

    private fun handleActiveScreenConfig(screenConfig: ScreenConfig) {
        val activeNavbarItem = when (screenConfig) {
            ScreenConfig.Dashboard -> NavbarItem.HOME
            ScreenConfig.Search -> NavbarItem.SEARCH
            else -> return
        }
        setSelectedItem(item = activeNavbarItem)
    }

    private fun onItemClicked(id: String) {
        val item = getEnumValueById<NavbarItem>(id = id) ?: return
        navigateToItem(item = item)
    }

    private fun navigateToItem(item: NavbarItem) {
        val destination = when (item) {
            NavbarItem.HOME -> ScreenConfig.Dashboard
            NavbarItem.SEARCH -> ScreenConfig.Search
        }
        appNavigator.screenNavigator.bringToFront(destination)
    }

    private fun setSelectedItem(item: NavbarItem) {
        reduce { copy(selectedItem = item) }
    }
}