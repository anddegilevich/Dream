package and.degilevich.dream.shared.feature.track.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable

@Immutable
data class TrackDetailsUIState(
    val info: Skeleton<TrackDetailsInfoLayoutUIData>
) {
    companion object : EmptyFactory<TrackDetailsUIState> {
        override fun empty(): TrackDetailsUIState {
            return TrackDetailsUIState(
                info = Skeleton.Loading
            )
        }
    }
}