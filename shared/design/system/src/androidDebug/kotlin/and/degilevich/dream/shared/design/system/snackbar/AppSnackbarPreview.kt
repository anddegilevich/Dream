package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.system.snackbar.provider.SnackbarDataPreviewProvider
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun AppSnackbarPreview() {
    ComposeAppTheme {
        AppSnackbar(
            data = SnackbarDataPreviewProvider.provide()
        )
    }
}