package and.degilevich.dream.shared.core.storage.impl.di

import and.degilevich.dream.shared.core.storage.impl.dataStore.DataStoreFactory
import and.degilevich.dream.shared.core.storage.impl.dataStore.DataStoreFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun storagePlatformModule() = module {
    singleOf(::DataStoreFactoryImpl) bind DataStoreFactory::class
}