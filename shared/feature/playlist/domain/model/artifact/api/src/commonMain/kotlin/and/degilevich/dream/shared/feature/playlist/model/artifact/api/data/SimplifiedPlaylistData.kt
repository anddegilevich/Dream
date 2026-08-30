package and.degilevich.dream.shared.feature.playlist.model.artifact.api.data

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.abstraction.PlaylistInfo
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class SimplifiedPlaylistData(
    override val id: PlaylistId,
    override val name: String,
    override val description: String,
    override val totalTracks: Int,
    override val images: List<ImageData>,
) : AbstractIdentified(), PlaylistInfo {

    companion object : EmptyFactory<SimplifiedPlaylistData> {

        override fun empty(): SimplifiedPlaylistData {
            return SimplifiedPlaylistData(
                id = PlaylistId.empty(),
                name = "",
                description = "",
                totalTracks = 0,
                images = emptyList()
            )
        }
    }
}
