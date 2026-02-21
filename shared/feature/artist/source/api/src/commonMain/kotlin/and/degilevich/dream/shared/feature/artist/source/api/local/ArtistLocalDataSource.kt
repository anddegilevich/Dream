package and.degilevich.dream.shared.feature.artist.source.api.local

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

interface ArtistLocalDataSource {

    suspend fun saveArtists(artists: List<ArtistData>)
    suspend fun saveArtist(artist: ArtistData)
}