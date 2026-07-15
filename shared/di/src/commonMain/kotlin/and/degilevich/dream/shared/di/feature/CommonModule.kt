package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.common.component.dashboard.impl.di.dashboardComponentModule
import and.degilevich.dream.shared.feature.common.component.navbar.impl.di.navbarComponentModule
import and.degilevich.dream.shared.feature.common.component.splash.impl.di.splashComponentModule
import and.degilevich.dream.shared.feature.common.home.impl.di.homeComponentModule
import org.koin.dsl.module

internal fun commonModule() = module {
    includes(splashComponentModule())
    includes(homeComponentModule())
    includes(dashboardComponentModule())
    includes(navbarComponentModule())
}
