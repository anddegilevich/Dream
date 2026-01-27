package and.degilevich.dream.shared.core.crypto.impl.di

import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.impl.service.CryptoServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun cryptoPlatformModule() = module {
    singleOf(::CryptoServiceImpl) bind CryptoService::class
}