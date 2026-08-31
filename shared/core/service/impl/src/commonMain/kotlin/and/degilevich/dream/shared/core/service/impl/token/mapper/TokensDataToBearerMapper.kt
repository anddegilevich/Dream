package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import io.ktor.client.plugins.auth.providers.BearerTokens

internal interface TokensDataToBearerMapper : Mapper<TokensData, BearerTokens>
