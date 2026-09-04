package and.degilevich.dream.shared.feature.playlist.component.details.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.playlist.component.details.api.component.PlaylistDetailsComponent
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsIntent
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsSideEffect
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsState
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsUIState
import and.degilevich.dream.shared.feature.playlist.component.details.impl.view.PlaylistDetailsScreen
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class PlaylistDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: PlaylistDetailsNavArgs
) : BaseBinderComponent<
    PlaylistDetailsUIState,
    PlaylistDetailsIntent,
    PlaylistDetailsSideEffect,
    PlaylistDetailsState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        PlaylistDetailsDomainComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = PlaylistDetailsUIState.empty(),
    uiStateMapper = PlaylistDetailsUIStateMapper()
),
    PlaylistDetailsComponent {

    @Composable
    override fun Render() {
        PlaylistDetailsScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
