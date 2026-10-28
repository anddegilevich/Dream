package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerIntent
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerUIState
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.preview.MiniPlayerUIStatePreviewProvider
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.view.semantic.MiniPlayerViewSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class MiniPlayerViewTest {

    private val provider = MiniPlayerUIStatePreviewProvider()

    private val content = hasTestTag(MiniPlayerViewSemantic.TEST_TAG_CONTENT)
    private val shuffle = hasTestTag(MiniPlayerViewSemantic.TEST_TAG_SHUFFLE)
    private val skipToPrevious = hasTestTag(MiniPlayerViewSemantic.TEST_TAG_SKIP_TO_PREVIOUS)
    private val skipToNext = hasTestTag(MiniPlayerViewSemantic.TEST_TAG_SKIP_TO_NEXT)

    @Test
    fun `render default state - shows track and controls`() = runComposeUiTest {
        val intents = mutableListOf<MiniPlayerIntent>()
        val state = provider.provideDefault()
        setContent(
            state = state,
            onIntent = intents::add
        )

        onNode(content).assertIsDisplayed()
        onNode(hasText(state.track.name)).assertIsDisplayed()
        onNode(hasText(state.track.artists)).assertIsDisplayed()
        onNode(shuffle).assertIsDisplayed()
        onNode(skipToPrevious).assertIsDisplayed()
        onNode(skipToNext).assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render shuffling state - shows content and controls`() = runComposeUiTest {
        setContent(state = provider.provideShuffling())

        onNode(content).assertIsDisplayed()
        onNode(shuffle).assertIsDisplayed()
    }

    @Test
    fun `render long names state - keeps controls visible`() = runComposeUiTest {
        setContent(state = provider.provideLongNames())

        onNode(content).assertIsDisplayed()
        onNode(skipToNext).assertIsDisplayed()
    }

    @Test
    fun `click bar - emits OnClicked`() = runComposeUiTest {
        val intents = mutableListOf<MiniPlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(content).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(MiniPlayerIntent.OnViewClicked)
    }

    @Test
    fun `click skip to previous - emits OnSkipToPreviousClicked`() = runComposeUiTest {
        val intents = mutableListOf<MiniPlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(skipToPrevious).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(MiniPlayerIntent.OnSkipToPreviousClicked)
    }

    @Test
    fun `click skip to next - emits OnSkipToNextClicked`() = runComposeUiTest {
        val intents = mutableListOf<MiniPlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(skipToNext).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(MiniPlayerIntent.OnSkipToNextClicked)
    }

    @Test
    fun `click shuffle - emits OnShuffleClicked`() = runComposeUiTest {
        val intents = mutableListOf<MiniPlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(shuffle).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(MiniPlayerIntent.OnShuffleClicked)
    }

    private fun ComposeUiTest.setContent(
        state: MiniPlayerUIState,
        onIntent: (MiniPlayerIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            MiniPlayerView(
                state = state,
                onIntent = onIntent
            )
        }
    }
}
