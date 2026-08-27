package and.degilevich.dream.shared.core.service.impl.token.model.request

internal fun tokenResponse(
    accessToken: String = "access-token-value",
    refreshToken: String = "refresh-token-value"
): TokenResponse {
    return TokenResponse(
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}
