package and.degilevich.dream.shared.core.toast.impl.channel

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal class ToastChannelImpl : ToastChannel {
    private val toastsChannel: Channel<ToastData> = Channel()
    override val toasts: Flow<ToastData> = toastsChannel.receiveAsFlow()

    override suspend fun sendToast(toastData: ToastData) {
        toastsChannel.send(toastData)
    }
}