package and.degilevich.dream.shared.core.crypto.impl.di

import and.degilevich.dream.shared.core.crypto.api.generator.SecureBytesGenerator
import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.api.service.DigestService
import and.degilevich.dream.shared.core.crypto.impl.generator.SecureBytesGeneratorImpl
import and.degilevich.dream.shared.core.crypto.impl.keychain.KeychainManager
import and.degilevich.dream.shared.core.crypto.impl.keychain.KeychainManagerImpl
import and.degilevich.dream.shared.core.crypto.impl.service.CryptoServiceImpl
import and.degilevich.dream.shared.core.crypto.impl.service.DigestServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun cryptoPlatformModule() = module {
    singleOf(::CryptoServiceImpl) bind CryptoService::class
    singleOf(::SecureBytesGeneratorImpl) bind SecureBytesGenerator::class
    singleOf(::KeychainManagerImpl) bind KeychainManager::class
    singleOf(::DigestServiceImpl) bind DigestService::class
}