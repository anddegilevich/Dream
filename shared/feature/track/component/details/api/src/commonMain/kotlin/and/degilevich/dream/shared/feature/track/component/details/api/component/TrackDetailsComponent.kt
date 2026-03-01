package and.degilevich.dream.shared.feature.track.component.details.api.component

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
interface TrackDetailsComponent : RenderMVIComponent<TrackDetailsUIState, TrackDetailsIntent, TrackDetailsSideEffect> {

    @Composable
    override fun Render(modifier: Modifier) {
        TrackDetailsScreen(
            modifier = modifier,
            state = state(),
            onIntent = ::handleIntent
        )
    }
}