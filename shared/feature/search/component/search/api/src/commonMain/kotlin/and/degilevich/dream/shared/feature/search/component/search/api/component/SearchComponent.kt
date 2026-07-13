package and.degilevich.dream.shared.feature.search.component.search.api.component

import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface SearchComponent : RenderComponent {

    @Composable
    override fun Render()
}
