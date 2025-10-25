package and.degilevich.dream.shared.feature.common.component.dashboard.api.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.children.DashboardSection
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardSectionConfig
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.items.LazyChildItems

@OptIn(ExperimentalDecomposeApi::class)
interface DashboardComponent {
    val sections: LazyChildItems<DashboardSectionConfig, DashboardSection>
}