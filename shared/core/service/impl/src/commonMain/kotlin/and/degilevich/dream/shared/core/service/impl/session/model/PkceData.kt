package and.degilevich.dream.shared.core.service.impl.session.model

import kotlinx.serialization.Serializable

@Serializable
internal data class PkceData(
    val codeVerifier: String,
    val codeChallenge: String,
    val state: String
)
