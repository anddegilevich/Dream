package and.degilevich.dream.shared.feature.artist.source.api.remote

import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsResult

interface ArtistRemoteDataSource {
    suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult>
    suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult>
    suspend fun getArtistTopTracks(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult>
    suspend fun getArtistRelatedArtists(
        params: GetArtistRelatedArtistsParams
    ): Result<GetArtistRelatedArtistsResult>
}