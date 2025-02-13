package and.degilevich.dream.shared.core.toast.api.controller

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope

interface ToastController {
    suspend fun showToast(toast: ToastData)
    suspend fun showToast(block: ToastBuilderScope.() -> Unit)
}