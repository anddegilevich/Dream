package and.degilevich.dream.shared.core.toast.impl.factory

import and.degilevich.dream.shared.resource.api.ResourceManager
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.core.toast.api.model.ToastActionData
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.ToastDurationData
import and.degilevich.dream.Res
import dev.icerock.moko.resources.StringResource

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

    override fun createMessageToast(resource: StringResource): ToastData {
        return createMessageToast(
            message = resourceManager.getString(resource)
        )
    }

    override fun createMessageToast(error: Throwable): ToastData {
        return createMessageToast(
            message = mapErrorToMessage(error)
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

    override fun createRepeatToast(
        error: Throwable,
        onRepeat: () -> Unit
    ): ToastData {
        return createRepeatToast(
            message = mapErrorToMessage(error),
            onRepeat = onRepeat
        )
    }

    private fun mapErrorToMessage(error: Throwable): String {
        return error.message ?: resourceManager.getString(Res.strings.error)
    }
}
