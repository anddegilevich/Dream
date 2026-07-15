package and.degilevich.dream.shared.feature.album.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.AlbumsApi
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.feature.base.data.impl.remote.BaseRemoteDataSource

internal class AlbumRemoteDataSourceImpl(
    private val albumOutputToDataMapper: AlbumOutputToDataMapper
) : BaseRemoteDataSource(), AlbumRemoteDataSource {

    private val albumsApi: AlbumsApi by lazy { apiService.albumsApi }

    override suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult> = runCatching {
        albumsApi.getAnAlbum(id = params.id.value).body()
    }.foldResultSuccess { response ->
        GetAlbumResult(
            album = response.mapWith(albumOutputToDataMapper)
        )
    }
}