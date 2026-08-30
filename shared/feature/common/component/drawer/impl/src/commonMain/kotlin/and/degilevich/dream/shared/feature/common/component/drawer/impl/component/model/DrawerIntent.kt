package and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model

sealed interface DrawerIntent {
    data object OnLogoutClicked : DrawerIntent
}
