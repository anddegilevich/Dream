package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component.RecentlyPlayedComponent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedIntent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedSideEffect
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedState
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedUIState
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.view.RecentlyPlayedView
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class RecentlyPlayedComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    RecentlyPlayedUIState,
    RecentlyPlayedIntent,
    RecentlyPlayedSideEffect,
    RecentlyPlayedState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        RecentlyPlayedDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = RecentlyPlayedUIState.empty(),
    uiStateMapper = RecentlyPlayedUIStateMapper()
),
    RecentlyPlayedComponent {

    @Composable
    override fun Render() {
        RecentlyPlayedView(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
