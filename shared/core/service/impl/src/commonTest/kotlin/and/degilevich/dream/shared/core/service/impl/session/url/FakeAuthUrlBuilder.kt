package and.degilevich.dream.shared.core.service.impl.session.url

import and.degilevich.dream.shared.core.service.impl.session.model.PkceData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeAuthUrlBuilder(
    private val onBuild: (PkceData) -> String = { fakeImplementationError() }
) : AuthUrlBuilder {

    override fun build(pkce: PkceData): String {
        return onBuild(pkce)
    }
}
