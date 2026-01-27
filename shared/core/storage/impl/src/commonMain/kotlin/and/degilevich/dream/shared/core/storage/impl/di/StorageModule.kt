package and.degilevich.dream.shared.core.storage.impl.di

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.core.storage.impl.PreferenceStorageImpl
import and.degilevich.dream.shared.core.storage.impl.dataStore.DataStoreFactory
import and.degilevich.dream.shared.core.storage.impl.settings.SettingsFactory
import and.degilevich.dream.shared.core.storage.impl.settings.SettingsFactoryImpl
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.datastore.DataStoreSettings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

@OptIn(
    ExperimentalSettingsApi::class,
    ExperimentalSettingsImplementation::class
)
fun storageModule() = module {
    includes(storagePlatformModule())
    single<DataStore<Preferences>> {
        val dataStoreFactory: DataStoreFactory = get()
        dataStoreFactory.create()
    }
    singleOf(::SettingsFactoryImpl) bind SettingsFactory::class
    single<DataStoreSettings> {
        val settingsFactory: SettingsFactory = get()
        settingsFactory.create()
    }
    singleOf(::PreferenceStorageImpl) bind PreferenceStorage::class
}