package and.degilevich.dream.shared.feature.track.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class TrackDetailsUIStatePreviewProvider : PreviewParameterProvider<TrackDetailsUIState> {

    override val values: Sequence<TrackDetailsUIState> = sequenceOf(
        provideSkeleton(),
        provide()
    )

    fun provideSkeleton(): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = Skeleton.Loading
        )
    }

    fun provide(): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = Skeleton.Value(TrackDetailsInfoLayoutUIDataPreviewProvider().provide())
        )
    }
}