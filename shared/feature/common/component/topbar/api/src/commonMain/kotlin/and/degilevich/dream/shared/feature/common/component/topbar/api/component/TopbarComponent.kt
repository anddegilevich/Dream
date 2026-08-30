package and.degilevich.dream.shared.feature.common.component.topbar.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface TopbarComponent : RenderComponent {

    @Composable
    override fun Render()
}
