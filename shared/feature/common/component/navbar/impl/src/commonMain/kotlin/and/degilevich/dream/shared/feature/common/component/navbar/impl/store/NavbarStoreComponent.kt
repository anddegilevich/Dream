package and.degilevich.dream.shared.feature.common.component.navbar.impl.store

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class NavbarStoreComponent(
    componentContext: ComponentContext
) : BaseStoreComponent<
    NavbarState,
    NavbarIntent,
    NavbarSideEffect
    >(
    componentContext = componentContext,
    storeFactory = NavbarStoreFactory(),
    stateConservator = NavbarStateConservator()
)