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
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlin.time.Duration.Companion.seconds

internal class RemoteClientImpl(
    clientEngineFactory: ClientEngineFactory,
    private val tokensStorage: TokensStorage,
    private val tokenClient: TokenClient
) : RemoteClient {

    override val client: HttpClient = HttpClient(
        engine = clientEngineFactory.create()
    ) {
        install(Logging) {
            logger = ClientLogger(
                clientKClass = RemoteClient::class
            )
            level = LogLevel.BODY
        }
        install(ContentNegotiation) {
            json(
                json = JsonSerialFormat.json
            )
        }
        install(DefaultRequest) {
            url(SharedBuildConfig.API_BASE_URL)
        }
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT.inWholeMilliseconds
            socketTimeoutMillis = TIMEOUT.inWholeMilliseconds
        }
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
        expectSuccess = true
    }

    private companion object {
        val TIMEOUT = 30.seconds
    }
}