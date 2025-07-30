package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistResponseToResultMapperImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : GetArtistResponseToResultMapper {
    override fun map(item: GetArtistResponse): GetArtistResult {
        return GetArtistResult(
            artist = item?.mapWith(artistOutputToDataMapper).orEmpty(ArtistData)
        )
    }
}