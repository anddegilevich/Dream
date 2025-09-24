package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistsResponseToResultMapperImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : GetArtistsResponseToResultMapper {
    override fun map(item: GetArtistsResponse): GetArtistsResult {
        return with(item) {
            GetArtistsResult(
                artists = artists?.mapWith(artistOutputToDataMapper).orEmpty()
            )
        }
    }
}