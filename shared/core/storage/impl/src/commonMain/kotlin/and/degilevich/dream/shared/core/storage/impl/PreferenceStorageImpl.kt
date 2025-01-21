package and.degilevich.dream.shared.core.storage.impl

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import com.liftric.kvault.KVault

internal class PreferenceStorageImpl(
    private val kVault: KVault
) : PreferenceStorage {

    override fun save(key: String, value: String) {
        kVault.set(key, value)
    }

    override fun readString(key: String): String? {
        return kVault.string(key)
    }

    override fun clear(key: String): Boolean {
        return kVault.deleteObject(key)
    }
}