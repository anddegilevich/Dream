package and.degilevich.dream.shared.feature.artist.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.ArtistsApi
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.data.impl.remote.BaseRemoteDataSource

internal class ArtistRemoteDataSourceImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper,
    private val getArtistAlbumsResponseToResultMapper: GetArtistAlbumsResponseToResultMapper,
) : ArtistRemoteDataSource, BaseRemoteDataSource() {

    private val artistApi: ArtistsApi by lazy { apiService.artistsApi }

    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> = runCatching {
        artistApi.getAnArtist(id = params.id.value).body()
    }.foldResultSuccess { response ->
        GetArtistResult(
            artist = response.mapWith(artistOutputToDataMapper)
        )
    }

    override suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> = runCatching {
        artistApi.getAnArtistsAlbums(
            id = params.id.value,
            limit = params.limit,
            offset = params.offset,
        ).body()
    }.foldResultSuccess { response ->
        response.mapWith(getArtistAlbumsResponseToResultMapper)
    }
}