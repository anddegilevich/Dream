package and.degilevich.dream.shared.core.service.impl.session.storage

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import kotlinx.coroutines.flow.Flow

internal class SessionStorageImpl(
    private val preferenceStorage: PreferenceStorage
) : SessionStorage {

    override suspend fun save(value: SessionData) {
        preferenceStorage.save(
            key = SESSION_PREFERENCE_STORAGE_KEY,
            serializer = SessionData.serializer(),
            value = value
        )
    }

    override suspend fun read(): SessionData? {
        return preferenceStorage.read(
            key = SESSION_PREFERENCE_STORAGE_KEY,
            serializer = SessionData.serializer()
        )
    }

    override suspend fun clear() {
        preferenceStorage.clear(key = SESSION_PREFERENCE_STORAGE_KEY)
    }

    override fun observe(): Flow<SessionData?> {
        return preferenceStorage.observe(
            key = SESSION_PREFERENCE_STORAGE_KEY,
            serializer = SessionData.serializer()
        )
    }

    private companion object {
        const val SESSION_PREFERENCE_STORAGE_KEY = "session"
    }
}
