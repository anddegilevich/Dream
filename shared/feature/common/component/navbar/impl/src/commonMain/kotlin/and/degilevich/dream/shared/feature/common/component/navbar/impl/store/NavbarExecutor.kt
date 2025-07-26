package and.degilevich.dream.shared.feature.common.component.navbar.impl.store

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueById
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.lifecycle.Lifecycle
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

internal class NavbarExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<NavbarState, NavbarIntent, NavbarSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()

    override fun executeIntent(intent: NavbarIntent) {
        when (intent) {
            is NavbarIntent.OnItemClicked -> onItemClicked(intent.id)
        }
    }

    private fun onItemClicked(id: String) {
        val item = getEnumValueById<NavbarItem>(id = id) ?: return
        setSelectedItem(item = item)
        navigateToItem(item = item)
    }

    private fun navigateToItem(item: NavbarItem) {
        val destination = when (item) {
            NavbarItem.HOME -> ScreenConfig.Dashboard
            NavbarItem.SEARCH -> ScreenConfig.Search
        }
        navigator.screenNavigator.replaceAll(destination)
    }

    private fun setSelectedItem(item: NavbarItem) {
        reduce { copy(selectedItem = item) }
    }
}