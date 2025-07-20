package and.degilevich.dream.shared.navigation.api.args

import kotlinx.serialization.Serializable

@Serializable
data class TrackDetailsNavArgs(
    val trackId: String
)