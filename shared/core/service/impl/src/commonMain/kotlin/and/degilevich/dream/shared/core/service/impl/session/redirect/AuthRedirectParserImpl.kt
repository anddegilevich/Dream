package and.degilevich.dream.shared.core.service.impl.session.redirect

import and.degilevich.dream.shared.core.service.impl.session.model.AuthError
import and.degilevich.dream.shared.core.service.impl.session.model.AuthRedirectData
import io.ktor.http.Url

internal class AuthRedirectParserImpl : AuthRedirectParser {

    override fun parse(url: String): Result<AuthRedirectData> {
        return runCatching { Url(url).parameters }.mapCatching { parameters ->
            parameters[PARAM_ERROR]?.let { reason ->
                throw AuthError.Denied(reason = reason)
            }
            AuthRedirectData(
                code = parameters[PARAM_CODE] ?: throw AuthError.Malformed(),
                state = parameters[PARAM_STATE] ?: throw AuthError.Malformed()
            )
        }
    }

    private companion object {
        const val PARAM_CODE = "code"
        const val PARAM_STATE = "state"
        const val PARAM_ERROR = "error"
    }
}
