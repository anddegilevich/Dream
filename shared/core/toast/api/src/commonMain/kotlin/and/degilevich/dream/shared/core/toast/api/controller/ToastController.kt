package and.degilevich.dream.shared.core.toast.api.controller

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope
import dev.icerock.moko.resources.StringResource

interface ToastController {
    suspend fun showToast(toast: ToastData)
    suspend fun showToast(block: ToastBuilderScope.() -> Unit)
    suspend fun showMessageToast(message: String)
    suspend fun showMessageToast(resource: StringResource)
    suspend fun showMessageToast(error: Throwable)
    suspend fun showRepeatToast(message: String, onRepeat: () -> Unit)
    suspend fun showRepeatToast(error: Throwable, onRepeat: () -> Unit)
}