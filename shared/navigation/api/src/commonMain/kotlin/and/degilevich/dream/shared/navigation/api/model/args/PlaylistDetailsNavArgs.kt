package and.degilevich.dream.shared.navigation.api.model.args

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistDetailsNavArgs(
    val playlistId: PlaylistId
)
