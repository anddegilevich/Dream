package and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistResponseToResultMapperImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper
) : GetArtistResponseToResultMapper {

    override fun map(item: GetArtistResponse): GetArtistResult = with(item) {
        GetArtistResult(
            artist = this?.mapWith(artistOutputToDataMapper).orEmpty(ArtistData)
        )
    }
}