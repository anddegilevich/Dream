package and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface NavbarIntent {
    data class OnItemClicked(val id: Identifier) : NavbarIntent
}