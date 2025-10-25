package and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.component

import and.degilevich.dream.shared.feature.album.component.releases.api.preview.component.AlbumReleasesPreviewComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.children.DashboardSection
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardSectionConfig
import and.degilevich.dream.shared.foundation.decompose.preview.PreviewComponentContext
import and.degilevich.dream.shared.foundation.decompose.preview.PreviewLazyChildItems
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems

@OptIn(ExperimentalDecomposeApi::class)
class DashboardPreviewComponent :
    DashboardComponent,
    ComponentContext by PreviewComponentContext() {

    override val sections: LazyChildItems<DashboardSectionConfig, DashboardSection> = PreviewLazyChildItems(
        items = configs.associateWith { config ->
            when (config) {
                DashboardSectionConfig.AlbumReleases -> {
                    DashboardSection.AlbumReleases(
                        component = AlbumReleasesPreviewComponent()
                    )
                }
            }
        }
    )

    private companion object {
        private val configs = listOf(
            DashboardSectionConfig.AlbumReleases
        )
    }
}