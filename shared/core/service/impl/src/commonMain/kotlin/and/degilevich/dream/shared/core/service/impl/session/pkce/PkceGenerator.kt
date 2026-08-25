package and.degilevich.dream.shared.core.service.impl.session.pkce

import and.degilevich.dream.shared.core.service.impl.session.model.PkceData

internal interface PkceGenerator {
    fun generate(): PkceData
}
