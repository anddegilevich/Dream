package and.degilevich.dream.shared.core.toast.impl.channel

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.foundation.model.channel.AbstractValueChannel

internal class ToastChannelImpl : ToastChannel, AbstractValueChannel<ToastData>()