package and.degilevich.dream.shared.feature.common.component.navbar.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.NavbarItemButton
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider.NavbarItemUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun NavbarItemButtonDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        NavbarItemButton(
            data = NavbarItemUIDataPreviewProvider.provide()
        ) {}
    }
}

@Preview
@Composable
private fun NavbarItemButtonLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        NavbarItemButton(
            data = NavbarItemUIDataPreviewProvider.provide()
        ) {}
    }
}