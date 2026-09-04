package and.degilevich.dream.shared.feature.playlist.component.details.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface PlaylistDetailsComponent : RenderComponent {

    @Composable
    override fun Render()
}
