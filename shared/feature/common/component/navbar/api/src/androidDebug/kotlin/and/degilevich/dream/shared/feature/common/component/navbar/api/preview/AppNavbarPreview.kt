package and.degilevich.dream.shared.feature.common.component.navbar.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.AppNavbar
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider.NavbarUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun AppNavbarPreview() {
    ComposeAppTheme {
        AppNavbar(
            state = NavbarUIStatePreviewProvider.provide()
        ) { }
    }
}