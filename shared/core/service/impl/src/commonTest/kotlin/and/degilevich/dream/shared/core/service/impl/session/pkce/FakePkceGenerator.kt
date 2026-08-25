package and.degilevich.dream.shared.core.service.impl.session.pkce

import and.degilevich.dream.shared.core.service.impl.session.model.PkceData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakePkceGenerator(
    private val onGenerate: () -> PkceData = { fakeImplementationError() }
) : PkceGenerator {

    override fun generate(): PkceData {
        return onGenerate()
    }
}
