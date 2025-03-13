package and.degilevich.dream.shared.feature.user.component.profile.api.design

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ProfileScreenDarkPreview() {
    DreamTheme(isDarkMode = true) {
        ProfileScreen(
            state = ProfileUIState(),
            onIntent = { }
        )
    }
}

@Preview
@Composable
private fun ProfileScreenLightPreview() {
    DreamTheme(isDarkMode = false) {
        ProfileScreen(
            state = ProfileUIState(),
            onIntent = { }
        )
    }
}