package and.degilevich.dream.shared.core.error.impl.handler

import and.degilevich.dream.shared.core.toast.api.model.builder.ToastBuilderScope

internal class ErrorHandler(
    val toastBuilderBlock: (ToastBuilderScope.() -> Unit)?
)