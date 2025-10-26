package and.degilevich.dream.shared.foundation.decompose.navigation.drawer

sealed interface DrawerNavigationEvent {
    data object Open : DrawerNavigationEvent
    data object Close : DrawerNavigationEvent
}