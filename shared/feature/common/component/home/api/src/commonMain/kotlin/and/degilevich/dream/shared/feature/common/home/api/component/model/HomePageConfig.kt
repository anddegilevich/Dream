package and.degilevich.dream.shared.feature.common.home.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import kotlinx.serialization.Serializable

@Serializable
sealed interface HomePageConfig : Identified {

    @Serializable
    data object Dashboard : HomePageConfig {
        override val id: String = "dashboard"
    }

    @Serializable
    data object Search : HomePageConfig {
        override val id: String = "search"
    }
}