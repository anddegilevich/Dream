package and.degilevich.dream.shared.feature.album.component.releases.api.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
interface AlbumReleasesComponent :
    RenderMVIComponent<AlbumReleasesUIState, AlbumReleasesIntent, AlbumReleasesSideEffect> {

    @Composable
    override fun Render(modifier: Modifier) {
        AlbumReleasesCarousel(
            modifier = modifier,
            state = state(),
            onIntent = ::handleIntent
        )
    }
}