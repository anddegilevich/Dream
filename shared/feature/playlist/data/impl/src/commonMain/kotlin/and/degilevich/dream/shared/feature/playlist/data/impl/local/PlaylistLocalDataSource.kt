package and.degilevich.dream.shared.feature.playlist.data.impl.local

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData

internal interface PlaylistLocalDataSource {
    suspend fun savePlaylists(playlists: List<SimplifiedPlaylistData>)
}
