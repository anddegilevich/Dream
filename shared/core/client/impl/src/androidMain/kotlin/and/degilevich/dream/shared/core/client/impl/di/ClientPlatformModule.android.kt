package and.degilevich.dream.shared.core.client.impl.di

import and.degilevich.dream.shared.core.client.impl.engine.ClientEngineFactory
import and.degilevich.dream.shared.core.client.impl.engine.ClientEngineFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun clientPlatformModule() = module {
    singleOf(::ClientEngineFactoryImpl) bind ClientEngineFactory::class
}