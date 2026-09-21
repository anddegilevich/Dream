package and.degilevich.dream.shated.feature.track.ui.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class TrackCardInfoUIData(
    val name: String,
    val artists: String
) {

    companion object : EmptyFactory<TrackCardInfoUIData> {

        override fun empty(): TrackCardInfoUIData {
            return TrackCardInfoUIData(
                name = "",
                artists = ""
            )
        }
    }
}
