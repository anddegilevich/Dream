package and.degilevich.dream.shared.foundation.decompose.navigation.drawer

import com.arkivanov.decompose.router.children.ChildNavState
import com.arkivanov.decompose.router.children.NavState
import com.arkivanov.decompose.router.children.SimpleChildNavState

internal data class DrawerNavState(
    val isOpen: Boolean,
) : NavState<Unit> {
    override val children: List<ChildNavState<Unit>> =
        listOf(
            SimpleChildNavState(
                configuration = Unit,
                status = if (isOpen) ChildNavState.Status.RESUMED else ChildNavState.Status.CREATED,
            )
        )
}