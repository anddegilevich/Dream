package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams

internal class GetArtistsParamsToRequestMapperImpl : GetArtistsParamsToRequestMapper {

    override fun map(item: GetArtistsParams): GetArtistsRequest = with(item) {
        GetArtistsRequest(
            ids = ids.joinToString(separator = ",") { id -> id.id }
        )
    }
}