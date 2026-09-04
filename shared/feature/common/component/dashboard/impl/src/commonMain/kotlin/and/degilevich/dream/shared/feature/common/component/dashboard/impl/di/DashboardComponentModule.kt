package and.degilevich.dream.shared.feature.common.component.dashboard.impl.di

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponentFactory
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.DashboardComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun dashboardComponentModule() = module {
    factoryOf(::DashboardComponentFactoryImpl) bind DashboardComponentFactory::class
}
