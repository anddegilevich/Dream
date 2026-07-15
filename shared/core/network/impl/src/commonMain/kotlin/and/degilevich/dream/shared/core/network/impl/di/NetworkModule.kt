package and.degilevich.dream.shared.core.network.impl.di

import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.network.impl.RemoteClientImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun networkModule() = module {
    includes(networkPlatformModule())
    singleOf(::RemoteClientImpl) bind RemoteClient::class
}