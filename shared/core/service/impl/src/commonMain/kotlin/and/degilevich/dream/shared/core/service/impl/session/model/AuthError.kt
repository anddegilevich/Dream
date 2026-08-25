package and.degilevich.dream.shared.core.service.impl.session.model

internal sealed class AuthError : Exception() {
    class Denied(val reason: String) : AuthError()
    class Malformed : AuthError()
    class StateMismatch : AuthError()
}
