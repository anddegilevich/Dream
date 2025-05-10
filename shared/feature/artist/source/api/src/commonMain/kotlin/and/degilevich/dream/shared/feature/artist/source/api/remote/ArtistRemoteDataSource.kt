package and.degilevich.dream.shared.feature.artist.source.api.remote

import and.degilevich.dream.shared.template.source.remote.RemoteDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsResult

interface ArtistRemoteDataSource : RemoteDataSource {
    suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult>
    suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult>
    suspend fun getArtistTopTracks(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult>
    suspend fun getArtistRelatedArtists(
        params: GetArtistRelatedArtistsParams
    ): Result<GetArtistRelatedArtistsResult>
}