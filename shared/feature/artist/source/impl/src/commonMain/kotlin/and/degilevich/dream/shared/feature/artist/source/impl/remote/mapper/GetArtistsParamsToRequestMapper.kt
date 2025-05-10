package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetArtistsParamsToRequestMapper : Mapper<GetArtistsParams, GetArtistsRequest> {
    override fun map(item: GetArtistsParams): GetArtistsRequest {
        return with(item) {
            GetArtistsRequest(
                ids = ids.joinToString(separator = ",")
            )
        }
    }
}