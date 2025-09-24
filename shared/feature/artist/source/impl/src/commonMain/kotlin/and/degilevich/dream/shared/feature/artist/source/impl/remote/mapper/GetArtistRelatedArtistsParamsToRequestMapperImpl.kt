package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists.GetArtistRelatedArtistsRequest
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistRelatedArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams

internal class GetArtistRelatedArtistsParamsToRequestMapperImpl : GetArtistRelatedArtistsParamsToRequestMapper {
    override fun map(item: GetArtistRelatedArtistsParams): GetArtistRelatedArtistsRequest {
        return with(item) {
            GetArtistRelatedArtistsRequest(id = id)
        }
    }
}