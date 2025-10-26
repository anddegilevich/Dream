package and.degilevich.dream.shared.foundation.decompose.navigation.drawer

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.NavigationSource
import com.arkivanov.decompose.router.children.children
import com.arkivanov.decompose.value.Value

fun <T : Any> ComponentContext.childDrawer(
    source: NavigationSource<DrawerNavigationEvent>,
    key: String = "drawer",
    childFactory: (ComponentContext) -> T,
): Value<ChildDrawer<T>> = children(
    source = source,
    key = key,
    initialState = { DrawerNavState(isOpen = false) },
    saveState = { null },
    restoreState = { null },
    navTransformer = { state, event ->
        state.copy(isOpen = event is DrawerNavigationEvent.Open)
    },
    stateMapper = { state, children ->
        ChildDrawer(
            instance = requireNotNull(children.single().instance),
            isOpen = state.isOpen,
        )
    },
    backTransformer = { state ->
        if (state.isOpen) {
            { state.copy(isOpen = false) }
        } else {
            null
        }
    },
    childFactory = { _, componentContext -> childFactory(componentContext) },
)