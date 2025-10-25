package and.degilevich.dream.shared.feature.album.component.releases.api.preview.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider.AlbumReleasesUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.decompose.preview.PreviewMVIComponent

class AlbumReleasesPreviewComponent :
    PreviewMVIComponent<AlbumReleasesUIState, AlbumReleasesIntent, AlbumReleasesSideEffect>(
        state = AlbumReleasesUIStatePreviewProvider.provide()
    ),
    AlbumReleasesComponent