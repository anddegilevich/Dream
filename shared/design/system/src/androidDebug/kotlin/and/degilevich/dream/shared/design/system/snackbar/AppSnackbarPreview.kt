package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.system.snackbar.provider.SnackbarDataPreviewProvider
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.material.SnackbarData
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun AppSnackbarPreview(
    @PreviewParameter(SnackbarDataPreviewProvider::class)
    data: SnackbarData
) {
    ComposeAppTheme {
        AppSnackbar(
            data = data
        )
    }
}