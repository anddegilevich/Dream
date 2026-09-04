package and.degilevich.dream.shared.feature.playlist.model.core.test.data

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData

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
