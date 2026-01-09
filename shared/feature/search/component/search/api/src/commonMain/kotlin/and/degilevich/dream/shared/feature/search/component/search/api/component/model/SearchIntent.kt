package and.degilevich.dream.shared.feature.search.component.search.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface SearchIntent {
    data class OnQueryChanged(val value: String) : SearchIntent
    data class OnItemClicked(val id: Identifier) : SearchIntent
}