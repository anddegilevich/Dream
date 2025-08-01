package and.degilevich.dream.shared.feature.track.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton

object TrackDetailsUIStatePreviewProvider {
    fun provide(): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = Skeleton.Value(TrackDetailsInfoLayoutUIDataPreviewProvider.provide())
        )
    }

    fun provideSkeleton(): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = Skeleton.Loading
        )
    }
}