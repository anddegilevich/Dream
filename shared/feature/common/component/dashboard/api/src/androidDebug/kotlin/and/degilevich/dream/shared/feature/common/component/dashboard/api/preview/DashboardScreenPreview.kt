package and.degilevich.dream.shared.feature.common.component.dashboard.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.design.DashboardScreen
import and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.component.DashboardPreviewComponent
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun DashboardScreenPreview() {
    ComposeAppTheme {
        DashboardScreen(
            component = DashboardPreviewComponent()
        )
    }
}