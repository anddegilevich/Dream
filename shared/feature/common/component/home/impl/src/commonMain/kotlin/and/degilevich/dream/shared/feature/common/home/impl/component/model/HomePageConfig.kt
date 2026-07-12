package and.degilevich.dream.shared.feature.common.home.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
sealed interface HomePageConfig : Identified {

    @Serializable
    data object Dashboard : HomePageConfig {
        override val id: AnyIdentifier = identifier(value = "dashboard")
    }

    @Serializable
    data object Search : HomePageConfig {
        override val id: AnyIdentifier = identifier(value = "search")
    }
}