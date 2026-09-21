package and.degilevich.dream.shared.feature.player.model.core.test.data

import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData

fun playHistoryData(
    id: String,
    playedAt: String = "2024-01-01T00:00:00Z",
    track: TrackData = trackData(id = id)
): PlayHistoryData = PlayHistoryData(
    track = track,
    playedAt = playedAt
)
