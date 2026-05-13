package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
sealed interface DashboardItemConfig : Identified {

    @Serializable
    data object AlbumReleases : DashboardItemConfig {
        override val id: AnyIdentifier = identifier("albumReleases")
    }
}