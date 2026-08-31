package and.degilevich.dream.shared.core.service.impl.session.redirect

import and.degilevich.dream.shared.core.service.impl.session.model.AuthRedirectData

internal interface AuthRedirectParser {
    fun parse(url: String): Result<AuthRedirectData>
}
