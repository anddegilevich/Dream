package and.degilevich.dream.shared.feature.artist.core.impl.source.remote

import and.degilevich.dream.shared.template.source.remote.AbstractRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.mapToResult
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.mapToRequest
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.ArtistFollowersData

//FIXME: Add proper implementation
@Suppress("MagicNumber")
internal class ArtistRemoteDataSourceImpl : ArtistRemoteDataSource, AbstractRemoteDataSource() {
    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return Result.success(
            GetArtistResult(
                artist = ArtistData.Base(
                    id = "1",
                    name = "Test artist 1",
                    type = ArtistType.ARTIST,
                    popularity = 100,
                    genres = listOf("pop", "rock"),
                    followers = ArtistFollowersData.Base(
                        total = 100
                    ),
                    images = emptyList()
                )
            )
        )
    }

    override suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult> {
        val response = service.getArtists(params.mapToRequest())
        return Result.success(response.mapToResult())
    }
}