package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component

import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerIntent
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerSideEffect
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerState
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerUIState
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.view.MiniPlayerView
import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component.MiniPlayerComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class MiniPlayerComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    MiniPlayerUIState,
    MiniPlayerIntent,
    MiniPlayerSideEffect,
    MiniPlayerState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        MiniPlayerDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = MiniPlayerUIState.empty(),
    uiStateMapper = MiniPlayerUIStateMapper()
),
    MiniPlayerComponent {

    @Composable
    override fun Render() {
        MiniPlayerView(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
