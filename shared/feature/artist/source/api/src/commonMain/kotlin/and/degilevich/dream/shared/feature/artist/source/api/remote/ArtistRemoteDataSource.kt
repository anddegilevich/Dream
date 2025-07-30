package and.degilevich.dream.shared.feature.artist.source.api.remote

import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsResult

interface ArtistRemoteDataSource {
    suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult>
    suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult>
    suspend fun getArtistTopTracks(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult>
    suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult>
    suspend fun getArtistRelatedArtists(
        params: GetArtistRelatedArtistsParams
    ): Result<GetArtistRelatedArtistsResult>
}