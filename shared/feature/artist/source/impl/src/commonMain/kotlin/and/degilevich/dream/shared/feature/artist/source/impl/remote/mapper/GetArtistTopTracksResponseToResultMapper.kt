package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks.GetArtistTopTracksResponse
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistTopTracksResponseToResultMapper(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : Mapper<GetArtistTopTracksResponse, GetArtistTopTracksResult> {
    override fun map(item: GetArtistTopTracksResponse): GetArtistTopTracksResult {
        return with(item) {
            GetArtistTopTracksResult(
                tracks = tracks?.mapWith(trackOutputToDataMapper).orEmpty()
            )
        }
    }
}