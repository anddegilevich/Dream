package and.degilevich.dream.shared.core.db.test.entity

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity

fun playlistEntity(
    id: String,
    totalTracks: Int = 1
): PlaylistEntity = PlaylistEntity(
    id = id,
    name = "Playlist $id",
    description = "Description $id",
    totalTracks = totalTracks
)
