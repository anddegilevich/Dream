package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.template.component.impl.BaseBinderComponent
import com.arkivanov.decompose.ComponentContext

class NavbarComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    NavbarUIState,
    NavbarIntent,
    NavbarSideEffect,
    NavbarState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        NavbarDomainComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = NavbarUIState.empty(),
    uiStateMapper = NavbarUIStateMapper()
),
    NavbarComponent