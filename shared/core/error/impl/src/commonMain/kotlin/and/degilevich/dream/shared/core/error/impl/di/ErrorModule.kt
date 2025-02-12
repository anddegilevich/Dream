package and.degilevich.dream.shared.core.error.impl.di

import and.degilevich.dream.shared.core.error.api.manager.ErrorManager
import and.degilevich.dream.shared.core.error.impl.handler.ErrorHandlerBuilder
import and.degilevich.dream.shared.core.error.impl.manager.ErrorManagerImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun errorModule() = module {
    singleOf(::ErrorManagerImpl) bind ErrorManager::class
    factoryOf(::ErrorHandlerBuilder)
}