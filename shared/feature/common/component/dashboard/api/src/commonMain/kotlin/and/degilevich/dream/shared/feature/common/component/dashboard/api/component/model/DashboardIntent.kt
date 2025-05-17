package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent

sealed interface DashboardIntent {
    data class OnAlbumReleasesIntent(val intent: AlbumReleasesIntent) : DashboardIntent
}