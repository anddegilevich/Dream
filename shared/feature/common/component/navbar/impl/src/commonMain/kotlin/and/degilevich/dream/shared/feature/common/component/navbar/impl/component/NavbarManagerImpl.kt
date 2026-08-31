package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarManager
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

internal class NavbarManagerImpl : NavbarManager {

    private val mutableItems = MutableStateFlow(NavbarItem.entries.toList())
    private val mutableActiveItem = MutableStateFlow(NavbarItem.DASHBOARD)

    override val items = mutableItems.asStateFlow()
    override val activeItem = mutableActiveItem.asStateFlow()
    override val activeItemIndex: Flow<Int> = combine(items, activeItem) { items, activeItem ->
        items.indexOf(activeItem).coerceAtLeast(0)
    }

    override fun selectItem(item: NavbarItem) {
        mutableActiveItem.update { item }
    }

    override fun init(
        items: List<NavbarItem>,
        activeItem: NavbarItem
    ) {
        mutableItems.update { items }
        mutableActiveItem.update { activeItem }
    }
}
