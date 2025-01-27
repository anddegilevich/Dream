package and.degilevich.dream.shared.feature.artist.core.api.source.remote

import and.degilevich.dream.shared.common.source.remote.RemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsResponse

interface ArtistRemoteDataSource : RemoteDataSource {
    suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse>
    suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse>
}