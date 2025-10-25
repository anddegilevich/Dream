package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import kotlinx.serialization.Serializable

@Serializable
sealed interface DashboardSectionConfig : Identified {
    data object AlbumReleases : DashboardSectionConfig {
        override val id: String = "albumReleases"
    }
}