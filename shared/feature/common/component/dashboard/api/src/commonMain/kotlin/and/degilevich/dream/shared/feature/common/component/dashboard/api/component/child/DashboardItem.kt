package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.category.component.list.api.component.CategoryListComponent
import androidx.compose.runtime.Stable

@Stable
sealed interface DashboardItem {

    @Stable
    class AlbumReleases(
        component: AlbumReleasesComponent
    ) : DashboardItem, AlbumReleasesComponent by component
    @Stable
    class CategoryList(
        component: CategoryListComponent
    ) : DashboardItem, CategoryListComponent by component
}