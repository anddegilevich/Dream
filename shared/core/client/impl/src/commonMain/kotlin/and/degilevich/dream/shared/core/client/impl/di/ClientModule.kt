package and.degilevich.dream.shared.core.client.impl.di

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.impl.RemoteClientImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun clientModule() = module {
    includes(clientPlatformModule())
    singleOf(::RemoteClientImpl) bind RemoteClient::class
}