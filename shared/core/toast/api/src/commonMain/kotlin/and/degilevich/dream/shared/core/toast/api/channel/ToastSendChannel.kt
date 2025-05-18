package and.degilevich.dream.shared.core.toast.api.channel

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import kotlinx.coroutines.channels.SendChannel

interface ToastSendChannel : SendChannel<ToastData>