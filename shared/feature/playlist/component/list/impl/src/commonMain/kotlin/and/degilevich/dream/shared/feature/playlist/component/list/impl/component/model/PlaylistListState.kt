package and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistListState(
    val isLoading: Boolean,
    val playlists: List<SimplifiedPlaylistData>
)
