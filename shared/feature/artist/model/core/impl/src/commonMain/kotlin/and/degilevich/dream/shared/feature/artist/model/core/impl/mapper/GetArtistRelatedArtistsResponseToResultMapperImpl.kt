package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistRelatedArtistsResponseToResultMapperImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : GetArtistRelatedArtistsResponseToResultMapper {
    override fun map(item: GetArtistRelatedArtistsResponse): GetArtistRelatedArtistsResult {
        return with(item) {
            GetArtistRelatedArtistsResult(
                artists = artists?.mapWith(artistOutputToDataMapper).orEmpty()
            )
        }
    }
}