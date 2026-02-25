package and.degilevich.dream.shared.feature.common.component.dashboard.api.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesPreviewComponent
import and.degilevich.dream.shared.feature.category.component.list.api.component.CategoryListPreviewComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardItemConfig
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewComponentContext
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewLazyChildItems
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
                is DashboardItemConfig.AlbumReleases -> DashboardItem.AlbumReleases(
                    component = AlbumReleasesPreviewComponent()
                )

                is DashboardItemConfig.CategoryList -> DashboardItem.CategoryList(
                    component = CategoryListPreviewComponent()
                )
            }
        }
    )

    private companion object {
        private val configs = listOf(
            DashboardItemConfig.AlbumReleases
        )
    }
}