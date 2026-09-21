package and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model

import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistDetailsState(
    val navArgs: PlaylistDetailsNavArgs,
    val playlist: PlaylistData,
    val tracks: List<PlaylistTrackData>,
    val total: Int,
    val isLoadingTracks: Boolean
)
