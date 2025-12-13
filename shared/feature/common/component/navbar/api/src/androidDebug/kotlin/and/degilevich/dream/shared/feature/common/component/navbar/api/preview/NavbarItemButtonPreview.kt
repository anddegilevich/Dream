package and.degilevich.dream.shared.feature.common.component.navbar.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.NavbarItemButton
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider.NavbarItemUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun NavbarItemButtonPreview() {
    ComposeAppTheme {
        NavbarItemButton(
            modifier = Modifier.themeBackground(),
            data = NavbarItemUIDataPreviewProvider.provide()
        ) {}
    }
}