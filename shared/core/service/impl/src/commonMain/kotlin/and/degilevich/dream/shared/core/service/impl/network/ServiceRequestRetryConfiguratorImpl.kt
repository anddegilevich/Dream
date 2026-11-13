package and.degilevich.dream.shared.core.service.impl.network

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import kotlin.time.Duration.Companion.seconds

internal class ServiceRequestRetryConfiguratorImpl : ServiceRequestRetryConfigurator {

    override fun configure(config: HttpClientConfig<*>) {
        config.install(HttpRequestRetry) {
            noRetry()
            retryIf(maxRetries = MAX_RETRIES) { _, response ->
                val isTooManyRequests = response.status == HttpStatusCode.TooManyRequests
                val retryAfterSeconds = response.headers[HttpHeaders.RetryAfter]?.toLongOrNull()
                val isRetryAfterWithinCap = retryAfterSeconds?.seconds?.let { it <= MAX_RETRY_DELAY } ?: true
                isTooManyRequests && isRetryAfterWithinCap
            }
            exponentialDelay(
                maxDelayMs = MAX_RETRY_DELAY.inWholeMilliseconds,
                respectRetryAfterHeader = true
            )
        }
    }

    private companion object {
        const val MAX_RETRIES = 3
        val MAX_RETRY_DELAY = 30.seconds
    }
}
