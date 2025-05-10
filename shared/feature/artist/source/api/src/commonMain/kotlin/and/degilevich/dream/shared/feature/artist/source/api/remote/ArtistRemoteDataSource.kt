package and.degilevich.dream.shared.feature.artist.source.api.remote

import and.degilevich.dream.shared.template.source.remote.RemoteDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsResult

interface ArtistRemoteDataSource : RemoteDataSource {
    suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult>
    suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult>
}