package and.degilevich.dream.shared.app.impl.di

import and.degilevich.dream.shared.resource.impl.di.resourceModule
import org.koin.dsl.module

fun appModule() = module {
    includes(resourceModule())
    includes(coreModule())
    includes(featureModule())
}