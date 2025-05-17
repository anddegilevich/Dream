package and.degilevich.dream.shared.feature.user.component.profile.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import and.degilevich.dream.shared.feature.user.component.profile.api.design.ProfileScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ProfileScreenDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        ProfileScreen(
            state = ProfileUIState.empty(),
            onIntent = { }
        )
    }
}

@Preview
@Composable
private fun ProfileScreenLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        ProfileScreen(
            state = ProfileUIState.empty(),
            onIntent = { }
        )
    }
}