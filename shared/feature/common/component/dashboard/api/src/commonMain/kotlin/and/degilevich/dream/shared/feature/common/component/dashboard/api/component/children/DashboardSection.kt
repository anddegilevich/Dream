package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.children

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import androidx.compose.runtime.Stable

@Stable
sealed interface DashboardSection {

    @Stable
    class AlbumReleases(
        component: AlbumReleasesComponent
    ) : DashboardSection, AlbumReleasesComponent by component
}