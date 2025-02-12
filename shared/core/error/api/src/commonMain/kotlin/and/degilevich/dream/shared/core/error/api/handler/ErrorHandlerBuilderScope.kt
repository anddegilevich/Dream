package and.degilevich.dream.shared.core.error.api.handler

import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope

//FIXME: Improve realization
interface ErrorHandlerBuilderScope {
    fun setToast(
        block: ToastBuilderScope.() -> Unit
    )
}