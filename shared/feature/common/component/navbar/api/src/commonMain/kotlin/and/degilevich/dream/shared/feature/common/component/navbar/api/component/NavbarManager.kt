package and.degilevich.dream.shared.feature.common.component.navbar.api.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface NavbarManager {

    val items: StateFlow<List<NavbarItem>>
    val activeItem: StateFlow<NavbarItem>
    val activeItemIndex: Flow<Int>

    fun selectItem(item: NavbarItem)
    fun init(
        items: List<NavbarItem>,
        activeItem: NavbarItem
    )
}
