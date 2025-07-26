package and.degilevich.dream.shared.feature.common.component.navbar.api.component.model

sealed interface NavbarIntent {
    data class OnItemClicked(val id: String) : NavbarIntent
}