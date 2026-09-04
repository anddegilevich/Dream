package and.degilevich.dream.shared.feature.common.component.dashboard.impl.view

import and.degilevich.dream.shared.design.system.stub.ViewStub
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.view.semantic.DashboardScreenSemantic
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component.RecentlyPlayedComponent
import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponent
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewLazyChildItems
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems
import kotlin.test.Test

@OptIn(ExperimentalDecomposeApi::class, ExperimentalTestApi::class)
class DashboardScreenTest {

    private val item = hasTestTag(DashboardScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun `render default state - shows child items`() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                DashboardScreen(items = previewItems())
            }
        }
        onAllNodes(item)
            .onFirst()
            .assertIsDisplayed()
    }

    @Test
    fun `render default state - shows item per config`() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                DashboardScreen(items = previewItems())
            }
        }
        onAllNodes(item)
            .assertCountEquals(EXPECTED_ITEM_COUNT)
    }

    private fun previewItems(): LazyChildItems<DashboardItemConfig, DashboardItem> =
        PreviewLazyChildItems(
            items = mapOf<DashboardItemConfig, DashboardItem>(
                DashboardItemConfig.AlbumReleases to DashboardItem.AlbumReleases(
                    component = object : AlbumReleasesComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(stub = "AlbumReleasesComponent")
                        }
                    }
                ),
                DashboardItemConfig.PlaylistList to DashboardItem.PlaylistList(
                    component = object : PlaylistListComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(stub = "PlaylistListComponent")
                        }
                    }
                ),
                DashboardItemConfig.RecentlyPlayed to DashboardItem.RecentlyPlayed(
                    component = object : RecentlyPlayedComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(stub = "RecentlyPlayedComponent")
                        }
                    }
                )
            )
        )

    private companion object {
        const val EXPECTED_ITEM_COUNT = 3
    }
}
