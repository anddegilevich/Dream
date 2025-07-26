package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItemUIData
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.resource.api.ResourceManager
import dev.icerock.moko.resources.ImageResource
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class NavbarUIStateMapper : Mapper<NavbarState, NavbarUIState>, KoinComponent {

    private val resourceManager: ResourceManager by inject()

    override fun map(item: NavbarState): NavbarUIState {
        return with(item) {
            NavbarUIState(
                isVisible = isVisible,
                items = mapToItems(state = item)
            )
        }
    }

    private fun mapToItems(state: NavbarState): ImmutableList<NavbarItemUIData> {
        return with(state) {
            items.map { item ->
                val isSelected = item == selectedItem
                NavbarItemUIData(
                    id = item.id,
                    icon = mapItemToIcon(
                        item = item,
                        isSelected = isSelected
                    ),
                    text = mapItemToLabel(item = item),
                    isSelected = isSelected
                )
            }.toImmutableList()
        }
    }

    private fun mapItemToIcon(
        item: NavbarItem,
        isSelected: Boolean
    ): ImageResource {
        return when (item) {
            NavbarItem.HOME -> {
                if (isSelected) {
                    Res.images.ic_home
                } else {
                    Res.images.ic_home_filled
                }
            }

            NavbarItem.SEARCH -> {
                Res.images.ic_search
            }
        }
    }

    private fun mapItemToLabel(
        item: NavbarItem
    ): String {
        val resource = when (item) {
            NavbarItem.HOME -> Res.strings.navbar_item_home
            NavbarItem.SEARCH -> Res.strings.navbar_item_search
        }
        return resourceManager.getString(resource)
    }
}