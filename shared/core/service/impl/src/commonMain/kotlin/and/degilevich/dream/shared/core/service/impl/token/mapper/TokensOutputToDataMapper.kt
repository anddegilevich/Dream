package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal interface TokensOutputToDataMapper : Mapper<TokenResponse, TokensData>
