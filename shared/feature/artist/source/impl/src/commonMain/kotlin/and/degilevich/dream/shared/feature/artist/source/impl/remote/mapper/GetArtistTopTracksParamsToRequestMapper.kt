package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks.GetArtistTopTracksRequest
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetArtistTopTracksParamsToRequestMapper : Mapper<GetArtistTopTracksParams, GetArtistTopTracksRequest> {
    override fun map(item: GetArtistTopTracksParams): GetArtistTopTracksRequest {
        return with(item) {
            GetArtistTopTracksRequest(
                id = id
            )
        }
    }
}