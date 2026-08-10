package and.degilevich.dream.shared.feature.artist.data.api.repository

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult

interface ArtistRepository {
    suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult>
    suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult>
    suspend fun cacheArtist(artist: ArtistData)
    suspend fun cacheArtists(artists: List<ArtistData>)
}