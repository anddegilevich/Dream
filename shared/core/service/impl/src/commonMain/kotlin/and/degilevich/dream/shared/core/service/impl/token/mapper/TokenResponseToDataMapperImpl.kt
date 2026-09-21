package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.token.model.response.TokenResponse

internal class TokenResponseToDataMapperImpl : TokenResponseToDataMapper {

    override fun map(item: TokenResponse): TokensData = with(item) {
        TokensData(
            accessToken = accessToken,
            refreshToken = refreshToken.orEmpty()
        )
    }
}
