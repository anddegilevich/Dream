package and.degilevich.dream.shared.core.toast.impl.controller

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope
import and.degilevich.dream.shared.core.toast.impl.model.builder.ToastBuilder

internal class ToastControllerImpl(
    private val toastChannel: ToastChannel
) : ToastController {

    override suspend fun showToast(toast: ToastData) {
        toastChannel.send(toast)
    }

    override suspend fun showToast(block: ToastBuilderScope.() -> Unit) {
        val builder = ToastBuilder()
        val toast = builder.apply(block).build()
        showToast(toast)
    }
}