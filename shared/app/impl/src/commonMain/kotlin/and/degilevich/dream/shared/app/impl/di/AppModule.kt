package and.degilevich.dream.shared.app.impl.di

import org.koin.dsl.module

fun appModule() = module {
    includes(coreModule())
    includes(featureModule())
}