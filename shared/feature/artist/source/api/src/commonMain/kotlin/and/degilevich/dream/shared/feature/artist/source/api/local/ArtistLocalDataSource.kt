package and.degilevich.dream.shared.feature.artist.source.api.local

import and.degilevich.dream.shared.template.source.local.LocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsParams

interface ArtistLocalDataSource : LocalDataSource {
    suspend fun getArtist(id: String): Result<ArtistData>
    suspend fun saveArtist(artist: ArtistData)
    suspend fun saveArtists(artists: List<ArtistData>)
    suspend fun getArtists(params: GetArtistsParams): List<ArtistData>
}