package and.degilevich.dream.shared.foundation.decompose.compose.drawer

import androidx.compose.material.DrawerState
import androidx.compose.runtime.Stable

@Stable
interface NavigationDrawerState<out T> {
    val drawerState: DrawerState
    val instance: T
}