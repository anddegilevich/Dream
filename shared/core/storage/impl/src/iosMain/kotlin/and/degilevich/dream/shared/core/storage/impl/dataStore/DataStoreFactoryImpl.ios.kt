package and.degilevich.dream.shared.core.storage.impl.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
internal actual class DataStoreFactoryImpl : DataStoreFactory {

    private val fileManager by lazy { NSFileManager.defaultManager }

    override fun create(): DataStore<Preferences> {
        return PreferenceDataStoreFactory.createWithPath {
            val documentDirectory: NSURL? = fileManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            val absolutePath = requireNotNull(documentDirectory).path + "/${DataStoreConst.DATA_STORE_NAME}"
            absolutePath.toPath()
        }
    }
}