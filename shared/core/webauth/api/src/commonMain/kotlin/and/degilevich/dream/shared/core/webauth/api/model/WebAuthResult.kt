package and.degilevich.dream.shared.core.webauth.api.model

sealed interface WebAuthResult {

    data class Redirect(val url: String) : WebAuthResult

    data object Cancelled : WebAuthResult
}
