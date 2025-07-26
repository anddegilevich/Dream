package and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItemUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

object NavbarItemUIDataPreviewProvider {
    fun provide(): NavbarItemUIData {
        return NavbarItemUIData.empty().copy(
            text = "Home",
            icon = Res.images.ic_home,
        )
    }

    fun provideList(): ImmutableList<NavbarItemUIData> {
        return persistentListOf(
            NavbarItemUIData.empty().copy(
                text = "Home",
                icon = Res.images.ic_home_filled,
                isSelected = true
            ),
            NavbarItemUIData.empty().copy(
                text = "Search",
                icon = Res.images.ic_search,
            )
        )
    }
}