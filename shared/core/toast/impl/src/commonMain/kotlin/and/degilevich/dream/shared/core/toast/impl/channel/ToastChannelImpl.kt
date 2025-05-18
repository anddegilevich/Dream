package and.degilevich.dream.shared.core.toast.impl.channel

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import kotlinx.coroutines.channels.Channel

internal class ToastChannelImpl : ToastChannel, Channel<ToastData> by Channel<ToastData>()