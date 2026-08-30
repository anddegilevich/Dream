package and.degilevich.dream.shared.feature.playlist.model.artifact.test.data

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData

fun simplifiedPlaylistData(
    id: String,
    description: String = "Description $id",
    totalTracks: Int = 1,
    images: List<ImageData> = emptyList()
): SimplifiedPlaylistData = SimplifiedPlaylistData(
    id = PlaylistId(value = id),
    name = "Playlist $id",
    description = description,
    totalTracks = totalTracks,
    images = images
)
