package and.degilevich.dream.shared.feature.album.source.impl.remote

import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource

internal class AlbumRemoteDataSourceImpl(
    private val getAlbumParamsToRequestMapper: GetAlbumParamsToRequestMapper,
    private val getAlbumResponseToResultMapper: GetAlbumResponseToResultMapper
) : BaseRemoteDataSource(), AlbumRemoteDataSource {

    override suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult> {
        return service.getAlbum(
            request = params.mapWith(getAlbumParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getAlbumResponseToResultMapper)
        }
    }
}