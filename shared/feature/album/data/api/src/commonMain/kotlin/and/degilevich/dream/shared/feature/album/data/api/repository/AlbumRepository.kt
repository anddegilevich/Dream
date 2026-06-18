package and.degilevich.dream.shared.feature.album.data.api.repository

import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult

interface AlbumRepository {
    suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult>
    suspend fun cacheAlbum(album: AlbumData)
    suspend fun cacheAlbums(albums: List<SimplifiedAlbumData>)
}