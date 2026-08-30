package and.degilevich.dream.shared.feature.playlist.model.artifact.api.abstraction

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.foundation.abstraction.id.Identified

interface PlaylistInfo : Identified {
    override val id: PlaylistId
    val name: String
    val description: String
    val totalTracks: Int
    val images: List<ImageData>
}
