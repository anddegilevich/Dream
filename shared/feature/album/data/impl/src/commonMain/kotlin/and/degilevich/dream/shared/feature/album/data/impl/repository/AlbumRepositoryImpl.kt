package and.degilevich.dream.shared.feature.album.data.impl.repository

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.data.impl.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.data.impl.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult

internal class AlbumRepositoryImpl(
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource
) : AlbumRepository {

    override suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult> {
        return albumRemoteDataSource.getAlbum(params = params)
    }

    override suspend fun cacheAlbum(album: AlbumData) {
        albumLocalDataSource.saveAlbum(album = album)
    }

    override suspend fun cacheAlbums(albums: List<SimplifiedAlbumData>) {
        albumLocalDataSource.saveAlbums(albums = albums)
    }
}
