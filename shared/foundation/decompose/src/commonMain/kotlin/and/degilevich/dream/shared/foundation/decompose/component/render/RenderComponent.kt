package and.degilevich.dream.shared.foundation.decompose.component.render

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface RenderComponent {

    @Composable
    fun Render(modifier: Modifier = Modifier)
}