package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.impl.component.AlbumReleasesComponentImpl
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.children.DashboardSection
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardSectionConfig
import and.degilevich.dream.shared.template.component.impl.BaseComponent
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

    private val sectionsNavigation = ItemsNavigation<DashboardSectionConfig>()

    override val sections: LazyChildItems<DashboardSectionConfig, DashboardSection> = childItems(
        source = sectionsNavigation,
        serializer = DashboardSectionConfig.serializer(),
        initialItems = {
            Items(
                items = listOf(DashboardSectionConfig.AlbumReleases)
            )
        },
        childFactory = ::sectionFactory
    )

    private fun sectionFactory(
        config: DashboardSectionConfig,
        componentContext: ComponentContext
    ): DashboardSection {
        return when (config) {
            DashboardSectionConfig.AlbumReleases -> {
                DashboardSection.AlbumReleases(
                    component = AlbumReleasesComponentImpl(
                        componentContext = componentContext
                    )
                )
            }
        }
    }
}