package and.degilevich.dream.shared.feature.auth.component.login.impl.di

import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponentFactory
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.LoginComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun loginComponentModule() = module {
    factoryOf(::LoginComponentFactoryImpl) bind LoginComponentFactory::class
}
