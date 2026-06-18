package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.service.impl.token.model.Tokens
import and.degilevich.dream.shared.core.service.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.core.service.impl.token.storage.TokensStorage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.HttpHeaders

internal class TokenClientImpl(
    remoteClient: RemoteClient,
    private val tokensStorage: TokensStorage,
) : TokenClient {

    private val client: HttpClient = remoteClient.client.config {
        install(DefaultRequest) {
            url(SharedBuildConfig.AUTH_BASE_URL)
        }
    }

    override suspend fun getToken(): Result<Tokens> {
        return runCatching {
            val response = client.post {
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

    private suspend fun handleSuccessGetToken(tokens: Tokens) {
        tokensStorage.save(tokens)
    }

    private companion object {
        const val HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded"
        const val PARAM_GRANT_TYPE = "grant_type"
        const val PARAM_GRANT_TYPE_VALUE = "client_credentials"
        const val PARAM_CLIENT_ID = "client_id"
        const val PARAM_CLIENT_SECRET = "client_secret"
    }
}