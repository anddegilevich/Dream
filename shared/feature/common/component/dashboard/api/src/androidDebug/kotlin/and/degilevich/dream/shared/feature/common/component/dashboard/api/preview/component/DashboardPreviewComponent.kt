package and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.component

import and.degilevich.dream.shared.feature.album.component.releases.api.preview.component.AlbumReleasesPreviewComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardItemConfig
import and.degilevich.dream.shared.foundation.decompose.preview.PreviewComponentContext
import and.degilevich.dream.shared.foundation.decompose.preview.PreviewLazyChildItems
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems

@OptIn(ExperimentalDecomposeApi::class)
class DashboardPreviewComponent :
    DashboardComponent,
    ComponentContext by PreviewComponentContext() {

    override val items: LazyChildItems<DashboardItemConfig, DashboardItem> = PreviewLazyChildItems(
        items = configs.associateWith { config ->
            when (config) {
                DashboardItemConfig.AlbumReleases -> {
                    DashboardItem.AlbumReleases(
                        component = AlbumReleasesPreviewComponent()
                    )
                }
            }
        }
    )

    private companion object {
        private val configs = listOf(
            DashboardItemConfig.AlbumReleases
        )
    }
}