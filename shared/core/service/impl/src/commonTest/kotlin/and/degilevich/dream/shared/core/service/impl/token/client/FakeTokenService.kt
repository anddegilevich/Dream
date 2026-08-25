package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeTokenService(
    private val onExchangeCode: (String, String) -> Result<TokensData> = { _, _ -> fakeImplementationError() },
    private val onRefresh: (String) -> Result<TokensData> = { fakeImplementationError() }
) : TokenService {

    override suspend fun exchangeCode(
        code: String,
        codeVerifier: String
    ): Result<TokensData> {
        return onExchangeCode(code, codeVerifier)
    }

    override suspend fun refresh(refreshToken: String): Result<TokensData> {
        return onRefresh(refreshToken)
    }
}
