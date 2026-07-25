package and.degilevich.dream.shared.navigation.api.model.args

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsNavArgs(
    val artistId: ArtistId
)