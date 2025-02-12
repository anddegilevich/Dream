package and.degilevich.dream.shared.core.toast.api.model.builder

import and.degilevich.dream.shared.core.toast.api.model.ToastActionData
import and.degilevich.dream.shared.core.toast.api.model.ToastDurationData

interface ToastBuilderScope {
    fun setMessage(message: String)
    fun setAction(action: String, onAction: () -> Unit)
    fun setAction(actionData: ToastActionData)
    fun setOnDismiss(onDismiss: () -> Unit)
    fun setDuration(duration: ToastDurationData)
}