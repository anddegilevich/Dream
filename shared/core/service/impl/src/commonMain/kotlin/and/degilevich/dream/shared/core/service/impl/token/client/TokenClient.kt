package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.shared.core.service.impl.token.model.Tokens

internal interface TokenClient {
    suspend fun getToken(): Result<Tokens>
}