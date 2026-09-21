package and.degilevich.dream.shared.feature.common.component.dashboard.api.component

import com.arkivanov.decompose.ComponentContext

interface DashboardComponentFactory {

    fun create(componentContext: ComponentContext): DashboardComponent
}
