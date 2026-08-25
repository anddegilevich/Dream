package and.degilevich.dream.shared.core.service.impl.session.model

internal fun pkceData(): PkceData {
    return PkceData(
        codeVerifier = "verifier-value",
        codeChallenge = "challenge-value",
        state = "state-value"
    )
}