package and.degilevich.dream.shared.core.storage.impl.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile

internal actual class DataStoreFactoryImpl(
    private val context: Context
) : DataStoreFactory {

    override fun create(): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile(DataStoreConst.DATA_STORE_NAME)
        }
    }
}