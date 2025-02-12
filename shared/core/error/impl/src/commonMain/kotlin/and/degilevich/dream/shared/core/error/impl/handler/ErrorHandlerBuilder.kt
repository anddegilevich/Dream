package and.degilevich.dream.shared.core.error.impl.handler

import and.degilevich.dream.shared.core.error.api.handler.ErrorHandlerBuilderScope
import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope

internal class ErrorHandlerBuilder : ErrorHandlerBuilderScope {

    private var toastBuilderBlock: (ToastBuilderScope.() -> Unit)? = null

    fun build(): ErrorHandler {
        return ErrorHandler(
            toastBuilderBlock = toastBuilderBlock
        )
    }

    override fun setToast(block: ToastBuilderScope.() -> Unit) {
        this.toastBuilderBlock = block
    }
}