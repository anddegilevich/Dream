package and.degilevich.dream.shared.feature.track.component.details.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.impl.preview.TrackDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.feature.track.component.details.impl.view.semantic.TrackDetailsScreenSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TrackDetailsScreenTest {

    private val provider = TrackDetailsUIStatePreviewProvider()

    private val back = hasTestTag(TrackDetailsScreenSemantic.TEST_TAG_BACK)
    private val infoSkeleton = hasTestTag(TrackDetailsScreenSemantic.TEST_TAG_INFO_SKELETON)
    private val info = hasTestTag(TrackDetailsScreenSemantic.TEST_TAG_INFO)

    @Test
    fun `render skeleton state - shows info skeleton`() = runComposeUiTest {
        val intents = mutableListOf<TrackDetailsIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )
        onNode(infoSkeleton).assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows info`() = runComposeUiTest {
        val intents = mutableListOf<TrackDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(info).assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click back - emits OnBackClicked`() = runComposeUiTest {
        val intents = mutableListOf<TrackDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(back).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(TrackDetailsIntent.OnBackClicked)
    }

    private fun ComposeUiTest.setContent(
        state: TrackDetailsUIState,
        onIntent: (TrackDetailsIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            TrackDetailsScreen(
                state = state,
                onIntent = onIntent
            )
        }
    }
}
