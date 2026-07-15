package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetArtistAlbumsResponseToResultMapperImpl(
    private val simplifiedAlbumOutputToDataMapper: SimplifiedAlbumOutputToDataMapper
) : GetArtistAlbumsResponseToResultMapper {

    override fun map(item: PagingArtistDiscographyAlbumObject): GetArtistAlbumsResult = with(item) {
        GetArtistAlbumsResult(
            total = total,
            items = items.mapWith(simplifiedAlbumOutputToDataMapper)
        )
    }
}