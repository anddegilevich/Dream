package and.degilevich.dream.shared.feature.common.component.splash.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface SplashComponent : RenderComponent {

    @Composable
    override fun Render()
}
