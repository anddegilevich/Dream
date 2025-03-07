package and.degilevich.dream.shared.core.toast.impl.channel

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.foundation.abstraction.channel.ValueChannelAbs

internal class ToastChannelImpl : ToastChannel, ValueChannelAbs<ToastData>()