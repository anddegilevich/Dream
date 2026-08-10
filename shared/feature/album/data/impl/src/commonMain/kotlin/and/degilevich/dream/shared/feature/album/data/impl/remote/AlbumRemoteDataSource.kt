package and.degilevich.dream.shared.feature.album.data.impl.remote

import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult

internal interface AlbumRemoteDataSource {
    suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult>
}