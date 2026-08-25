package and.degilevich.dream.shared.core.service.impl.session.model

internal data class AuthRedirectData(
    val code: String,
    val state: String
)
