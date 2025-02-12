package and.degilevich.dream.shared.core.toast.api.manager

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope

interface ToastManager {
    suspend fun showToast(toast: ToastData)
    suspend fun showToast(block: ToastBuilderScope.() -> Unit)
}