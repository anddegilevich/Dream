package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarManager
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueById
import com.arkivanov.decompose.ComponentContext
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

    private val navbarManager: NavbarManager by inject()

    init {
        observeNavbarItems()
        observeActiveNavbarItem()
    }

    override fun handleIntent(intent: NavbarIntent) {
        when (intent) {
            is NavbarIntent.OnItemClicked -> onItemClicked(intent.id)
        }
    }

    private fun onItemClicked(id: Identifier) {
        val item = getEnumValueById<NavbarItem>(id = id) ?: return
        navbarManager.selectItem(item = item)
    }

    private fun observeNavbarItems() = navbarManager.items.onEach { items ->
        setItems(items)
    }.launchIn(scope)

    private fun observeActiveNavbarItem() = navbarManager.activeItem.onEach { activeItem ->
        setActiveItem(activeItem)
    }.launchIn(scope)

    private fun setActiveItem(item: NavbarItem) = reduce {
        copy(activeItem = item)
    }

    private fun setItems(items: List<NavbarItem>) = reduce {
        copy(items = items)
    }
}
