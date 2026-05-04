package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.api.design.semantic.ArtistDetailsScreenSemantic
import and.degilevich.dream.shared.feature.artist.component.details.api.provider.ArtistDetailsUIStatePreviewProvider
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ArtistDetailsScreenTest {

    private val provider = ArtistDetailsUIStatePreviewProvider()

    private val infoSkeleton = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_INFO_SKELETON)
    private val info = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_INFO)
    private val itemSkeleton = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_ITEM)

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
        onNode(info)
            .assertExists()
            .assertIsDisplayed()
        onAllNodes(item)
            .onFirst()
            .assertIsDisplayed()
    }

    private fun ComposeUiTest.setContent(state: ArtistDetailsUIState) = setContent {
        ComposeAppTheme {
            ArtistDetailsScreen(state = state) {}
        }
    }
}
