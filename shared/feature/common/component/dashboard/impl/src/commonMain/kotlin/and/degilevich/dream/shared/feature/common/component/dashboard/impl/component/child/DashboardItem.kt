package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.child

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponent
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Stable

@Stable
sealed interface DashboardItem : RenderComponent {

    @Stable
    class AlbumReleases(
        component: AlbumReleasesComponent
    ) : DashboardItem, AlbumReleasesComponent by component

    @Stable
    class PlaylistList(
        component: PlaylistListComponent
    ) : DashboardItem, PlaylistListComponent by component
}