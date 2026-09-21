package and.degilevich.dream.shared.feature.common.component.navbar.impl.di

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponentFactory
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarManager
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.NavbarComponentFactoryImpl
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.NavbarManagerImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun navbarComponentModule() = module {
    single<NavbarManager> { NavbarManagerImpl() }
    factoryOf(::NavbarComponentFactoryImpl) bind NavbarComponentFactory::class
}
