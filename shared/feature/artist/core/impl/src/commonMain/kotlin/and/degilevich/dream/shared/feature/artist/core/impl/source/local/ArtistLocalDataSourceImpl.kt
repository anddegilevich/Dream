package and.degilevich.dream.shared.feature.artist.core.impl.source.local

import and.degilevich.dream.shared.template.source.local.AbstractLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistFollowersData

//FIXME: Add proper implementation
@Suppress("MagicNumber")
internal class ArtistLocalDataSourceImpl : ArtistLocalDataSource, AbstractLocalDataSource() {

    override suspend fun getArtist(id: String): Result<ArtistData> {
        return Result.success(
            ArtistData(
                id = "1",
                name = "Test artist 1",
                artistType = ArtistType.ARTIST,
                popularity = 100,
                genres = listOf("pop", "rock"),
                followers = ArtistFollowersData(
                    total = 100
                ),
                images = emptyList()
            )
        )
    }

    override suspend fun saveArtist(artist: ArtistData): Result<Boolean> {
        return Result.success(false)
    }

    override suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult> {
        return Result.success(
            GetArtistsResult(
                artists = buildList {
                    for (i in 1..10) {
                        add(
                            ArtistData(
                                id = i.toString(),
                                name = "Test artist $i",
                                artistType = ArtistType.ARTIST,
                                popularity = 100,
                                genres = listOf("pop", "rock"),
                                followers = ArtistFollowersData(
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