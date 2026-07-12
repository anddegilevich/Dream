package and.degilevich.dream.shared.feature.album.component.releases.impl.preview

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.view.AlbumReleasesCarousel
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewMVIComponent
import androidx.compose.runtime.Composable

class AlbumReleasesPreviewComponent :
    PreviewMVIComponent<AlbumReleasesUIState, AlbumReleasesIntent, AlbumReleasesSideEffect>(
        state = AlbumReleasesUIStatePreviewProvider().provideDefault()
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
