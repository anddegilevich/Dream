package and.degilevich.dream.shared.feature.artist.data.api.local

import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

interface ArtistLocalDataSource {

    suspend fun saveArtists(artists: List<ArtistData>)
    suspend fun saveArtist(artist: ArtistData)
}