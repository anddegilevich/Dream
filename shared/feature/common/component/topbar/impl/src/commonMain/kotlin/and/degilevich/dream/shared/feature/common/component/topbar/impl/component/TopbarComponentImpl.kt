package and.degilevich.dream.shared.feature.common.component.topbar.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponent
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarIntent
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarSideEffect
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarState
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarUIState
import and.degilevich.dream.shared.feature.common.component.topbar.impl.view.AppTopbar
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class TopbarComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    TopbarUIState,
    TopbarIntent,
    TopbarSideEffect,
    TopbarState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        TopbarDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = TopbarUIState.empty(),
    uiStateMapper = TopbarUIStateMapper()
),
    TopbarComponent {

    @Composable
    override fun Render() {
        AppTopbar(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
