package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface RecentlyPlayedComponent : RenderComponent {

    @Composable
    override fun Render()
}
