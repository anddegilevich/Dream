package and.degilevich.dream.shared.core.toast.api.channel

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import kotlinx.coroutines.flow.Flow

interface ToastChannel {
    val toasts: Flow<ToastData>

    suspend fun sendToast(toastData: ToastData)
}