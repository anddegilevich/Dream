package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsRequest
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetArtistRelatedArtistsParamsToRequestMapper :
    Mapper<GetArtistRelatedArtistsParams, GetArtistRelatedArtistsRequest> {
    override fun map(item: GetArtistRelatedArtistsParams): GetArtistRelatedArtistsRequest {
        return with(item) {
            GetArtistRelatedArtistsRequest(id = id)
        }
    }
}