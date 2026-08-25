package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import io.ktor.client.plugins.auth.providers.BearerTokens

internal class TokensDataToBearerMapperImpl : TokensDataToBearerMapper {

    override fun map(item: TokensData): BearerTokens = with(item) {
        BearerTokens(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
}
