package and.degilevich.dream.shared.feature.common.component.navbar.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.AppNavbar
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider.NavbarUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun AppNavbarDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        AppNavbar(
            state = NavbarUIStatePreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
private fun AppNavbarLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        AppNavbar(
            state = NavbarUIStatePreviewProvider.provide()
        ) { }
    }
}