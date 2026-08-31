package and.degilevich.dream.shared.feature.track.component.liked.impl.component.model

import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import kotlinx.serialization.Serializable

@Serializable
data class LikedTracksState(
    val tracks: List<SavedTrackData>,
    val total: Int,
    val isLoadingTracks: Boolean
)
