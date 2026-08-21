package and.degilevich.dream.shared.feature.album.data.impl.remote

import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumRemoteDataSource(
    private val onGetAlbum: (GetAlbumParams) -> Result<GetAlbumResult> = { fakeImplementationError() }
) : AlbumRemoteDataSource {

    override suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult> {
        return onGetAlbum(params)
    }
}