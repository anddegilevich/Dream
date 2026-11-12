package and.degilevich.dream.shared.feature.player.component.player.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerIntent
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerUIState
import and.degilevich.dream.shared.feature.player.component.player.impl.preview.PlayerUIStatePreviewProvider
import and.degilevich.dream.shared.feature.player.component.player.impl.view.semantic.PlayerScreenSemantic
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
class PlayerScreenTest {

    private val provider = PlayerUIStatePreviewProvider()

    private val back = hasTestTag(PlayerScreenSemantic.TEST_TAG_BACK)
    private val cover = hasTestTag(PlayerScreenSemantic.TEST_TAG_COVER)
    private val progress = hasTestTag(PlayerScreenSemantic.TEST_TAG_PROGRESS)
    private val shuffle = hasTestTag(PlayerScreenSemantic.TEST_TAG_SHUFFLE)
    private val skipToPrevious = hasTestTag(PlayerScreenSemantic.TEST_TAG_SKIP_TO_PREVIOUS)
    private val skipToNext = hasTestTag(PlayerScreenSemantic.TEST_TAG_SKIP_TO_NEXT)
    private val play = hasTestTag(PlayerScreenSemantic.TEST_TAG_PLAY)

    @Test
    fun `render default state - shows track progress and controls`() = runComposeUiTest {
        val intents = mutableListOf<PlayerIntent>()
        val state = provider.provideDefault()
        setContent(
            state = state,
            onIntent = intents::add
        )

        onNode(back).assertIsDisplayed()
        onNode(cover).assertIsDisplayed()
        onNode(hasText(state.track.name)).assertIsDisplayed()
        onNode(hasText(state.track.artists)).assertIsDisplayed()
        onNode(progress).assertIsDisplayed()
        onNode(hasText(state.progress.elapsed)).assertIsDisplayed()
        onNode(hasText(state.progress.remaining)).assertIsDisplayed()
        onNode(shuffle).assertIsDisplayed()
        onNode(skipToPrevious).assertIsDisplayed()
        onNode(skipToNext).assertIsDisplayed()
        onNode(play).assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render shuffling state - shows shuffle control`() = runComposeUiTest {
        setContent(state = provider.provideShuffling())

        onNode(shuffle).assertIsDisplayed()
    }

    @Test
    fun `render long names state - keeps controls visible`() = runComposeUiTest {
        setContent(state = provider.provideLongNames())

        onNode(progress).assertIsDisplayed()
        onNode(skipToNext).assertIsDisplayed()
    }

    @Test
    fun `click back - emits OnBackClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(back).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(PlayerIntent.OnBackClicked)
    }

    @Test
    fun `click skip to previous - emits OnSkipToPreviousClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(skipToPrevious).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(PlayerIntent.OnSkipToPreviousClicked)
    }

    @Test
    fun `click skip to next - emits OnSkipToNextClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(skipToNext).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(PlayerIntent.OnSkipToNextClicked)
    }

    @Test
    fun `click shuffle - emits OnShuffleClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(shuffle).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(PlayerIntent.OnShuffleClicked)
    }

    @Test
    fun `render playing state - shows play control`() = runComposeUiTest {
        setContent(state = provider.providePlaying())

        onNode(play).assertIsDisplayed()
    }

    @Test
    fun `click play - emits OnPlayClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlayerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(play).performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(PlayerIntent.OnPlayClicked)
    }

    private fun ComposeUiTest.setContent(
        state: PlayerUIState,
        onIntent: (PlayerIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            PlayerScreen(
                state = state,
                onIntent = onIntent
            )
        }
    }
}
