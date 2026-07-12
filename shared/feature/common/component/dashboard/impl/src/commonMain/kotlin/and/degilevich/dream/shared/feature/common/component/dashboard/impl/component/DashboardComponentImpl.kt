package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.impl.component.AlbumReleasesComponentImpl
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.Items
import com.arkivanov.decompose.router.items.ItemsNavigation
import com.arkivanov.decompose.router.items.LazyChildItems
import com.arkivanov.decompose.router.items.childItems

@OptIn(ExperimentalDecomposeApi::class)
class DashboardComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(
    componentContext = componentContext
),
    DashboardComponent {

    private val itemsNavigation = ItemsNavigation<DashboardItemConfig>()

    override val items: LazyChildItems<DashboardItemConfig, DashboardItem> = childItems(
        source = itemsNavigation,
        serializer = DashboardItemConfig.serializer(),
        initialItems = {
            Items(
                items = listOf(DashboardItemConfig.AlbumReleases)
            )
        },
        key = ITEMS_KEY,
        childFactory = ::itemFactory
    )

    private fun itemFactory(
        config: DashboardItemConfig,
        componentContext: ComponentContext
    ): DashboardItem {
        return when (config) {
            is DashboardItemConfig.AlbumReleases -> {
                DashboardItem.AlbumReleases(
                    component = AlbumReleasesComponentImpl(
                        componentContext = componentContext
                    )
                )
            }
        }
    }

    private companion object {
        const val ITEMS_KEY = "items"
    }
}