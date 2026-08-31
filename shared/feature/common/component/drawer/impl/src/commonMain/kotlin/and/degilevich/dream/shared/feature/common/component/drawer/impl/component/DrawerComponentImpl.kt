package and.degilevich.dream.shared.feature.common.component.drawer.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponent
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerIntent
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerSideEffect
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerState
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerUIState
import and.degilevich.dream.shared.feature.common.component.drawer.impl.view.AppDrawer
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class DrawerComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    DrawerUIState,
    DrawerIntent,
    DrawerSideEffect,
    DrawerState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        DrawerDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = DrawerUIState.empty(),
    uiStateMapper = DrawerUIStateMapper()
),
    DrawerComponent {

    @Composable
    override fun Render() {
        AppDrawer(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
