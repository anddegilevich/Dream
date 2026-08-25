package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeTokensOutputToDataMapper(
    private val onMap: (TokenResponse) -> TokensData = { fakeImplementationError() }
) : TokensOutputToDataMapper {

    override fun map(item: TokenResponse): TokensData {
        return onMap(item)
    }
}
