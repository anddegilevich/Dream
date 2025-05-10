package and.degilevich.dream.shared.feature.album.source.impl.remote

import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetNewReleasesParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetNewReleasesResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.RemoteDataSourceTemplate

internal class AlbumRemoteDataSourceImpl(
    private val getAlbumParamsToRequestMapper: GetAlbumParamsToRequestMapper,
    private val getAlbumResponseToResultMapper: GetAlbumResponseToResultMapper,
    private val getNewReleasesParamsToRequestMapper: GetNewReleasesParamsToRequestMapper,
    private val getNewReleasesResponseToResultMapper: GetNewReleasesResponseToResultMapper,
) : RemoteDataSourceTemplate(), AlbumRemoteDataSource {
    override suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult> {
        return service.getAlbum(
            request = params.mapWith(getAlbumParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getAlbumResponseToResultMapper)
        }
    }

    override suspend fun getNewReleases(params: GetNewReleasesParams): Result<GetNewReleasesResult> {
        return service.getNewReleases(
            request = params.mapWith(getNewReleasesParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getNewReleasesResponseToResultMapper)
        }
    }
}