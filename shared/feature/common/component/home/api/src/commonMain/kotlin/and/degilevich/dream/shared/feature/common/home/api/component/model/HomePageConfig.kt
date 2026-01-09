package and.degilevich.dream.shared.feature.common.home.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
sealed interface HomePageConfig : Identified {

    @Serializable
    data object Dashboard : HomePageConfig {
        override val id: Identifier = Identifier(id = "dashboard")
    }

    @Serializable
    data object Search : HomePageConfig {
        override val id: Identifier = Identifier(id = "search")
    }
}