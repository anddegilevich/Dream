package and.degilevich.dream.shared.core.service.impl.di

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.impl.ApiServiceImpl
import and.degilevich.dream.shared.core.service.impl.session.storage.SessionStorage
import and.degilevich.dream.shared.core.service.impl.session.storage.SessionStorageImpl
import and.degilevich.dream.shared.core.service.impl.token.client.TokenService
import and.degilevich.dream.shared.core.service.impl.token.client.TokenServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun serviceModule() = module {
    singleOf(::SessionStorageImpl) bind SessionStorage::class
    singleOf(::TokenServiceImpl) bind TokenService::class
    singleOf(::ApiServiceImpl) bind ApiService::class
}