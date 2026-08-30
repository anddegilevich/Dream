package and.degilevich.dream.shared.feature.playlist.data.impl.local

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistLocalDataSource(
    private val onSavePlaylists: (List<SimplifiedPlaylistData>) -> Unit = { fakeImplementationError() }
) : PlaylistLocalDataSource {

    override suspend fun savePlaylists(playlists: List<SimplifiedPlaylistData>) {
        onSavePlaylists(playlists)
    }
}
