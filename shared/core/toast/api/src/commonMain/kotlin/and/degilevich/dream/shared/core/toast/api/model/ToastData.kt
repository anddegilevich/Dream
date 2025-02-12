package and.degilevich.dream.shared.core.toast.api.model

interface ToastData : ToastActionData {
    val message: String
    val onDismiss: () -> Unit
    val duration: ToastDurationData

    data class Base(
        override val message: String,
        override val onDismiss: () -> Unit,
        val actionData: ToastActionData,
        override val duration: ToastDurationData
    ) : ToastData, ToastActionData by actionData
}