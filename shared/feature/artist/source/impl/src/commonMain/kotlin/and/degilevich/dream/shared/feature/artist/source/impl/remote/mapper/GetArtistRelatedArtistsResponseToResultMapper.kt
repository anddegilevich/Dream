package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistRelatedArtistsResponseToResultMapper(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : Mapper<GetArtistRelatedArtistsResponse, GetArtistRelatedArtistsResult> {
    override fun map(item: GetArtistRelatedArtistsResponse): GetArtistRelatedArtistsResult {
        return with(item) {
            GetArtistRelatedArtistsResult(
                artists = artists?.mapWith(artistOutputToDataMapper).orEmpty()
            )
        }
    }
}