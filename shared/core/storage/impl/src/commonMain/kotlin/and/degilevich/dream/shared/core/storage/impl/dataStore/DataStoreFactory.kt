package and.degilevich.dream.shared.core.storage.impl.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

internal interface DataStoreFactory {
    fun create(): DataStore<Preferences>
}