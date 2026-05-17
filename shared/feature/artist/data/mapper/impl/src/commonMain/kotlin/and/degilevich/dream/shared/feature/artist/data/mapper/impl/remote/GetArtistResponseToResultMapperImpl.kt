package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistResponseToResultMapper
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