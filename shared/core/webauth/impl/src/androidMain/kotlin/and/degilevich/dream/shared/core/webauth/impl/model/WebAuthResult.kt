package and.degilevich.dream.shared.core.webauth.impl.model

internal sealed interface WebAuthResult {

    data class Redirect(val url: String) : WebAuthResult

    data object Cancelled : WebAuthResult
}
