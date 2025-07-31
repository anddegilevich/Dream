package and.degilevich.dream.shared.core.toast.impl.controller

import and.degilevich.dream.shared.core.toast.api.channel.ToastSendChannel
import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope
import and.degilevich.dream.shared.core.toast.impl.model.builder.ToastBuilder
import dev.icerock.moko.resources.StringResource

internal class ToastControllerImpl(
    private val toastChannel: ToastSendChannel,
    private val toastFactory: ToastFactory
) : ToastController {

    override suspend fun showToast(toast: ToastData) {
        toastChannel.send(toast)
    }

    override suspend fun showToast(block: ToastBuilderScope.() -> Unit) {
        val builder = ToastBuilder()
        val toast = builder.apply(block).build()
        showToast(toast)
    }

    override suspend fun showMessageToast(message: String) {
        showToast(
            toast = toastFactory.createMessageToast(message = message)
        )
    }

    override suspend fun showMessageToast(resource: StringResource) {
        showToast(
            toast = toastFactory.createMessageToast(resource)
        )
    }

    override suspend fun showMessageToast(error: Throwable) {
        showToast(
            toast = toastFactory.createMessageToast(error = error)
        )
    }

    override suspend fun showRepeatToast(message: String, onRepeat: () -> Unit) {
        showToast(
            toast = toastFactory.createRepeatToast(
                message = message,
                onRepeat = onRepeat
            )
        )
    }

    override suspend fun showRepeatToast(error: Throwable, onRepeat: () -> Unit) {
        showToast(
            toast = toastFactory.createRepeatToast(
                error = error,
                onRepeat = onRepeat
            )
        )
    }
}