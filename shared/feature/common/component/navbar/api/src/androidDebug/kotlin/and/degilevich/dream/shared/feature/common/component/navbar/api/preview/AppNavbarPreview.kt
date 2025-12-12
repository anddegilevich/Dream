package and.degilevich.dream.shared.feature.common.component.navbar.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.AppNavbar
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider.NavbarUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun AppNavbarPreview() {
    ComposeAppTheme {
        AppNavbar(
            state = NavbarUIStatePreviewProvider.provide()
        ) { }
    }
}