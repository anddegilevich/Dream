package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.shared.core.service.api.model.TokensData

internal interface TokenService {

    suspend fun exchangeCode(
        code: String,
        codeVerifier: String
    ): Result<TokensData>

    suspend fun refresh(refreshToken: String): Result<TokensData>
}
