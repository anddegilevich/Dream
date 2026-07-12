package and.degilevich.dream.shared.feature.album.component.releases.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.preview.AlbumReleasesUIStatePreviewProvider
import and.degilevich.dream.shared.feature.album.component.releases.impl.view.semantic.AlbumReleasesCarouselSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AlbumReleasesCarouselTest {

    private val provider = AlbumReleasesUIStatePreviewProvider()

    private val title = hasTestTag(AlbumReleasesCarouselSemantic.TEST_TAG_TITLE)
    private val skeletonItem = hasTestTag(AlbumReleasesCarouselSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(AlbumReleasesCarouselSemantic.TEST_TAG_ITEM)

    @Test
    fun testSkeletonState() = runComposeUiTest {
        setContent(provider.provideSkeleton())
        checkTitle()
        onAllNodes(skeletonItem)
            .onFirst()
            .assertIsDisplayed()
    }

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent(provider.provideDefault())
        checkTitle()
        onAllNodes(item)
            .onFirst()
            .assertIsDisplayed()
    }

    private fun ComposeUiTest.setContent(state: AlbumReleasesUIState) = setContent {
        ComposeAppTheme {
            AlbumReleasesCarousel(state = state) {}
        }
    }

    private fun ComposeUiTest.checkTitle() {
        onNode(title)
            .assertExists()
            .assertIsDisplayed()
    }
}
