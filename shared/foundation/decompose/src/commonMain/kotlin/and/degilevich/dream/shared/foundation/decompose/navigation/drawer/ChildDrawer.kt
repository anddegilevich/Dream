package and.degilevich.dream.shared.foundation.decompose.navigation.drawer

data class ChildDrawer<out T : Any>(
    val instance: T,
    val isOpen: Boolean,
)
