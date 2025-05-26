package and.degilevich.dream.shared.core.client.impl

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.impl.engine.ClientEngineFactory
import and.degilevich.dream.shared.core.client.impl.logger.ClientLogger
import and.degilevich.dream.shared.core.client.impl.token.client.TokenClient
import and.degilevich.dream.shared.core.client.impl.token.mappers.mapToBearer
import and.degilevich.dream.shared.core.client.impl.token.storage.TokensStorage
import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlin.time.Duration.Companion.seconds

internal class RemoteClientImpl(
    clientEngineFactory: ClientEngineFactory,
    private val tokensStorage: TokensStorage,
    private val tokenClient: TokenClient
) : RemoteClient {

    private val client: HttpClient = HttpClient(
        engine = clientEngineFactory.create()
    ) {
        installLogging()
        installContentNegotiation()
        installDefaultRequest()
        installHttpTimeout()
        installAuth()
        expectSuccess = true
    }

    private fun HttpClientConfig<*>.installLogging() {
        install(Logging) {
            logger = ClientLogger(
                clientKClass = RemoteClient::class
            )
            level = LogLevel.BODY
        }
    }

    private fun HttpClientConfig<*>.installContentNegotiation() {
        install(ContentNegotiation) {
            json(
                json = JsonSerialFormat.json
            )
        }
    }

    private fun HttpClientConfig<*>.installDefaultRequest() {
        install(DefaultRequest) {
            url(SharedBuildConfig.API_BASE_URL)
        }
    }

    private fun HttpClientConfig<*>.installHttpTimeout() {
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT.inWholeMilliseconds
            socketTimeoutMillis = TIMEOUT.inWholeMilliseconds
        }
    }

    private fun HttpClientConfig<*>.installAuth() {
        install(Auth) {
            bearer {
                loadTokens {
                    tokensStorage.read()?.mapToBearer()
                }
                refreshTokens {
                    tokenClient.getToken().getOrNull()?.mapToBearer()
                }
            }
        }
    }

    override suspend fun getCatching(block: HttpRequestBuilder.() -> Unit): Result<HttpResponse> {
        return runCatching { client.get(block) }
    }

    override suspend fun postCatching(block: HttpRequestBuilder.() -> Unit): Result<HttpResponse> {
        return runCatching { client.post(block) }
    }

    private companion object {
        val TIMEOUT = 30.seconds
    }
}