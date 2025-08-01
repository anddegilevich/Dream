package and.degilevich.dream.shared.feature.track.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class TrackDetailsInfoLayoutUIData(
    val album: String,
    val albumIconUrl: String,
    val name: String,
    val artists: String
) {
    companion object : EmptyFactory<TrackDetailsInfoLayoutUIData> {
        override fun empty(): TrackDetailsInfoLayoutUIData {
            return TrackDetailsInfoLayoutUIData(
                album = "",
                albumIconUrl = "",
                name = "",
                artists = ""
            )
        }
    }
}