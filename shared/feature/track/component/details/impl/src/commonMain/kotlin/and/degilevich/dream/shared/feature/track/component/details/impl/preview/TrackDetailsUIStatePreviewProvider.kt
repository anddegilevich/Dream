package and.degilevich.dream.shared.feature.track.component.details.impl.preview

import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class TrackDetailsUIStatePreviewProvider : LabeledPreviewParameterProvider<TrackDetailsUIState>() {

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = Skeleton.Loading
        )
    }

    fun provideDefault(): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = Skeleton.Value(TrackDetailsInfoLayoutUIDataPreviewProvider().provideDefault())
        )
    }
}