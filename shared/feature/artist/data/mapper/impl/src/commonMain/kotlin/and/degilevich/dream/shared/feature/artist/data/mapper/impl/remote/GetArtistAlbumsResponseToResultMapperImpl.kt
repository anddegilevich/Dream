package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsResponse
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class GetArtistAlbumsResponseToResultMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper
) : GetArtistAlbumsResponseToResultMapper {

    override fun map(item: GetArtistAlbumsResponse): GetArtistAlbumsResult = with(item) {
        GetArtistAlbumsResult(
            total = total.orZero(),
            items = items?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
        )
    }
}