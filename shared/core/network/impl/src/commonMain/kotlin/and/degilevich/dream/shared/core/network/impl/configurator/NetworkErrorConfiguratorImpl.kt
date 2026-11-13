package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.core.network.api.exception.NetworkTimeoutException
import and.degilevich.dream.shared.core.network.api.exception.NoNetworkConnectionException
import io.ktor.client.HttpClientConfig
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpResponseValidator
import kotlinx.io.IOException

internal class NetworkErrorConfiguratorImpl : NetworkErrorConfigurator {

    override fun configure(config: HttpClientConfig<*>) {
        config.HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, _ ->
                mapNetworkError(cause = cause)?.let { error -> throw error }
            }
        }
    }

    private fun mapNetworkError(cause: Throwable): Exception? {
        return when (cause) {
            is HttpRequestTimeoutException,
            is ConnectTimeoutException,
            is SocketTimeoutException -> NetworkTimeoutException(cause = cause)
            is IOException -> NoNetworkConnectionException(cause = cause)
            else -> null
        }
    }
}
