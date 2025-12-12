package and.degilevich.dream.shared.feature.common.component.dashboard.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.design.DashboardScreen
import and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.component.DashboardPreviewComponent
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun DashboardScreenPreview() {
    ComposeAppTheme {
        DashboardScreen(
            component = DashboardPreviewComponent()
        )
    }
}