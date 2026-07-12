package and.degilevich.dream.shared.feature.common.component.splash.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.splash.impl.view.semantic.SplashScreenSemantic
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.v2.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class SplashScreenTest {

    private val logo = hasTestTag(SplashScreenSemantic.TEST_TAG_LOGO)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                SplashScreen()
            }
        }

        onNode(logo)
            .assertExists()
            .assertIsDisplayed()
    }
}