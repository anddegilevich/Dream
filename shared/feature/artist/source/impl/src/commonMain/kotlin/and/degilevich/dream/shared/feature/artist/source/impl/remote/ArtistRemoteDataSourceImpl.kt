package and.degilevich.dream.shared.feature.artist.source.impl.remote

import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistAlbumsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistRelatedArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistTopTracksParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistTopTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
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
    private val getArtistsRelatedArtistsResponseToResultMapper: GetArtistRelatedArtistsResponseToResultMapper,
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

    override suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return service.getArtistAlbums(
            request = params.mapWith(getArtistAlbumsParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getArtistAlbumsResponseToResultMapper)
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