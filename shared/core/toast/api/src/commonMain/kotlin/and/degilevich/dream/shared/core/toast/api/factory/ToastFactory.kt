package and.degilevich.dream.shared.core.toast.api.factory

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import dev.icerock.moko.resources.StringResource

interface ToastFactory {
    fun createMessageToast(message: String): ToastData
    fun createMessageToast(resource: StringResource): ToastData
    fun createMessageToast(error: Throwable): ToastData
    fun createRepeatToast(
        message: String,
        onRepeat: () -> Unit
    ): ToastData
    fun createRepeatToast(
        error: Throwable,
        onRepeat: () -> Unit
    ): ToastData
}