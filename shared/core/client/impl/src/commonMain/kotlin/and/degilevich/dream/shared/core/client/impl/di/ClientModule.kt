package and.degilevich.dream.shared.core.client.impl.di

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.impl.RemoteClientImpl
import and.degilevich.dream.shared.core.client.impl.token.client.TokenClient
import and.degilevich.dream.shared.core.client.impl.token.client.TokenClientImpl
import and.degilevich.dream.shared.core.client.impl.token.storage.TokensStorage
import and.degilevich.dream.shared.core.client.impl.token.storage.TokensStorageImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun clientModule() = module {
    includes(clientPlatformModule())
    singleOf(::TokensStorageImpl) bind TokensStorage::class
    singleOf(::TokenClientImpl) bind TokenClient::class
    singleOf(::RemoteClientImpl) bind RemoteClient::class
}