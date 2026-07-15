package and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItem
import kotlinx.serialization.Serializable

@Serializable
data class NavbarState(
    val items: List<NavbarItem>,
    val activeItem: NavbarItem
)