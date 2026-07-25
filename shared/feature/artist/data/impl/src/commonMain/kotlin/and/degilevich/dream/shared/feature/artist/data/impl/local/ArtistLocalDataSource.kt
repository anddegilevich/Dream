package and.degilevich.dream.shared.feature.artist.data.impl.local

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

internal interface ArtistLocalDataSource {

    suspend fun saveArtists(artists: List<ArtistData>)
    suspend fun saveArtist(artist: ArtistData)
}