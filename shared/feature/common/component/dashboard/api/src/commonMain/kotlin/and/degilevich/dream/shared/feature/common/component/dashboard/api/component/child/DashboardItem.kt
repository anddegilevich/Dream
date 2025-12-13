package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import androidx.compose.runtime.Stable

@Stable
sealed interface DashboardItem {

    @Stable
    class AlbumReleases(
        component: AlbumReleasesComponent
    ) : DashboardItem, AlbumReleasesComponent by component
}