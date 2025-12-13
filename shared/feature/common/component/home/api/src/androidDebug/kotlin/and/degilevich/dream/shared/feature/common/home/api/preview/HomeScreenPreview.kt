package and.degilevich.dream.shared.feature.common.home.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.home.api.design.HomeScreen
import and.degilevich.dream.shared.feature.common.home.api.preview.component.HomePreviewComponent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    ComposeAppTheme {
        HomeScreen(
            component = HomePreviewComponent()
        )
    }
}