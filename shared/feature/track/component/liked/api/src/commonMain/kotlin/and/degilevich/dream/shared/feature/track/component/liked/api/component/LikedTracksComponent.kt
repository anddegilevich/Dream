package and.degilevich.dream.shared.feature.track.component.liked.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface LikedTracksComponent : RenderComponent {

    @Composable
    override fun Render()
}
