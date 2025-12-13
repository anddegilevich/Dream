package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import kotlinx.serialization.Serializable

@Serializable
sealed interface DashboardItemConfig : Identified {
    data object AlbumReleases : DashboardItemConfig {
        override val id: String = "albumReleases"
    }
}