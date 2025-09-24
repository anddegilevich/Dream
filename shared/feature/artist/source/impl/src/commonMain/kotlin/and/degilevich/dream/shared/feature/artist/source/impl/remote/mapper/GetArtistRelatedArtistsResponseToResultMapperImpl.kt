package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult
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