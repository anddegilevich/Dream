package and.degilevich.dream.shared.core.client.impl.token.client

import and.degilevich.dream.shared.core.client.impl.token.model.Tokens

internal interface TokenClient {
    suspend fun getToken(): Result<Tokens>
}