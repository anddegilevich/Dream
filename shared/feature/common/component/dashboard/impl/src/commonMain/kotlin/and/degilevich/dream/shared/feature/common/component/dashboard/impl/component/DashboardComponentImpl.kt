package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.view.DashboardScreen
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.Items
import com.arkivanov.decompose.router.items.ItemsNavigation
import com.arkivanov.decompose.router.items.LazyChildItems
import com.arkivanov.decompose.router.items.childItems
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalDecomposeApi::class)
internal class DashboardComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(
    componentContext = componentContext
),
    DashboardComponent,
    KoinComponent {

    private val itemsNavigation = ItemsNavigation<DashboardItemConfig>()

    private val items: LazyChildItems<DashboardItemConfig, DashboardItem> = childItems(
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

    @Composable
    override fun Render() {
        DashboardScreen(items = items)
    }

    private fun itemFactory(
        config: DashboardItemConfig,
        componentContext: ComponentContext
    ): DashboardItem {
        return when (config) {
            is DashboardItemConfig.AlbumReleases -> {
                DashboardItem.AlbumReleases(
                    component = get<AlbumReleasesComponent> { parametersOf(componentContext) }
                )
            }
        }
    }

    private companion object {
        const val ITEMS_KEY = "items"
    }
}