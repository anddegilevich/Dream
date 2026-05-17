package and.degilevich.dream.shared.navigation.api.model.args

import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import kotlinx.serialization.Serializable

@Serializable
data class TrackDetailsNavArgs(
    val trackId: TrackId
)