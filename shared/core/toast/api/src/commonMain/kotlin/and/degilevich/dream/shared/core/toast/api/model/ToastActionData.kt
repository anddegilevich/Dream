package and.degilevich.dream.shared.core.toast.api.model

interface ToastActionData {
    val action: String?
    val onAction: (() -> Unit)?

    class Empty : ToastActionData {
        override val action: String? = null
        override val onAction: (() -> Unit)? = null
    }

    data class Base(
        override val action: String,
        override val onAction: (() -> Unit)
    ) : ToastActionData
}