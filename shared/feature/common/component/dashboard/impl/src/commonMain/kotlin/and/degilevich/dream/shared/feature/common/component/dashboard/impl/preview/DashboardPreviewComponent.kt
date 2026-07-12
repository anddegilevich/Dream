package and.degilevich.dream.shared.feature.common.component.dashboard.impl.preview

import and.degilevich.dream.shared.feature.album.component.releases.impl.preview.AlbumReleasesPreviewComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.view.DashboardScreen
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewComponentContext
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewLazyChildItems
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems

@OptIn(ExperimentalDecomposeApi::class)
class DashboardPreviewComponent :
    DashboardComponent,
    ComponentContext by PreviewComponentContext() {

    private val items: LazyChildItems<DashboardItemConfig, DashboardItem> = PreviewLazyChildItems(
        items = configs.associateWith { config ->
            when (config) {
                is DashboardItemConfig.AlbumReleases -> DashboardItem.AlbumReleases(
                    component = AlbumReleasesPreviewComponent()
                )
            }
        }
    )

    @Composable
    override fun Render() {
        DashboardScreen(items = items)
    }

    private companion object {
        private val configs = listOf(
            DashboardItemConfig.AlbumReleases
        )
    }
}
