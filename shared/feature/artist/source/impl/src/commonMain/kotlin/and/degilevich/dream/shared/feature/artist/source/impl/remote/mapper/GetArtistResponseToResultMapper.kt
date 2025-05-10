package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistResponseToResultMapper(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : Mapper<GetArtistResponse, GetArtistResult> {
    override fun map(item: GetArtistResponse): GetArtistResult {
        return GetArtistResult(
            artist = item?.mapWith(artistOutputToDataMapper).orEmpty(ArtistData)
        )
    }
}