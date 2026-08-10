package and.degilevich.dream.shared.core.db.test.entity

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity

fun trackEntity(
    id: String,
    albumId: String? = null,
    trackNumber: Int = 1,
    durationMs: Int = 1000
): TrackEntity = TrackEntity(
    id = id,
    name = "Track $id",
    albumId = albumId,
    trackNumber = trackNumber,
    durationMs = durationMs
)
