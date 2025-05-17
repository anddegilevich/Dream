package and.degilevich.dream.shared.feature.album.component.releases.api.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface AlbumReleasesComponent : MVIComponent<AlbumReleasesUIState, AlbumReleasesIntent, AlbumReleasesSideEffect>