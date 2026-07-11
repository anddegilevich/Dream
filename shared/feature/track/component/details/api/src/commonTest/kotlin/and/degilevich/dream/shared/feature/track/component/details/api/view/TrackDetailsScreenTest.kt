package and.degilevich.dream.shared.feature.track.component.details.api.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.api.view.semantic.TrackDetailsScreenSemantic
import and.degilevich.dream.shared.feature.track.component.details.api.provider.TrackDetailsUIStatePreviewProvider
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.v2.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TrackDetailsScreenTest {

    private val provider = TrackDetailsUIStatePreviewProvider()

    private val infoSkeleton = hasTestTag(TrackDetailsScreenSemantic.TEST_TAG_INFO_SKELETON)
    private val info = hasTestTag(TrackDetailsScreenSemantic.TEST_TAG_INFO)

    @Test
    fun testSkeletonState() = runComposeUiTest {
        setContent(provider.provideSkeleton())
        onNode(infoSkeleton)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent(provider.provideDefault())
        onNode(info)
            .assertExists()
            .assertIsDisplayed()
    }

    private fun ComposeUiTest.setContent(state: TrackDetailsUIState) = setContent {
        ComposeAppTheme {
            TrackDetailsScreen(state = state) {}
        }
    }
}
