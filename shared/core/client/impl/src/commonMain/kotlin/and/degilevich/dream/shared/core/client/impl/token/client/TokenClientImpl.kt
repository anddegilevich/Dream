package and.degilevich.dream.shared.core.client.impl.token.client

import and.degilevich.dream.shared.core.client.impl.BuildKonfig
import and.degilevich.dream.shared.core.client.impl.engine.ClientEngineFactory
import and.degilevich.dream.shared.core.client.impl.logger.ClientLogger
import and.degilevich.dream.shared.core.client.impl.token.model.Tokens
import and.degilevich.dream.shared.core.client.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.core.client.impl.token.storage.TokensStorage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.time.Duration.Companion.seconds

internal class TokenClientImpl(
    clientEngineFactory: ClientEngineFactory,
    private val tokensStorage: TokensStorage,
) : TokenClient {

    private val client: HttpClient = HttpClient(
        engine = clientEngineFactory.create()
    ) {
        install(Logging) {
            logger = ClientLogger(
                clientKClass = TokenClient::class
            )
            level = LogLevel.BODY
        }
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT.inWholeMilliseconds
            socketTimeoutMillis = TIMEOUT.inWholeMilliseconds
        }
        install(ContentNegotiation) {
            json(
                json = Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                }
            )
        }
        expectSuccess = true
    }

    @Suppress("TooGenericExceptionCaught")
    override suspend fun getToken(): Result<Tokens> {
        return try {
            val response = client.post {
                url("https://accounts.spotify.com/api/token")
                header(HttpHeaders.ContentType, "application/x-www-form-urlencoded")
                parameter("grant_type", "client_credentials")
                parameter("client_id", BuildKonfig.CLIENT_ID)
                parameter("client_secret", BuildKonfig.CLIENT_SECRET)
            }.body<TokenResponse>()
            val tokens = Tokens(
                accessToken = response.accessToken.orEmpty(),
                refreshToken = ""
            )
            tokensStorage.save(tokens)
            Result.success(tokens)
        } catch (error: Throwable) {
            Result.failure(error)
        }
    }

    private companion object {
        val TIMEOUT = 30.seconds
    }
}