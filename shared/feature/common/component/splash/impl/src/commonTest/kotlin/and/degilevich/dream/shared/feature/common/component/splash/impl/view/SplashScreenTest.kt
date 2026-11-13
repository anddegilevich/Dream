package and.degilevich.dream.shared.feature.common.component.splash.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.impl.view.semantic.SplashScreenSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class SplashScreenTest {

    private val logo = hasTestTag(SplashScreenSemantic.TEST_TAG_LOGO)
    private val attribution = hasTestTag(SplashScreenSemantic.TEST_TAG_ATTRIBUTION)

    @Test
    fun `intro - starts with the logo alone then reveals the Spotify attribution`() = runComposeUiTest {
        mainClock.autoAdvance = false

        setSplashScreen(onIntent = {})

        onNode(logo).assertExists().assertIsDisplayed()
        onNode(attribution).assertDoesNotExist()

        mainClock.advanceTimeBy(milliseconds = INTRO_FINISHED_MS)

        onNode(logo).assertExists().assertIsDisplayed()
        onNode(attribution).assertExists().assertIsDisplayed()
    }

    @Test
    fun `intro - emits nothing while running then OnIntroFinished exactly once`() = runComposeUiTest {
        mainClock.autoAdvance = false
        val intents = mutableListOf<SplashIntent>()

        setSplashScreen(onIntent = intents::add)
        mainClock.advanceTimeBy(milliseconds = INTRO_RUNNING_MS)

        intents.shouldBeEmpty()

        mainClock.advanceTimeBy(milliseconds = INTRO_FINISHED_MS - INTRO_RUNNING_MS)

        intents shouldContainExactly listOf(SplashIntent.OnIntroFinished)
    }

    private fun ComposeUiTest.setSplashScreen(onIntent: (SplashIntent) -> Unit) {
        setContent {
            ComposeAppTheme {
                SplashScreen(onIntent = onIntent)
            }
        }
    }

    private companion object {
        const val INTRO_RUNNING_MS = 1_000L
        const val INTRO_FINISHED_MS = 2_000L
    }
}
