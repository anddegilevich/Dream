package and.degilevich.dream.shared.feature.artist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeGetArtistAlbumsResponseToResultMapper(
    private val onMap: (PagingArtistDiscographyAlbumObject) -> GetArtistAlbumsResult = { fakeImplementationError() }
) : GetArtistAlbumsResponseToResultMapper {

    override fun map(item: PagingArtistDiscographyAlbumObject): GetArtistAlbumsResult = onMap(item)
}
