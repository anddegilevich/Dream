package and.degilevich.dream.shared.feature.artist.data.impl.remote

import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.data.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistAlbumsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.data.impl.remote.BaseRemoteDataSource

internal class ArtistRemoteDataSourceImpl(
    private val getArtistParamsToRequestMapper: GetArtistParamsToRequestMapper,
    private val getArtistResponseToResultMapper: GetArtistResponseToResultMapper,
    private val getArtistAlbumsParamsToRequestMapper: GetArtistAlbumsParamsToRequestMapper,
    private val getArtistAlbumsResponseToResultMapper: GetArtistAlbumsResponseToResultMapper,
) : ArtistRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return service.getArtist(
            request = params.mapWith(getArtistParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistResponseToResultMapper)
        }
    }

    override suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return service.getArtistAlbums(
            request = params.mapWith(getArtistAlbumsParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistAlbumsResponseToResultMapper)
        }
    }
}