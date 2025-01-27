package and.degilevich.dream.shared.feature.artist.core.impl.source.local

import and.degilevich.dream.shared.common.source.local.AbstractLocalDataSource
import and.degilevich.dream.shared.feature.artist.core.api.model.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource

//FIXME: Add proper implementation
@Suppress("MagicNumber")
internal class ArtistLocalDataSourceImpl : ArtistLocalDataSource, AbstractLocalDataSource() {

    override suspend fun getArtist(id: String): Result<ArtistData> {
        return Result.success(
            ArtistData(
                id = "1",
                name = "Test artist 1"
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
                            ArtistData(
                                id = i.toString(),
                                name = "Test artist $i"
                            )
                        )
                    }
                }
            )
        )
    }
}