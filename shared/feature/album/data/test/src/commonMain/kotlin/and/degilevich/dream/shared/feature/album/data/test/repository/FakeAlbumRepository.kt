package and.degilevich.dream.shared.feature.album.data.test.repository

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumRepository(
    private val onGetAlbum: (params: GetAlbumParams) -> Result<GetAlbumResult> = { fakeImplementationError() },
    private val onCacheAlbum: (AlbumData) -> Unit = { fakeImplementationError() },
    private val onCacheAlbums: (List<SimplifiedAlbumData>) -> Unit = { fakeImplementationError() }
) : AlbumRepository {

    override suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult> = onGetAlbum(params)

    override suspend fun cacheAlbum(album: AlbumData) = onCacheAlbum(album)

    override suspend fun cacheAlbums(albums: List<SimplifiedAlbumData>) = onCacheAlbums(albums)
}