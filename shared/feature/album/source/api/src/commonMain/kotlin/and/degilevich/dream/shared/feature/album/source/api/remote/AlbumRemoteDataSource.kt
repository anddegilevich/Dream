package and.degilevich.dream.shared.feature.album.source.api.remote

import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult

interface AlbumRemoteDataSource {
    suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult>
}