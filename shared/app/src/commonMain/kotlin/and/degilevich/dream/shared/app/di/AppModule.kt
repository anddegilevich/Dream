package and.degilevich.dream.shared.app.di

import org.koin.dsl.module

internal fun appModule() = module {
    includes(coreModule())
    includes(featureModule())
}