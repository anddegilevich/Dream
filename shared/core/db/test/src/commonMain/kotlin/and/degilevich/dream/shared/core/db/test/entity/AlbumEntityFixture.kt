package and.degilevich.dream.shared.core.db.test.entity

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity

fun albumEntity(
    id: String,
    albumType: String = "album",
    totalTracks: Int = 1
): AlbumEntity = AlbumEntity(
    id = id,
    name = "Album $id",
    albumType = albumType,
    totalTracks = totalTracks,
    releaseDate = "2021-01-01"
)
