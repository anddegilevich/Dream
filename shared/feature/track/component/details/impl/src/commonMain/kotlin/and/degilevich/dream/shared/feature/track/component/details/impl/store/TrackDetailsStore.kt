package and.degilevich.dream.shared.feature.track.component.details.impl.store

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.store.model.TrackDetailsState
import com.arkivanov.mvikotlin.core.store.Store

internal interface TrackDetailsStore : Store<TrackDetailsIntent, TrackDetailsState, TrackDetailsSideEffect>