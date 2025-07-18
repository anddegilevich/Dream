package and.degilevich.dream.shared.feature.album.source.api.remote

import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesResult

interface AlbumRemoteDataSource {
    suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult>
    suspend fun getNewReleases(params: GetNewReleasesParams): Result<GetNewReleasesResult>
}