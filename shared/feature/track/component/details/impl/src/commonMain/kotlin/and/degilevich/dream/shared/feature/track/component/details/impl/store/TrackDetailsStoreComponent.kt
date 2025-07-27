package and.degilevich.dream.shared.feature.track.component.details.impl.store

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.store.model.TrackDetailsState
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class TrackDetailsStoreComponent(
    componentContext: ComponentContext,
    navArgs: TrackDetailsNavArgs
) : BaseStoreComponent<
    TrackDetailsState,
    TrackDetailsIntent,
    TrackDetailsSideEffect
    >(
    componentContext = componentContext,
    storeFactory = TrackDetailsStoreFactory(),
    stateConservator = TrackDetailsStateConservator(
        navArgs = navArgs
    )
)