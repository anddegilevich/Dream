package and.degilevich.dream.shared.core.crypto.impl.di

import and.degilevich.dream.shared.core.crypto.api.generator.SecureBytesGenerator
import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.api.service.DigestService
import and.degilevich.dream.shared.core.crypto.impl.generator.SecureBytesGeneratorImpl
import and.degilevich.dream.shared.core.crypto.impl.keystore.KeystoreManager
import and.degilevich.dream.shared.core.crypto.impl.keystore.KeystoreManagerImpl
import and.degilevich.dream.shared.core.crypto.impl.service.CryptoServiceImpl
import and.degilevich.dream.shared.core.crypto.impl.service.DigestServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun cryptoPlatformModule() = module {
    singleOf(::KeystoreManagerImpl) bind KeystoreManager::class
    singleOf(::CryptoServiceImpl) bind CryptoService::class
    singleOf(::SecureBytesGeneratorImpl) bind SecureBytesGenerator::class
    singleOf(::DigestServiceImpl) bind DigestService::class
}