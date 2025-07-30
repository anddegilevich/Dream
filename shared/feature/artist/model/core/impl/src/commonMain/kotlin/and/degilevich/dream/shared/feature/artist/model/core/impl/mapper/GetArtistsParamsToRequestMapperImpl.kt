package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams

internal class GetArtistsParamsToRequestMapperImpl : GetArtistsParamsToRequestMapper {
    override fun map(item: GetArtistsParams): GetArtistsRequest {
        return with(item) {
            GetArtistsRequest(
                ids = ids.joinToString(separator = ",")
            )
        }
    }
}