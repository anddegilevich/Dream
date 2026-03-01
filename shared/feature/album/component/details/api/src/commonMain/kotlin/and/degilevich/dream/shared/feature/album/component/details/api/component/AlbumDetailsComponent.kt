package and.degilevich.dream.shared.feature.album.component.details.api.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
interface AlbumDetailsComponent : RenderMVIComponent<AlbumDetailsUIState, AlbumDetailsIntent, AlbumDetailsSideEffect> {

    @Composable
    override fun Render(modifier: Modifier) {
        AlbumDetailsScreen(
            modifier = modifier,
            state = state(),
            onIntent = ::handleIntent
        )
    }
}