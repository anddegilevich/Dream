package and.degilevich.dream.shared.feature.track.component.details.api.component

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import androidx.compose.runtime.Stable

@Stable
interface TrackDetailsComponent : MVIComponent<TrackDetailsUIState, TrackDetailsIntent, TrackDetailsSideEffect>