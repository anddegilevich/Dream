package and.degilevich.dream.shared.core.storage.impl.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.datastore.DataStoreSettings

@OptIn(
    ExperimentalSettingsApi::class,
    ExperimentalSettingsImplementation::class
)
internal class SettingsFactoryImpl(
    val dataStore: DataStore<Preferences>
) : SettingsFactory {

    override fun create(): DataStoreSettings {
        return DataStoreSettings(datastore = dataStore)
    }
}