package and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider.AlbumReleasesUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState

object DashboardUIStatePreviewProvider {
    fun provide(): DashboardUIState {
        return DashboardUIState(
            albumReleasesCarousel = AlbumReleasesUIStatePreviewProvider.provide()
        )
    }
}