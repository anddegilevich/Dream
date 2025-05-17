package and.degilevich.dream.shared.core.service.api.model.album

import and.degilevich.dream.shared.core.service.api.model.track.TrackSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumTracksOutput(
    @SerialName("items")
    val items: List<TrackSimplifiedOutput>?
)