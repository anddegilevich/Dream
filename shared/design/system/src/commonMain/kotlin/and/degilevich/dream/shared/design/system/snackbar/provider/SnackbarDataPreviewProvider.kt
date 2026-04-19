package and.degilevich.dream.shared.design.system.snackbar.provider

import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration

class SnackbarDataPreviewProvider : LabeledPreviewParameterProvider<SnackbarData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): SnackbarData {
        return object : SnackbarData {
            override val actionLabel: String = "Action"
            override val duration: SnackbarDuration = SnackbarDuration.Short
            override val message: String = "Message"

            override fun dismiss() = Unit
            override fun performAction() = Unit
        }
    }
}