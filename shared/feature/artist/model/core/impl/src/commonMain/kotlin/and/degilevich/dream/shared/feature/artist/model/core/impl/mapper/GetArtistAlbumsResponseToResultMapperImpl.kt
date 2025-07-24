package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistAlbums.GetArtistAlbumsResponse
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class GetArtistAlbumsResponseToResultMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper
) : GetArtistAlbumsResponseToResultMapper {
    override fun map(item: GetArtistAlbumsResponse): GetArtistAlbumsResult {
        return with(item) {
            GetArtistAlbumsResult(
                total = total.orZero(),
                items = items?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}