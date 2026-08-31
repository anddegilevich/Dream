package and.degilevich.dream.shared.core.service.impl.session.model

internal fun pkceData(
    codeVerifier: String = "verifier-value",
    codeChallenge: String = "challenge-value",
    state: String = "state-value"
): PkceData {
    return PkceData(
        codeVerifier = codeVerifier,
        codeChallenge = codeChallenge,
        state = state
    )
}
