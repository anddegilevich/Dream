package and.degilevich.dream.shared.core.service.impl.session.model

internal sealed class AuthError(message: String) : Exception(message) {

    class Denied(val reason: String) : AuthError(
        message = "Authorization denied: $reason"
    )

    class Malformed : AuthError(
        message = "Authorization redirect is malformed"
    )

    class StateMismatch : AuthError(
        message = "Authorization state does not match the request"
    )

    class GrantRejected(override val cause: Throwable?) : AuthError(
        message = "Authorization grant was rejected by the token endpoint"
    )
}
