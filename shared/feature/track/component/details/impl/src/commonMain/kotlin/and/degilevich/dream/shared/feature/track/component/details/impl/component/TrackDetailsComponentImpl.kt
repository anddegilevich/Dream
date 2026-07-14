package and.degilevich.dream.shared.feature.track.component.details.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsState
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.impl.view.TrackDetailsScreen
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class TrackDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: TrackDetailsNavArgs
) : BaseBinderComponent<
    TrackDetailsUIState,
    TrackDetailsIntent,
    TrackDetailsSideEffect,
    TrackDetailsState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        TrackDetailsDomainComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = TrackDetailsUIState.empty(),
    uiStateMapper = TrackDetailsUIStateMapper()
),
    TrackDetailsComponent {

    @Composable
    override fun Render() {
        TrackDetailsScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}