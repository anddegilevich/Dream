package and.degilevich.dream.shared.feature.track.component.liked.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksIntent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksSideEffect
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksState
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksUIState
import and.degilevich.dream.shared.feature.track.component.liked.impl.view.LikedTracksScreen
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class LikedTracksComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    LikedTracksUIState,
    LikedTracksIntent,
    LikedTracksSideEffect,
    LikedTracksState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        LikedTracksDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = LikedTracksUIState.empty(),
    uiStateMapper = LikedTracksUIStateMapper()
),
    LikedTracksComponent {

    @Composable
    override fun Render() {
        LikedTracksScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
