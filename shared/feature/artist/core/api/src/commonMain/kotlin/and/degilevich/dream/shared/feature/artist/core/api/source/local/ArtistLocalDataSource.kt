package and.degilevich.dream.shared.feature.artist.core.api.source.local

import and.degilevich.dream.shared.template.source.local.LocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams

interface ArtistLocalDataSource : LocalDataSource {
    suspend fun getArtist(id: String): Result<ArtistData>
    suspend fun saveArtist(artist: ArtistData)
    suspend fun saveArtists(artists: List<ArtistData>)
    suspend fun getArtists(params: GetArtistsParams): List<ArtistData>
}