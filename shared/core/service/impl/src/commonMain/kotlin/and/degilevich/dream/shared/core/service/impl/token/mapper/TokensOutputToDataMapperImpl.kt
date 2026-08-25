package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero
import kotlin.time.Duration.Companion.seconds

internal class TokensOutputToDataMapperImpl(
    private val dateTime: DateTime
) : TokensOutputToDataMapper {

    override fun map(item: TokenResponse): TokensData = with(item) {
        TokensData(
            accessToken = accessToken.orEmpty(),
            refreshToken = refreshToken.orEmpty(),
            expirationTimestamp = dateTime.current.currentTimeMillis() + expiresIn.orZero().seconds.inWholeMilliseconds
        )
    }
}
