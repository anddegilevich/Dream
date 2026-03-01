package and.degilevich.dream.shared.feature.artist.component.details.api.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
interface ArtistDetailsComponent :
    RenderMVIComponent<ArtistDetailsUIState, ArtistDetailsIntent, ArtistDetailsSideEffect> {

    @Composable
    override fun Render(modifier: Modifier) {
        ArtistDetailsScreen(
            modifier = modifier,
            state = state(),
            onIntent = ::handleIntent
        )
    }
}