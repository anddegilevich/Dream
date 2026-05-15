package and.degilevich.dream.shared.feature.album.component.details.api.ui

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.api.ui.semantic.AlbumDetailsScreenSemantic
import and.degilevich.dream.shared.feature.album.component.details.api.provider.AlbumDetailsUIStatePreviewProvider
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AlbumDetailsScreenTest {

    private val provider = AlbumDetailsUIStatePreviewProvider()

    private val infoSkeleton = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_INFO_SKELETON)
    private val info = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_INFO)
    private val itemSkeleton = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun testSkeletonState() = runComposeUiTest {
        setContent(provider.provideSkeleton())
        onNode(infoSkeleton)
            .assertExists()
            .assertIsDisplayed()
        onAllNodes(itemSkeleton)
            .onFirst()
            .assertIsDisplayed()
    }

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent(provider.provideDefault())
        onNode(info).assertExists().assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
    }

    private fun ComposeUiTest.setContent(state: AlbumDetailsUIState) = setContent {
        ComposeAppTheme {
            AlbumDetailsScreen(state = state) {}
        }
    }
}
