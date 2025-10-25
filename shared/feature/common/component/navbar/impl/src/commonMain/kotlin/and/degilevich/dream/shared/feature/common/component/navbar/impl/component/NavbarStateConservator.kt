package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class NavbarStateConservator : ComponentStateConservator<NavbarState> {
    override val key: String = NavbarState::class.className()
    override val initialState: NavbarState = NavbarState(
        items = NavbarItem.entries,
        selectedItem = NavbarItem.HOME
    )
    override val serializer: KSerializer<NavbarState> = NavbarState.serializer()
}