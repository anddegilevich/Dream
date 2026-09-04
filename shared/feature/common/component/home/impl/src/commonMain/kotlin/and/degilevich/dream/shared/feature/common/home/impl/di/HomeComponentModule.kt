package and.degilevich.dream.shared.feature.common.home.impl.di

import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponentFactory
import and.degilevich.dream.shared.feature.common.home.impl.component.HomeComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun homeComponentModule() = module {
    factoryOf(::HomeComponentFactoryImpl) bind HomeComponentFactory::class
}
