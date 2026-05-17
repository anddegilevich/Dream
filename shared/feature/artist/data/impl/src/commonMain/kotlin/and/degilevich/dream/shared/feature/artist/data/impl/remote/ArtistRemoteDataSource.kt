package and.degilevich.dream.shared.feature.artist.data.impl.remote

import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult

internal interface ArtistRemoteDataSource {
    suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult>
    suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult>
}