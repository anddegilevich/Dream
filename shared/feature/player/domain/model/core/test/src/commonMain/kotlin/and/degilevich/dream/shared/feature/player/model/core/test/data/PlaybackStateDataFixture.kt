package and.degilevich.dream.shared.feature.player.model.core.test.data

import and.degilevich.dream.shared.feature.player.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData

fun playbackStateData(
    trackId: String = "track-id",
    track: TrackData = trackData(id = trackId),
    isPlaying: Boolean = true,
    progressMs: Int = 20000,
    isShuffling: Boolean = false,
    deviceName: String = "Device Name"
): PlaybackStateData = PlaybackStateData(
    track = track,
    isPlaying = isPlaying,
    progressMs = progressMs,
    isShuffling = isShuffling,
    deviceName = deviceName
)
