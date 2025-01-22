package and.degilevich.dream.shared.app.di

import and.degilevich.dream.shared.navigation.impl.di.navigationModule
import org.koin.dsl.module

internal fun appModule() = module {
    includes(coreModule())
    includes(featureModule())
    includes(navigationModule())
}