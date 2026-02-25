package and.degilevich.dream.shared.feature.album.component.releases.api.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.api.provider.AlbumReleasesUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewMVIComponent

class AlbumReleasesPreviewComponent :
    PreviewMVIComponent<AlbumReleasesUIState, AlbumReleasesIntent, AlbumReleasesSideEffect>(
        state = AlbumReleasesUIStatePreviewProvider().provide()
    ),
    AlbumReleasesComponent