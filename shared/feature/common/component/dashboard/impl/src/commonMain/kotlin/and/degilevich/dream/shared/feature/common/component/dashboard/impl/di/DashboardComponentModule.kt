package and.degilevich.dream.shared.feature.common.component.dashboard.impl.di

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.DashboardComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun dashboardComponentModule() = module {
    factory<DashboardComponent> { (componentContext: ComponentContext) ->
        DashboardComponentImpl(componentContext = componentContext)
    }
}
