package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class DashboardUIState(
    val albumReleasesCarousel: AlbumReleasesUIState
) {
    companion object : EmptyFactory<DashboardUIState> {
        override fun empty(): DashboardUIState {
            return DashboardUIState(
                albumReleasesCarousel = AlbumReleasesUIState.empty()
            )
        }
    }
}