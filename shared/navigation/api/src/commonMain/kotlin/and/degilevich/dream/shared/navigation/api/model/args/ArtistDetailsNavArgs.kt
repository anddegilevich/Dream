package and.degilevich.dream.shared.navigation.api.model.args

import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsNavArgs(
    val artistId: String
)