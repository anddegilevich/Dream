package and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistsResponseToResultMapper(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : Mapper<GetArtistsResponse, GetArtistsResult> {
    override fun map(item: GetArtistsResponse): GetArtistsResult {
        return with(item) {
            GetArtistsResult(
                artists = artists?.mapWith(artistOutputToDataMapper).orEmpty()
            )
        }
    }
}