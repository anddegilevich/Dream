package and.degilevich.dream.shared.navigation.api.model.args

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDetailsNavArgs(
    val albumId: Identifier
)