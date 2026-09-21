package and.degilevich.dream.shared.feature.common.component.splash.impl.di

import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponentFactory
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.SplashComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun splashComponentModule() = module {
    factoryOf(::SplashComponentFactoryImpl) bind SplashComponentFactory::class
}
