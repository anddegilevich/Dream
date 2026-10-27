package and.degilevich.dream.shared.feature.player.model.core.api.method.getPlaybackState

import and.degilevich.dream.shared.feature.player.model.core.api.data.PlaybackStateData

sealed interface GetPlaybackStateResult {

    /**
     * No active playback: no active device, or nothing is playing.
     */
    data object None : GetPlaybackStateResult

    data class Value(
        val playbackState: PlaybackStateData
    ) : GetPlaybackStateResult
}
