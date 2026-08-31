package and.degilevich.dream.shared.core.service.impl.session.redirect

import and.degilevich.dream.shared.core.service.impl.session.model.AuthRedirectData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeAuthRedirectParser(
    private val onParse: (String) -> Result<AuthRedirectData> = { fakeImplementationError() }
) : AuthRedirectParser {

    override fun parse(url: String): Result<AuthRedirectData> {
        return onParse(url)
    }
}
