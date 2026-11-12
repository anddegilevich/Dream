package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerIntent
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerSideEffect
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerState
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerUIState
import and.degilevich.dream.shared.feature.player.component.player.impl.view.PlayerScreen
import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.player.component.player.api.component.PlayerComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class PlayerComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    PlayerUIState,
    PlayerIntent,
    PlayerSideEffect,
    PlayerState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        PlayerDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = PlayerUIState.empty(),
    uiStateMapper = PlayerUIStateMapper()
),
    PlayerComponent {

    @Composable
    override fun Render() {
        PlayerScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
