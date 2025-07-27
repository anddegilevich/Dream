package and.degilevich.dream.shared.feature.common.component.navbar.impl.store

import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class NavbarStateConservator : StoreStateConservator<NavbarState> {
    override val key: String = NavbarState::class.className()
    override val initialState: NavbarState = NavbarState(
        items = NavbarItem.entries,
        selectedItem = NavbarItem.HOME
    )
    override val serializer: KSerializer<NavbarState> = NavbarState.serializer()
}