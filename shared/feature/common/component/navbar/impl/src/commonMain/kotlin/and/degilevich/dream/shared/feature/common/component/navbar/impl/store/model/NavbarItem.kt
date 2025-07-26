package and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import kotlinx.serialization.Serializable

@Serializable
enum class NavbarItem(override val id: String) : Identified {
    HOME("home"),
    SEARCH("search")
}