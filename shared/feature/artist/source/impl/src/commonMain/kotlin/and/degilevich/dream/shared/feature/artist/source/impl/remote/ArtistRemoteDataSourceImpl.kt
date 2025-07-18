package and.degilevich.dream.shared.feature.artist.source.impl.remote

import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistRelatedArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistTopTracksParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistTopTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess

internal class ArtistRemoteDataSourceImpl(
    private val getArtistParamsToRequestMapper: GetArtistParamsToRequestMapper,
    private val getArtistResponseToResultMapper: GetArtistResponseToResultMapper,
    private val getArtistsParamsToRequestMapper: GetArtistsParamsToRequestMapper,
    private val getArtistsResponseToResultMapper: GetArtistsResponseToResultMapper,
    private val getArtistsTopTracksParamsToRequestMapper: GetArtistTopTracksParamsToRequestMapper,
    private val getArtistsTopTracksResponseToResultMapper: GetArtistTopTracksResponseToResultMapper,
    private val getArtistsRelatedArtistsParamsToRequestMapper: GetArtistRelatedArtistsParamsToRequestMapper,
    private val getArtistsRelatedArtistsResponseToResultMapper: GetArtistRelatedArtistsResponseToResultMapper
) : ArtistRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return service.getArtist(
            request = params.mapWith(getArtistParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistResponseToResultMapper)
        }
    }

    override suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult> {
        return service.getArtists(
            request = params.mapWith(getArtistsParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistsResponseToResultMapper)
        }
    }

    override suspend fun getArtistTopTracks(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult> {
        return service.getArtistTopTracks(
            request = params.mapWith(getArtistsTopTracksParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistsTopTracksResponseToResultMapper)
        }
    }

    override suspend fun getArtistRelatedArtists(
        params: GetArtistRelatedArtistsParams
    ): Result<GetArtistRelatedArtistsResult> {
        return service.getArtistRelatedArtists(
            request = params.mapWith(getArtistsRelatedArtistsParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistsRelatedArtistsResponseToResultMapper)
        }
    }
}