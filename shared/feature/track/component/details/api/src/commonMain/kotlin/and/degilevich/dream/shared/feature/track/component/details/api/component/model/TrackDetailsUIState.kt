package and.degilevich.dream.shared.feature.track.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class TrackDetailsUIState(
    val album: String,
    val albumIconUrl: String,
    val name: String,
    val artists: String
) {
    companion object : EmptyFactory<TrackDetailsUIState> {
        override fun empty(): TrackDetailsUIState {
            return TrackDetailsUIState(
                album = "",
                albumIconUrl = "",
                name = "",
                artists = ""
            )
        }
    }
}