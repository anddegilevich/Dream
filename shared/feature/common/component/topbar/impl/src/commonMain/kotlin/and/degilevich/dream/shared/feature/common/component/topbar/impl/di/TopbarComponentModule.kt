package and.degilevich.dream.shared.feature.common.component.topbar.impl.di

import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponentFactory
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.TopbarComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun topbarComponentModule() = module {
    factoryOf(::TopbarComponentFactoryImpl) bind TopbarComponentFactory::class
}
