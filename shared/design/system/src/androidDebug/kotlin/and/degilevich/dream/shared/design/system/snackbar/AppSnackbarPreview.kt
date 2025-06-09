package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.system.snackbar.provider.SnackbarDataPreviewProvider
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun AppSnackbarDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AppSnackbar(
            data = SnackbarDataPreviewProvider.provide()
        )
    }
}

@Preview
@Composable
private fun AppSnackbarLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AppSnackbar(
            data = SnackbarDataPreviewProvider.provide()
        )
    }
}