package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueById
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext

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

    override fun handleIntent(intent: NavbarIntent) {
        when (intent) {
            is NavbarIntent.OnItemClicked -> onItemClicked(intent.id)
        }
    }

    private fun onItemClicked(id: String) {
        val item = getEnumValueById<NavbarItem>(id = id) ?: return
        setActiveItem(item = item)
    }

    private fun setActiveItem(item: NavbarItem) = reduce {
        copy(activeItem = item)
    }
}