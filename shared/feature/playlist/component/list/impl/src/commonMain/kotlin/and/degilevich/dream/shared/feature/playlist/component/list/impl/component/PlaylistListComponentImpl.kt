package and.degilevich.dream.shared.feature.playlist.component.list.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListIntent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListSideEffect
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListState
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListUIState
import and.degilevich.dream.shared.feature.playlist.component.list.impl.view.PlaylistListCarousel
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class PlaylistListComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    PlaylistListUIState,
    PlaylistListIntent,
    PlaylistListSideEffect,
    PlaylistListState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        PlaylistListDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = PlaylistListUIState.empty(),
    uiStateMapper = PlaylistListUIStateMapper()
),
    PlaylistListComponent {

    @Composable
    override fun Render() {
        PlaylistListCarousel(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
