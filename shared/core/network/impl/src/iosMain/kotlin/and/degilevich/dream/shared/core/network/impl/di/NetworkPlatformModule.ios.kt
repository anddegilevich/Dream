package and.degilevich.dream.shared.core.network.impl.di

import and.degilevich.dream.shared.core.network.impl.engine.ClientEngineFactory
import and.degilevich.dream.shared.core.network.impl.engine.ClientEngineFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun networkPlatformModule() = module {
    singleOf(::ClientEngineFactoryImpl) bind ClientEngineFactory::class
}