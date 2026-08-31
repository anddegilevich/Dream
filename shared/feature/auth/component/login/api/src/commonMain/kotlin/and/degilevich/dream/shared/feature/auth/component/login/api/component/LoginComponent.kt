package and.degilevich.dream.shared.feature.auth.component.login.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface LoginComponent : RenderComponent {

    @Composable
    override fun Render()
}
