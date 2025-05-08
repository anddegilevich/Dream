package and.degilevich.dream.shared.core.service.api.core.album

import and.degilevich.dream.shared.core.service.api.core.track.TrackSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumTracksOutput(
    @SerialName("items")
    val items: List<TrackSimplifiedOutput>?
)