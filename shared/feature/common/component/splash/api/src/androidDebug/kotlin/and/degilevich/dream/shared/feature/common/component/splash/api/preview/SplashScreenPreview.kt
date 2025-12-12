package and.degilevich.dream.shared.feature.common.component.splash.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.splash.api.design.SplashScreen
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun SplashScreenPreview() {
    ComposeAppTheme {
        SplashScreen()
    }
}