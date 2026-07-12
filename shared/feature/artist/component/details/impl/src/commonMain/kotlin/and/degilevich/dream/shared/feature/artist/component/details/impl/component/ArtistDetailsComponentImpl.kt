package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.view.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

class ArtistDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: ArtistDetailsNavArgs
) : BaseBinderComponent<
    ArtistDetailsUIState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect,
    ArtistDetailsState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        ArtistDetailsDomainComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = ArtistDetailsUIState.empty(),
    uiStateMapper = ArtistDetailsUIStateMapper()
),
    ArtistDetailsComponent {

    @Composable
    override fun Render() {
        ArtistDetailsScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}