package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun DreamSnackbarDarkPreview() {
    DreamTheme(
        isDarkMode = true
    ) {
        DreamSnackbar(
            data = providePreviewSnackbarData()
        )
    }
}

@Preview
@Composable
private fun DreamSnackbarLightPreview() {
    DreamTheme(
        isDarkMode = false
    ) {
        DreamSnackbar(
            data = providePreviewSnackbarData()
        )
    }
}

private fun providePreviewSnackbarData(): SnackbarData {
    return object : SnackbarData {
        override val actionLabel: String = "Action"
        override val duration: SnackbarDuration = SnackbarDuration.Short
        override val message: String = "Message"

        override fun dismiss() = Unit
        override fun performAction() = Unit
    }
}