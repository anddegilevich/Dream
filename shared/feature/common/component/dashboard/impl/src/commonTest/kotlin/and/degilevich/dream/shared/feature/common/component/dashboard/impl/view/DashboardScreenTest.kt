package and.degilevich.dream.shared.feature.common.component.dashboard.impl.view

import and.degilevich.dream.shared.design.system.stub.ViewStub
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.view.semantic.DashboardScreenSemantic
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewLazyChildItems
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import com.arkivanov.decompose.ExperimentalDecomposeApi
import kotlin.test.Test

@OptIn(ExperimentalDecomposeApi::class, ExperimentalTestApi::class)
class DashboardScreenTest {

    private val item = hasTestTag(DashboardScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                DashboardScreen(
                    items = PreviewLazyChildItems(
                        items = mapOf(
                            DashboardItemConfig.AlbumReleases to DashboardItem.AlbumReleases(
                                component = object : AlbumReleasesComponent {
                                    @Composable
                                    override fun Render() {
                                        ViewStub(stub = "AlbumReleasesComponent")
                                    }
                                }
                            )
                        )
                    )
                )
            }
        }
        onAllNodes(item)
            .onFirst()
            .assertIsDisplayed()
    }
}
