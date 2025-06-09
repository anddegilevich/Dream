package and.degilevich.dream.shared.design.system.snackbar.provider

import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration

object SnackbarDataPreviewProvider {
    fun provide(): SnackbarData {
        return object : SnackbarData {
            override val actionLabel: String = "Action"
            override val duration: SnackbarDuration = SnackbarDuration.Short
            override val message: String = "Message"

            override fun dismiss() = Unit
            override fun performAction() = Unit
        }
    }
}