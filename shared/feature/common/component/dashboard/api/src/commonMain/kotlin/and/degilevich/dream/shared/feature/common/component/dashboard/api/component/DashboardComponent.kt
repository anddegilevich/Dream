package and.degilevich.dream.shared.feature.common.component.dashboard.api.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardItemConfig
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems

@OptIn(ExperimentalDecomposeApi::class)
interface DashboardComponent {
    val items: LazyChildItems<DashboardItemConfig, DashboardItem>
}