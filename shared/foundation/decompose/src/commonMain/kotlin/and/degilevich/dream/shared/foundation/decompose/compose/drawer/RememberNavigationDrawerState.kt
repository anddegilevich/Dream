package and.degilevich.dream.shared.foundation.decompose.compose.drawer

import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.ChildDrawer
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.value.Value

@Composable
fun <T : Any> rememberNavigationDrawerState(
    drawer: Value<ChildDrawer<T>>,
    onStateChanged: (isOpen: Boolean) -> Unit,
): NavigationDrawerState<T> {
    val childDrawer by drawer.subscribeAsState()
    val drawerState = rememberDrawerState(
        initialValue = if (childDrawer.isOpen) DrawerValue.Open else DrawerValue.Closed
    )

    DisposableEffect(drawerState.isOpen) {
        onStateChanged(drawerState.isOpen)
        onDispose {}
    }

    LaunchedEffect(childDrawer.isOpen) {
        if (childDrawer.isOpen) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }

    return object : NavigationDrawerState<T> {
        override val drawerState: DrawerState get() = drawerState
        override val instance: T get() = childDrawer.instance
    }
}