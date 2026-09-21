package and.degilevich.dream.shared.navigation.impl.di

import and.degilevich.dream.shared.navigation.api.component.AppNavigationComponentFactory
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun navigationModule() = module {
    factoryOf(::AppNavigationComponentFactoryImpl) bind AppNavigationComponentFactory::class
}
