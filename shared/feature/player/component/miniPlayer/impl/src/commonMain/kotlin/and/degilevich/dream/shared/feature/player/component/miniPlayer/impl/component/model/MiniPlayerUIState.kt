package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData
import androidx.compose.runtime.Immutable

@Immutable
data class MiniPlayerUIState(
    val coverUrl: String,
    val track: TrackCardInfoUIData,
    val progressFraction: Float,
    val isShuffling: Boolean,
    val isPlaying: Boolean
) {

    companion object : EmptyFactory<MiniPlayerUIState> {

        override fun empty(): MiniPlayerUIState {
            return MiniPlayerUIState(
                coverUrl = "",
                track = TrackCardInfoUIData.empty(),
                progressFraction = 0f,
                isShuffling = false,
                isPlaying = false
            )
        }
    }
}
