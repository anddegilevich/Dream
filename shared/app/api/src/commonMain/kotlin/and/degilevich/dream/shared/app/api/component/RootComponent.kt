package and.degilevich.dream.shared.app.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface RootComponent : RenderComponent {

    @Composable
    override fun Render()
}
