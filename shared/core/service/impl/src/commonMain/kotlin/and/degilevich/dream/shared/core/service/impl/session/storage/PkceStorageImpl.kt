package and.degilevich.dream.shared.core.service.impl.session.storage

import and.degilevich.dream.shared.core.service.impl.session.model.PkceData
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage

internal class PkceStorageImpl(
    private val preferenceStorage: PreferenceStorage
) : PkceStorage {

    override suspend fun save(value: PkceData) {
        preferenceStorage.save(
            key = PKCE_PREFERENCE_STORAGE_KEY,
            serializer = PkceData.serializer(),
            value = value
        )
    }

    override suspend fun read(): PkceData? {
        return preferenceStorage.read(
            key = PKCE_PREFERENCE_STORAGE_KEY,
            serializer = PkceData.serializer()
        )
    }

    override suspend fun clear() {
        preferenceStorage.clear(key = PKCE_PREFERENCE_STORAGE_KEY)
    }

    private companion object {
        const val PKCE_PREFERENCE_STORAGE_KEY = "pkce"
    }
}
