package and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface MiniPlayerComponent : RenderComponent {

    @Composable
    override fun Render()
}
