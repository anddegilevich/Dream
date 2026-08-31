package and.degilevich.dream.shared.feature.auth.component.login.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.LoadingTextButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginIntent
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginUIState
import and.degilevich.dream.shared.feature.auth.component.login.impl.preview.LoginUIStatePreviewProvider
import and.degilevich.dream.shared.feature.auth.component.login.impl.view.semantic.LoginScreenSemantic
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun LoginScreen(
    state: LoginUIState,
    modifier: Modifier = Modifier,
    onIntent: (LoginIntent) -> Unit
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Icon(
            modifier = Modifier
                .testTag(LoginScreenSemantic.TEST_TAG_LOGO)
                .size(140.dp),
            painter = painterResource(Res.images.ic_duck),
            tint = Theme.colors.common.brand,
            contentDescription = null
        )
        Text(
            modifier = Modifier.testTag(LoginScreenSemantic.TEST_TAG_PROMPT),
            text = stringResource(Res.strings.label_login_prompt),
            style = Theme.typography.main,
            color = Theme.colors.text.primary,
            textAlign = TextAlign.Center
        )
        LoadingTextButton(
            modifier = Modifier.testTag(LoginScreenSemantic.TEST_TAG_LOGIN_BUTTON),
            text = stringResource(Res.strings.button_connect_spotify),
            isLoading = state.isLoadingLoginButton,
            isEnabled = state.isEnabledLoginButton
        ) {
            onIntent(LoginIntent.OnLoginClicked)
        }
    }
}

@LightDarkPreviews
@Composable
private fun LoginScreenPreview(
    @PreviewParameter(LoginUIStatePreviewProvider::class)
    state: LoginUIState
) = ComposeAppTheme {
    LoginScreen(
        state = state
    ) { }
}
