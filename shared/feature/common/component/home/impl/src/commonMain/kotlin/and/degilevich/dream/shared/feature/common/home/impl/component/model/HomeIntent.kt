package and.degilevich.dream.shared.feature.common.home.impl.component.model

sealed interface HomeIntent {
    data class OnDrawerStateChanged(val isOpen: Boolean) : HomeIntent
}
