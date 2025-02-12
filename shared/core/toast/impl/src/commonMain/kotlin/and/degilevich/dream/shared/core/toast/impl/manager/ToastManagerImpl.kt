package and.degilevich.dream.shared.core.toast.impl.manager

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.manager.ToastManager
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope
import and.degilevich.dream.shared.core.toast.impl.model.builder.ToastBuilder

internal class ToastManagerImpl(
    private val toastChannel: ToastChannel
) : ToastManager {

    override suspend fun showToast(toast: ToastData) {
        toastChannel.sendToast(toast)
    }

    override suspend fun showToast(block: ToastBuilderScope.() -> Unit) {
        val builder = ToastBuilder()
        val toast = builder.apply(block).build()
        showToast(toast)
    }
}