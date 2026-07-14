package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesState
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.view.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class AlbumReleasesComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    AlbumReleasesUIState,
    AlbumReleasesIntent,
    AlbumReleasesSideEffect,
    AlbumReleasesState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        AlbumReleasesDomainComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = AlbumReleasesUIState.empty(),
    uiStateMapper = AlbumReleasesUIStateMapper()
),
    AlbumReleasesComponent {

    @Composable
    override fun Render() {
        AlbumReleasesCarousel(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}