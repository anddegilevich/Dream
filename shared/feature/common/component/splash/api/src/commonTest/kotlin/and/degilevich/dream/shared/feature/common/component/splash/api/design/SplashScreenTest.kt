package and.degilevich.dream.shared.feature.common.component.splash.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.splash.api.design.semantic.SplashScreenSemantic
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

// FIXME: Fix compose tests later after moko-resources fully supports gradle 9
@OptIn(ExperimentalTestApi::class)
class SplashScreenTest {

    private val logo = hasTestTag(SplashScreenSemantic.TEST_TAG_LOGO)

    @Test
    fun myTest() = runComposeUiTest {
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