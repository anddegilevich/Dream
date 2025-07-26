package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.NavbarStoreComponent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import and.degilevich.dream.shared.template.component.impl.BaseUIStoreComponent
import com.arkivanov.decompose.ComponentContext

class NavbarComponentImpl(
    componentContext: ComponentContext
) : BaseUIStoreComponent<
    NavbarUIState,
    NavbarIntent,
    NavbarSideEffect,
    NavbarState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        NavbarStoreComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = NavbarUIState.empty(),
    uiStateMapper = NavbarUIStateMapper()
),
    NavbarComponent