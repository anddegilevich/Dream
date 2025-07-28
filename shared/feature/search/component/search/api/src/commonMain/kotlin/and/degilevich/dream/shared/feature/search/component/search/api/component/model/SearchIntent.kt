package and.degilevich.dream.shared.feature.search.component.search.api.component.model

sealed interface SearchIntent {
    data class OnQueryChanged(val value: String) : SearchIntent
}