package and.degilevich.dream.shared.feature.artist.core.impl.source.local

import and.degilevich.dream.shared.template.source.local.AbstractLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.ArtistFollowersData

//FIXME: Add proper implementation
@Suppress("MagicNumber")
internal class ArtistLocalDataSourceImpl : ArtistLocalDataSource, AbstractLocalDataSource() {

    override suspend fun getArtist(id: String): Result<ArtistData> {
        return Result.success(
            ArtistData.Base(
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
    }

    override suspend fun saveArtist(artist: ArtistData): Result<Boolean> {
        return Result.success(false)
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