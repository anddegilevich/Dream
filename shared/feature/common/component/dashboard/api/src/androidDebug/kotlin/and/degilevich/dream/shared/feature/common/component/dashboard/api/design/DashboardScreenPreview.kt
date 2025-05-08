package and.degilevich.dream.shared.feature.common.component.dashboard.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun DashboardScreenDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        DashboardScreen(
            state = provideDashboardUIState(),
            onIntent = { }
        )
    }
}

@Preview
@Composable
private fun DashboardScreenLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        DashboardScreen(
            state = provideDashboardUIState(),
            onIntent = { }
        )
    }
}

private fun provideDashboardUIState(): DashboardUIState {
    return DashboardUIState()
}