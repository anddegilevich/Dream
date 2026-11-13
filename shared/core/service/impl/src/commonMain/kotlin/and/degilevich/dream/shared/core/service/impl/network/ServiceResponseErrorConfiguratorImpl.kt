package and.degilevich.dream.shared.core.service.impl.network

import and.degilevich.dream.shared.core.service.api.exception.ServiceErrorStatus
import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import and.degilevich.dream.shared.core.service.impl.network.model.ServiceErrorResponse
import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.bodyAsText

internal class ServiceResponseErrorConfiguratorImpl : ServiceResponseErrorConfigurator {

    override fun configure(config: HttpClientConfig<*>) {
        config.HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, _ ->
                if (cause is ResponseException) {
                    throw cause.toServiceException()
                }
            }
        }
    }

    private suspend fun ResponseException.toServiceException(): ServiceException {
        return ServiceException(
            status = mapStatus(code = response.status.value),
            serviceMessage = readServiceMessage(),
            cause = this
        )
    }

    private fun mapStatus(code: Int): ServiceErrorStatus {
        return ServiceErrorStatus.entries.firstOrNull { status -> status.code == code } ?: ServiceErrorStatus.UNKNOWN
    }

    private suspend fun ResponseException.readServiceMessage(): String? {
        return runCatching {
            JsonSerialFormat.decodeFromString(
                deserializer = ServiceErrorResponse.serializer(),
                string = response.bodyAsText()
            ).error.message
        }.getOrNull()
    }
}
