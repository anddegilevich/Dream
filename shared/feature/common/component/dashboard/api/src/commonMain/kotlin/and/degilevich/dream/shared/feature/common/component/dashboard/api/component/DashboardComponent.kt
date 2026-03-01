package and.degilevich.dream.shared.feature.common.component.dashboard.api.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.common.component.dashboard.api.design.DashboardScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems

@Stable
@OptIn(ExperimentalDecomposeApi::class)
interface DashboardComponent : RenderComponent {
    val items: LazyChildItems<DashboardItemConfig, DashboardItem>

    @Composable
    override fun Render(modifier: Modifier) {
        DashboardScreen(
            modifier = modifier,
            component = this
        )
    }
}