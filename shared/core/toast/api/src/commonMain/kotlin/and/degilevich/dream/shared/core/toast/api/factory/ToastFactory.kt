package and.degilevich.dream.shared.core.toast.api.factory

import and.degilevich.dream.shared.core.toast.api.model.ToastData

interface ToastFactory {
    fun createMessageToast(message: String): ToastData
    fun createRepeatToast(
        message: String,
        onRepeat: () -> Unit
    ): ToastData
    fun createRepeatToast(
        error: Throwable,
        onRepeat: () -> Unit
    ): ToastData
}