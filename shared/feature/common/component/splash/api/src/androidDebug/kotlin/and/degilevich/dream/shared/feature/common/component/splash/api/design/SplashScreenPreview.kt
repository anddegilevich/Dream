package and.degilevich.dream.shared.feature.common.component.splash.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SplashScreenDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SplashScreen()
    }
}
@Preview
@Composable
fun SplashScreenLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SplashScreen()
    }
}