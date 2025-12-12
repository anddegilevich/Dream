package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.system.snackbar.provider.SnackbarDataPreviewProvider
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun AppSnackbarPreview() {
    ComposeAppTheme {
        AppSnackbar(
            data = SnackbarDataPreviewProvider.provide()
        )
    }
}