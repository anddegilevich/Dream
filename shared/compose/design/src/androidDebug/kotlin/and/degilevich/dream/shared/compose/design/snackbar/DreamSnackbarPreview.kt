package and.degilevich.dream.shared.compose.design.snackbar

import and.degilevich.dream.shared.compose.theme.api.DreamTheme
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun DreamSnackbarPreview() {
    DreamTheme {
        DreamSnackbar(
            data = object : SnackbarData {
                override val actionLabel: String = "Action"
                override val duration: SnackbarDuration = SnackbarDuration.Short
                override val message: String = "Message"

                override fun dismiss() = Unit
                override fun performAction() = Unit
            }
        )
    }
}