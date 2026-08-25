package and.degilevich.dream.shared.core.service.impl.session.url

import and.degilevich.dream.shared.core.service.impl.session.model.PkceData

internal interface AuthUrlBuilder {
    fun build(pkce: PkceData): String
}
