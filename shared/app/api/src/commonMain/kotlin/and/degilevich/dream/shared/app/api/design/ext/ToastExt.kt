package and.degilevich.dream.shared.app.api.design.ext

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.ToastDurationData
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult

suspend fun SnackbarHostState.showToast(toast: ToastData) {
    val result = showSnackbar(
        message = toast.message,
        actionLabel = toast.action,
        duration = when (toast.duration) {
            ToastDurationData.SHORT -> SnackbarDuration.Short
            ToastDurationData.LONG -> SnackbarDuration.Long
            ToastDurationData.INDEFINITE -> SnackbarDuration.Indefinite
        }
    )
    when (result) {
        SnackbarResult.Dismissed -> toast.onDismiss()
        SnackbarResult.ActionPerformed -> toast.onAction?.invoke()
    }
}