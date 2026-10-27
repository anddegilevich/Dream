package and.degilevich.dream.shared.feature.player.domain.model.core.api.data

import and.degilevich.dream.shared.feature.track.domain.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable

@Serializable
data class PlaybackStateData(
    val track: TrackData,
    val isPlaying: Boolean,
    val progressMs: Int,
    val isShuffling: Boolean,
    val deviceName: String
) {

    companion object : EmptyFactory<PlaybackStateData> {

        override fun empty(): PlaybackStateData {
            return PlaybackStateData(
                track = TrackData.empty(),
                isPlaying = false,
                progressMs = 0,
                isShuffling = false,
                deviceName = ""
            )
        }
    }
}
