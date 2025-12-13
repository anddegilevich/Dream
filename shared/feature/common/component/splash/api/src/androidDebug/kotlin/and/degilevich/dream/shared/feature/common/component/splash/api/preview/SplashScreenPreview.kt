package and.degilevich.dream.shared.feature.common.component.splash.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.splash.api.design.SplashScreen
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun SplashScreenPreview() {
    ComposeAppTheme {
        SplashScreen()
    }
}