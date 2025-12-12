package and.degilevich.dream.shared.feature.common.component.navbar.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.NavbarItemButton
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider.NavbarItemUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun NavbarItemButtonPreview() {
    ComposeAppTheme {
        NavbarItemButton(
            modifier = Modifier.themeBackground(),
            data = NavbarItemUIDataPreviewProvider.provide()
        ) {}
    }
}