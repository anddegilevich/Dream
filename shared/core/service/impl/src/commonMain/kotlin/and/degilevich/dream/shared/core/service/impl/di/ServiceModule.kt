package and.degilevich.dream.shared.core.service.impl.di

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.impl.ApiServiceImpl
import and.degilevich.dream.shared.core.service.impl.token.client.TokenService
import and.degilevich.dream.shared.core.service.impl.token.client.TokenServiceImpl
import and.degilevich.dream.shared.core.service.impl.token.storage.TokensStorage
import and.degilevich.dream.shared.core.service.impl.token.storage.TokensStorageImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun serviceModule() = module {
    singleOf(::TokensStorageImpl) bind TokensStorage::class
    singleOf(::TokenServiceImpl) bind TokenService::class
    singleOf(::ApiServiceImpl) bind ApiService::class
}