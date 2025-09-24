package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks.GetArtistTopTracksResponse
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistTopTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import kotlin.collections.orEmpty

internal class GetArtistTopTracksResponseToResultMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : GetArtistTopTracksResponseToResultMapper {
    override fun map(item: GetArtistTopTracksResponse): GetArtistTopTracksResult {
        return with(item) {
            GetArtistTopTracksResult(
                tracks = tracks?.mapWith(trackOutputToDataMapper).orEmpty()
            )
        }
    }
}