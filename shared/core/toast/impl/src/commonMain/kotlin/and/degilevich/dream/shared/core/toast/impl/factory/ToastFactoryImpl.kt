package and.degilevich.dream.shared.core.toast.impl.factory

import and.degilevich.dream.shared.core.resource.api.ResourceManager
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.core.toast.api.model.ToastActionData
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.ToastDurationData
import and.degilevich.dream.Res

internal class ToastFactoryImpl(
    private val resourceManager: ResourceManager
) : ToastFactory {

    override fun createMessageToast(message: String): ToastData {
        return ToastData.Base(
            message = message,
            onDismiss = {},
            actionData = ToastActionData.Empty(),
            duration = ToastDurationData.SHORT
        )
    }

    override fun createRepeatToast(
        message: String,
        onRepeat: () -> Unit
    ): ToastData {
        return ToastData.Base(
            message = message,
            onDismiss = {},
            actionData = ToastActionData.Base(
                action = resourceManager.getString(Res.strings.button_repeat),
                onAction = onRepeat
            ),
            duration = ToastDurationData.LONG
        )
    }
}
