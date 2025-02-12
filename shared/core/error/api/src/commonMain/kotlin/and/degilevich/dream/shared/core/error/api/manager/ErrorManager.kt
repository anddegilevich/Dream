package and.degilevich.dream.shared.core.error.api.manager

import and.degilevich.dream.shared.core.error.api.handler.ErrorHandlerBuilderScope

interface ErrorManager {
    suspend fun handle(
        error: Throwable,
        block: ErrorHandlerBuilderScope.() -> Unit = { }
    )
}