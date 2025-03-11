package and.degilevich.dream.shared.core.client.impl.token.client

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.client.impl.engine.ClientEngineFactory
import and.degilevich.dream.shared.core.client.impl.logger.ClientLogger
import and.degilevich.dream.shared.core.client.impl.token.model.Tokens
import and.degilevich.dream.shared.core.client.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.core.client.impl.token.storage.TokensStorage
import and.degilevich.dream.shared.foundation.primitive.result.foldTry
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

    override suspend fun getToken(): Result<Tokens> {
        return foldTry {
            val response = client.post {
                url(SharedBuildConfig.AUTH_BASE_URL)
                header(HttpHeaders.ContentType, HEADER_CONTENT_TYPE_VALUE)
                parameter(PARAM_GRANT_TYPE, PARAM_GRANT_TYPE_VALUE)
                parameter(PARAM_CLIENT_ID, SharedBuildConfig.CLIENT_ID)
                parameter(PARAM_CLIENT_SECRET, SharedBuildConfig.CLIENT_SECRET)
            }.body<TokenResponse>()
            val tokens = Tokens(
                accessToken = response.accessToken.orEmpty(),
                refreshToken = ""
            )
            handleSuccessGetToken(tokens)
            tokens
        }
    }

    private fun handleSuccessGetToken(tokens: Tokens) {
        tokensStorage.save(tokens)
    }

    private companion object {
        val TIMEOUT = 30.seconds
        const val HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded"
        const val PARAM_GRANT_TYPE = "grant_type"
        const val PARAM_GRANT_TYPE_VALUE = "client_credentials"
        const val PARAM_CLIENT_ID = "client_id"
        const val PARAM_CLIENT_SECRET = "client_secret"
    }
}