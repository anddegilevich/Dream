package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsResult
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