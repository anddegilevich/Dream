package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.shared.core.service.api.model.TokensData

internal interface TokenService {
    suspend fun getToken(): Result<TokensData>
}