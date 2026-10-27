package and.degilevich.dream.shared.feature.playlist.domain.model.core.test.data

import and.degilevich.dream.shared.feature.image.domain.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.playlist.domain.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.domain.model.core.api.data.PlaylistData

fun playlistData(
    id: String,
    description: String = "Description $id",
    totalTracks: Int = 1,
    images: List<ImageData> = emptyList()
): PlaylistData = PlaylistData(
    id = PlaylistId(value = id),
    name = "Playlist $id",
    description = description,
    totalTracks = totalTracks,
    images = images
)
