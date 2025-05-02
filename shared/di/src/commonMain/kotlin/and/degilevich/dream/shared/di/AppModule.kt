package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.resource.impl.di.resourceModule
import org.koin.dsl.module

fun appModule() = module {
    includes(resourceModule())
    includes(coreModule())
    includes(templateModule())
    includes(featureModule())
}