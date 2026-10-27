package and.degilevich.dream.shared.feature.player.ui.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class PlaybackProgressUIData(
    val fraction: Float,
    val elapsed: String,
    val remaining: String
) {

    companion object : EmptyFactory<PlaybackProgressUIData> {

        override fun empty(): PlaybackProgressUIData {
            return PlaybackProgressUIData(
                fraction = 0f,
                elapsed = "",
                remaining = ""
            )
        }
    }
}
