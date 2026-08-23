package and.degilevich.dream.shared.core.webauth.api.model

sealed class WebAuthError : Exception() {

    class Cancelled : WebAuthError()

    class Failed(override val cause: Throwable?) : WebAuthError()
}
