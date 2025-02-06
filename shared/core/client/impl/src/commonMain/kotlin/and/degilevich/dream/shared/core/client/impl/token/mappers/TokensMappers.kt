package and.degilevich.dream.shared.core.client.impl.token.mappers

import and.degilevich.dream.shared.core.client.impl.token.model.Tokens
import io.ktor.client.plugins.auth.providers.BearerTokens

internal fun Tokens.mapToBearer(): BearerTokens {
    return BearerTokens(
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}