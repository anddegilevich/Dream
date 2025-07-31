package and.degilevich.dream.shared.core.service.api.model.method.search

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchTracksOutput(
    @SerialName("items")
    val items: List<TrackOutput>?
)