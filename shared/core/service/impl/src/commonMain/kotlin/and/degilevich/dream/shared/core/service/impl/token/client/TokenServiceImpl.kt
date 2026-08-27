package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.token.mapper.TokenResponseToDataMapper
import and.degilevich.dream.shared.core.service.impl.token.model.response.TokenResponse
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.request.forms.submitForm
import io.ktor.http.Parameters

internal class TokenServiceImpl(
    remoteClient: RemoteClient,
    private val tokenResponseToDataMapper: TokenResponseToDataMapper
) : TokenService {

    private val client: HttpClient = remoteClient.client.config {
        install(DefaultRequest) {
            url(SharedBuildConfig.AUTH_TOKEN_URL)
        }
    }

    override suspend fun exchangeCode(
        code: String,
        codeVerifier: String
    ): Result<TokensData> {
        return requestToken(
            parameters = Parameters.build {
                append(PARAM_GRANT_TYPE, GRANT_TYPE_AUTHORIZATION_CODE)
                append(PARAM_CODE, code)
                append(PARAM_REDIRECT_URI, SharedBuildConfig.REDIRECT_URI)
                append(PARAM_CODE_VERIFIER, codeVerifier)
                append(PARAM_CLIENT_ID, SharedBuildConfig.CLIENT_ID)
            }
        )
    }

    override suspend fun refresh(refreshToken: String): Result<TokensData> {
        return requestToken(
            parameters = Parameters.build {
                append(PARAM_GRANT_TYPE, GRANT_TYPE_REFRESH_TOKEN)
                append(PARAM_REFRESH_TOKEN, refreshToken)
                append(PARAM_CLIENT_ID, SharedBuildConfig.CLIENT_ID)
            }
        )
    }

    private suspend fun requestToken(
        parameters: Parameters
    ): Result<TokensData> {
        return runCatching {
            client.submitForm(formParameters = parameters)
                .body<TokenResponse>()
                .mapWith(tokenResponseToDataMapper)
        }
    }

    private companion object {
        const val PARAM_GRANT_TYPE = "grant_type"
        const val PARAM_CODE = "code"
        const val PARAM_REDIRECT_URI = "redirect_uri"
        const val PARAM_CODE_VERIFIER = "code_verifier"
        const val PARAM_CLIENT_ID = "client_id"
        const val PARAM_REFRESH_TOKEN = "refresh_token"
        const val GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code"
        const val GRANT_TYPE_REFRESH_TOKEN = "refresh_token"
    }
}
