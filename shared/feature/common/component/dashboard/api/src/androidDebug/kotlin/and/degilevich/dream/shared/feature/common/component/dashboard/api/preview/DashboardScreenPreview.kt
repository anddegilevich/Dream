package and.degilevich.dream.shared.feature.common.component.dashboard.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.design.DashboardScreen
import and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.component.DashboardPreviewComponent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun DashboardScreenDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        DashboardScreen(
            component = DashboardPreviewComponent()
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
            component = DashboardPreviewComponent()
        )
    }
}