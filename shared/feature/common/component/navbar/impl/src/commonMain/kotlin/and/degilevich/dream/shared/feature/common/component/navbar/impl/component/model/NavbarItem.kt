package and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
enum class NavbarItem(override val id: Identifier) : Identified {
    HOME(id = Identifier("home")),
    SEARCH(id = Identifier("search"))
}