package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class DashboardComponentFactoryImpl : DashboardComponentFactory {

    override fun create(componentContext: ComponentContext): DashboardComponent = DashboardComponentImpl(
        componentContext = componentContext
    )
}
