package and.degilevich.dream.shared.feature.artist.data.impl.local

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistLocalDataSource(
    private val onSaveArtists: (List<ArtistData>) -> Unit = { fakeImplementationError() },
    private val onSaveArtist: (ArtistData) -> Unit = { fakeImplementationError() }
) : ArtistLocalDataSource {

    override suspend fun saveArtists(artists: List<ArtistData>) {
        onSaveArtists(artists)
    }

    override suspend fun saveArtist(artist: ArtistData) {
        onSaveArtist(artist)
    }
}
