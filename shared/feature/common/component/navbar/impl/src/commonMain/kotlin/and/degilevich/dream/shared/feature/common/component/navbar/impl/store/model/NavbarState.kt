package and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model

import kotlinx.serialization.Serializable

@Serializable
data class NavbarState(
    val isVisible: Boolean,
    val items: List<NavbarItem>,
    val selectedItem: NavbarItem
)