package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks.GetArtistTopTracksRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistTopTracksParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams

internal class GetArtistTopTracksParamsToRequestMapperImpl : GetArtistTopTracksParamsToRequestMapper {
    override fun map(item: GetArtistTopTracksParams): GetArtistTopTracksRequest {
        return with(item) {
            GetArtistTopTracksRequest(
                id = id
            )
        }
    }
}