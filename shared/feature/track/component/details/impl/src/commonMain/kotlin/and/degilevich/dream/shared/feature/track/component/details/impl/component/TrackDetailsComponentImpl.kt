package and.degilevich.dream.shared.feature.track.component.details.impl.component

import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.impl.store.TrackDetailsStoreComponent
import and.degilevich.dream.shared.feature.track.component.details.impl.store.model.TrackDetailsState
import and.degilevich.dream.shared.navigation.api.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.BaseUIStoreComponent
import com.arkivanov.decompose.ComponentContext

class TrackDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: TrackDetailsNavArgs
) : BaseUIStoreComponent<
    TrackDetailsUIState,
    TrackDetailsIntent,
    TrackDetailsSideEffect,
    TrackDetailsState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        TrackDetailsStoreComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = TrackDetailsUIState.empty(),
    uiStateMapper = TrackDetailsUIStateMapper()
),
    TrackDetailsComponent