package and.degilevich.dream.shared.feature.artist.core.impl.source.remote

import and.degilevich.dream.shared.common.source.remote.AbstractRemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.api.model.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource

//FIXME: Add proper implementation
@Suppress("MagicNumber")
internal class ArtistRemoteDataSourceImpl : ArtistRemoteDataSource, AbstractRemoteDataSource() {
    override suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse> {
        return Result.success(
            GetArtistResponse(
                artist = ArtistData(
                    id = "1",
                    name = "Test artist 1"
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