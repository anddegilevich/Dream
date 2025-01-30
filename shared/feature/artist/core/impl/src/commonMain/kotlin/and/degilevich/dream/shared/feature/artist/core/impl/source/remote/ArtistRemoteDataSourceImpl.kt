package and.degilevich.dream.shared.feature.artist.core.impl.source.remote

import and.degilevich.dream.shared.template.source.remote.AbstractRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.ArtistFollowersData

//FIXME: Add proper implementation
@Suppress("MagicNumber")
internal class ArtistRemoteDataSourceImpl : ArtistRemoteDataSource, AbstractRemoteDataSource() {
    override suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse> {
        return Result.success(
            GetArtistResponse(
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

    override suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse> {
        val count = 10
        return Result.success(
            GetArtistsResponse(
                count = count,
                artists = buildList {
                    for (i in 1..10) {
                        add(
                            ArtistData.Base(
                                id = i.toString(),
                                name = "Test artist $i",
                                type = ArtistType.ARTIST,
                                popularity = 100,
                                genres = listOf("pop", "rock"),
                                followers = ArtistFollowersData.Base(
                                    total = 100
                                ),
                                images = emptyList()
                            )
                        )
                    }
                }
            )
        )
    }
}