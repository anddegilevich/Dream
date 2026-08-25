package and.degilevich.dream.shared.core.service.impl.session.webauth

import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeWebAuthLauncher(
    private val onAuthorize: (String) -> Result<String> = { fakeImplementationError() }
) : WebAuthLauncher {

    override suspend fun authorize(url: String): Result<String> {
        return onAuthorize(url)
    }
}
