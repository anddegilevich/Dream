package and.degilevich.dream.shared.feature.playlist.component.list.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface PlaylistListComponent : RenderComponent {

    @Composable
    override fun Render()
}
