package and.degilevich.dream.shared.core.error.impl.manager

import and.degilevich.dream.shared.core.error.api.handler.ErrorHandlerBuilderScope
import and.degilevich.dream.shared.core.error.api.manager.ErrorManager
import and.degilevich.dream.shared.core.error.impl.handler.ErrorHandler
import and.degilevich.dream.shared.core.error.impl.handler.ErrorHandlerBuilder
import and.degilevich.dream.shared.core.logger.Log
import and.degilevich.dream.shared.core.resource.api.ResourceManager
import and.degilevich.dream.shared.core.toast.api.manager.ToastManager
import and.degilevich.dream.shared.core.toast.api.model.ToastDurationData
import and.degilevich.dream.shared.foundation.primitive.primitives.string.ifNullOrEmpty
import and.degilevich.dream.shared.resource.Res
import io.ktor.client.plugins.ResponseException

internal class ErrorManagerImpl(
    private val toastManager: ToastManager,
    private val resourceManager: ResourceManager
) : ErrorManager {

    override suspend fun handle(
        error: Throwable,
        block: ErrorHandlerBuilderScope.() -> Unit
    ) {
        Log.error(
            message = error.message.orEmpty(),
            throwable = error
        )
        val errorHandler: ErrorHandler = ErrorHandlerBuilder().apply(block).build()
        when (error) {
            is ResponseException -> {
                handleResponseError(
                    error = error,
                    errorHandler = errorHandler
                )
            }

            else -> {
                handleOtherError(
                    error = error,
                    errorHandler = errorHandler
                )
            }
        }
    }

    //FIXME: Example of specific handling
    private suspend fun handleResponseError(error: ResponseException, errorHandler: ErrorHandler) {
        val isForbiddenResource = error.response.status.value == FORBIDDEN_RESOURCE_STATUS_CODE
        if (isForbiddenResource) {
            toastManager.showToast {
                errorHandler.toastBuilderBlock?.let { apply(it) }
                setMessage(resourceManager.getString(Res.strings.error_forbidden_resource))
            }
        } else {
            handleOtherError(error, errorHandler)
        }
    }

    private suspend fun handleOtherError(error: Throwable, errorHandler: ErrorHandler) {
        errorHandler.toastBuilderBlock?.let { toastBuilderBlock ->
            toastManager.showToast {
                setMessage(
                    message = error.message.ifNullOrEmpty { resourceManager.getString(Res.strings.error) }
                )
                setDuration(ToastDurationData.LONG)
                apply(toastBuilderBlock)
            }
        }
    }

    private companion object {
        const val FORBIDDEN_RESOURCE_STATUS_CODE = 403
    }
}