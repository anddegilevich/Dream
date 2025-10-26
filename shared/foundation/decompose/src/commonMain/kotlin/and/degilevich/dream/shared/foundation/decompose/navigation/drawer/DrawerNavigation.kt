package and.degilevich.dream.shared.foundation.decompose.navigation.drawer

import com.arkivanov.decompose.router.children.NavigationSource
import com.arkivanov.decompose.router.children.SimpleNavigation

class DrawerNavigation(
    private val navigation: SimpleNavigation<DrawerNavigationEvent> = SimpleNavigation()
) : DrawerNavigator, NavigationSource<DrawerNavigationEvent> by navigation {

    override fun open() {
        navigation.navigate(DrawerNavigationEvent.Open)
    }

    override fun close() {
        navigation.navigate(DrawerNavigationEvent.Close)
    }
}