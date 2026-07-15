package and.degilevich.dream.shared.core.network.impl

import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.network.impl.engine.ClientEngineFactory
import and.degilevich.dream.shared.core.network.impl.logger.ClientLogger
import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlin.time.Duration.Companion.seconds

internal class RemoteClientImpl(
    clientEngineFactory: ClientEngineFactory
) : RemoteClient {

    override val client: HttpClient = HttpClient(
        engine = clientEngineFactory.create()
    ) {
        installLogging()
        installContentNegotiation()
        installHttpTimeout()
        expectSuccess = true
    }

    private fun HttpClientConfig<*>.installLogging() {
        install(Logging) {
            logger = ClientLogger(clientKClass = RemoteClient::class)
            level = LogLevel.BODY
        }
    }

    private fun HttpClientConfig<*>.installContentNegotiation() {
        install(ContentNegotiation) {
            json(json = JsonSerialFormat.json)
        }
    }

    private fun HttpClientConfig<*>.installHttpTimeout() {
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT.inWholeMilliseconds
            socketTimeoutMillis = TIMEOUT.inWholeMilliseconds
        }
    }

    private companion object {
        val TIMEOUT = 30.seconds
    }
}