package and.degilevich.dream.shared.core.storage.impl.di

import and.degilevich.dream.shared.core.storage.impl.vault.KVaultFactory
import and.degilevich.dream.shared.core.storage.impl.vault.KVaultFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun storagePlatformModule() = module {
    factoryOf(::KVaultFactoryImpl) bind KVaultFactory::class
}