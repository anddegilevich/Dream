package and.degilevich.dream.shared.core.toast.impl.model.builder

import and.degilevich.dream.shared.core.toast.api.model.ToastActionData
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.ToastDurationData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope

internal class ToastBuilder : ToastBuilderScope {

    private var message: String = ""
    private var actionData: ToastActionData = ToastActionData.Empty()
    private var onDismiss: () -> Unit = {}
    private var duration: ToastDurationData = ToastDurationData.SHORT

    override fun setMessage(message: String) {
        this.message = message
    }

    override fun setAction(
        action: String,
        onAction: () -> Unit
    ) {
        this.actionData = ToastActionData.Base(
            action = action,
            onAction = onAction
        )
    }

    override fun setAction(actionData: ToastActionData) {
        this.actionData = actionData
    }

    override fun setOnDismiss(onDismiss: () -> Unit) {
        this.onDismiss = onDismiss
    }

    override fun setDuration(duration: ToastDurationData) {
        this.duration = duration
    }

    fun build(): ToastData {
        return ToastData.Base(
            actionData = actionData,
            message = message,
            onDismiss = onDismiss,
            duration = duration
        )
    }
}