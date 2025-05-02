package and.degilevich.dream.shared.feature.artist.core.impl.source.remote

import and.degilevich.dream.shared.template.source.remote.RemoteDataSourceTemplate
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess

internal class ArtistRemoteDataSourceImpl(
    private val getArtistParamsToRequestMapper: GetArtistParamsToRequestMapper,
    private val getArtistResponseToResultMapper: GetArtistResponseToResultMapper,
    private val getArtistsParamsToRequestMapper: GetArtistsParamsToRequestMapper,
    private val getArtistsResponseToResultMapper: GetArtistsResponseToResultMapper
) : ArtistRemoteDataSource, RemoteDataSourceTemplate() {
    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return service.getArtist(params.mapWith(getArtistParamsToRequestMapper)).foldResultSuccess { response ->
            response.mapWith(getArtistResponseToResultMapper)
        }
    }

    override suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult> {
        return service.getArtists(params.mapWith(getArtistsParamsToRequestMapper)).foldResultSuccess { response ->
            response.mapWith(getArtistsResponseToResultMapper)
        }
    }
}