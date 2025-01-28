package and.degilevich.dream.shared.app.impl.di

import and.degilevich.dream.shared.navigation.impl.di.navigationModule
import org.koin.dsl.module

fun appModule() = module {
    includes(coreModule())
    includes(featureModule())
    includes(navigationModule())
}