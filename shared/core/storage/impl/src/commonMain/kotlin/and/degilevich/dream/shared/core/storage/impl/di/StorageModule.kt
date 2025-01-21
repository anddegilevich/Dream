package and.degilevich.dream.shared.core.storage.impl.di

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.core.storage.impl.PreferenceStorageImpl
import and.degilevich.dream.shared.core.storage.impl.vault.KVaultFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun storageModule() = module {
    includes(storagePlatformModule())
    single {
        val kVaultFactory: KVaultFactory = get()
        kVaultFactory.create()
    }
    singleOf(::PreferenceStorageImpl) bind PreferenceStorage::class
}