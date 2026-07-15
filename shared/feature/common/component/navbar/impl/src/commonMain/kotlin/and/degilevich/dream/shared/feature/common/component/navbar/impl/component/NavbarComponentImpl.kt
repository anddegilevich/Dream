package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.view.AppNavbar
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class NavbarComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    NavbarUIState,
    NavbarIntent,
    NavbarSideEffect,
    NavbarState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        NavbarDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = NavbarUIState.empty(),
    uiStateMapper = NavbarUIStateMapper()
),
    NavbarComponent {

    @Composable
    override fun Render() {
        AppNavbar(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}