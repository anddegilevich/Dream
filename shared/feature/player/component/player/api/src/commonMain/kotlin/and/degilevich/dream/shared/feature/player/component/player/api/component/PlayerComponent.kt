package and.degilevich.dream.shared.feature.player.component.player.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface PlayerComponent : RenderComponent {

    @Composable
    override fun Render()
}
