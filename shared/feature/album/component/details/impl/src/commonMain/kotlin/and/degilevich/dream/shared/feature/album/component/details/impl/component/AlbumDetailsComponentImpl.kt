package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.view.AlbumDetailsScreen
import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class AlbumDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: AlbumDetailsNavArgs
) : BaseBinderComponent<
    AlbumDetailsUIState,
    AlbumDetailsIntent,
    AlbumDetailsSideEffect,
    AlbumDetailsState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        AlbumDetailsDomainComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = AlbumDetailsUIState.empty(),
    uiStateMapper = AlbumDetailsUIStateMapper()
),
    AlbumDetailsComponent {

    @Composable
    override fun Render() {
        AlbumDetailsScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}