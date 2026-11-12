package and.degilevich.dream.shared.feature.player.component.player.impl.component.model

import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData
import androidx.compose.runtime.Immutable

@Immutable
data class PlayerUIState(
    val coverUrl: String,
    val track: TrackCardInfoUIData,
    val progress: PlaybackProgressUIData,
    val isShuffling: Boolean,
    val isPlaying: Boolean
) {

    companion object : EmptyFactory<PlayerUIState> {

        override fun empty(): PlayerUIState {
            return PlayerUIState(
                coverUrl = "",
                track = TrackCardInfoUIData.empty(),
                progress = PlaybackProgressUIData.empty(),
                isShuffling = false,
                isPlaying = false
            )
        }
    }
}
