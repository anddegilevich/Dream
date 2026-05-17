package and.degilevich.dream.shared.navigation.api.model.args

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumId
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDetailsNavArgs(
    val albumId: AlbumId
)