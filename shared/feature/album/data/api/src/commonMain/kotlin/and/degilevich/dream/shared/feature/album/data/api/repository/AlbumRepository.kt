package and.degilevich.dream.shared.feature.album.data.api.repository

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult

interface AlbumRepository {
    suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult>
    suspend fun cacheAlbum(album: AlbumData)
    suspend fun cacheAlbums(albums: List<SimplifiedAlbumData>)
}