package and.degilevich.dream.shared.core.service.impl.token.mappers

import and.degilevich.dream.shared.core.service.api.model.TokensData
import io.ktor.client.plugins.auth.providers.BearerTokens

internal fun TokensData.mapToBearer(): BearerTokens {
    return BearerTokens(
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}