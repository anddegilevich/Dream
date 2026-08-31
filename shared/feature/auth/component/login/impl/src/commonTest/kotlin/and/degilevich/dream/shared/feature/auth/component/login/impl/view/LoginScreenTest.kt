package and.degilevich.dream.shared.feature.auth.component.login.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginIntent
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginUIState
import and.degilevich.dream.shared.feature.auth.component.login.impl.preview.LoginUIStatePreviewProvider
import and.degilevich.dream.shared.feature.auth.component.login.impl.view.semantic.LoginScreenSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class LoginScreenTest {

    private val logo = hasTestTag(LoginScreenSemantic.TEST_TAG_LOGO)
    private val prompt = hasTestTag(LoginScreenSemantic.TEST_TAG_PROMPT)
    private val loginButton = hasTestTag(LoginScreenSemantic.TEST_TAG_LOGIN_BUTTON)

    @Test
    fun `render default state - shows the logo and prompt with an enabled login button`() = runComposeUiTest {
        val intents = mutableListOf<LoginIntent>()

        setLoginScreen(
            state = LoginUIStatePreviewProvider().provideDefault(),
            onIntent = intents::add
        )

        onNode(logo).assertExists().assertIsDisplayed()
        onNode(prompt).assertExists().assertIsDisplayed()
        onNode(loginButton).assertExists().assertIsDisplayed().assertIsEnabled()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render loading state - keeps the login button on screen but disables it`() = runComposeUiTest {
        val intents = mutableListOf<LoginIntent>()

        setLoginScreen(
            state = LoginUIStatePreviewProvider().provideLoading(),
            onIntent = intents::add
        )

        onNode(loginButton).assertExists().assertIsDisplayed().assertIsNotEnabled()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click the login button - emits OnLoginClicked exactly once`() = runComposeUiTest {
        val intents = mutableListOf<LoginIntent>()

        setLoginScreen(
            state = LoginUIStatePreviewProvider().provideDefault(),
            onIntent = intents::add
        )

        onNode(loginButton).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }

        intents shouldContainExactly listOf(LoginIntent.OnLoginClicked)
    }

    @Test
    fun `click the login button while loading - emits nothing`() = runComposeUiTest {
        val intents = mutableListOf<LoginIntent>()

        setLoginScreen(
            state = LoginUIStatePreviewProvider().provideLoading(),
            onIntent = intents::add
        )

        onNode(loginButton).performClick()
        waitForIdle()

        intents.shouldBeEmpty()
    }

    private fun ComposeUiTest.setLoginScreen(
        state: LoginUIState,
        onIntent: (LoginIntent) -> Unit = {}
    ) {
        setContent {
            ComposeAppTheme {
                LoginScreen(
                    state = state,
                    onIntent = onIntent
                )
            }
        }
    }
}
