package and.degilevich.dream.shared.feature.album.component.details.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface AlbumDetailsComponent : RenderComponent {

    @Composable
    override fun Render()
}
