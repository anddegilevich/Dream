package and.degilevich.dream.shared.feature.playlist.data.impl.local

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData

internal interface PlaylistLocalDataSource {
    suspend fun savePlaylist(playlist: PlaylistData)
    suspend fun savePlaylists(playlists: List<SimplifiedPlaylistData>)
}
