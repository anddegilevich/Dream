package and.degilevich.dream.shared.core.service.impl.token.model.request

internal fun tokenResponse(
    accessToken: String? = "access-token-value",
    tokenType: String? = "Bearer",
    expiresIn: Int? = 3600,
    refreshToken: String? = "refresh-token-value",
    scope: String? = "user-read-private"
): TokenResponse {
    return TokenResponse(
        accessToken = accessToken,
        tokenType = tokenType,
        expiresIn = expiresIn,
        refreshToken = refreshToken,
        scope = scope
    )
}
