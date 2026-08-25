package and.degilevich.dream.shared.core.service.impl.session.storage

import and.degilevich.dream.shared.core.service.api.model.SessionData
import kotlinx.coroutines.flow.Flow

internal interface SessionStorage {
    suspend fun save(value: SessionData)
    suspend fun read(): SessionData?
    suspend fun clear()
    fun observe(): Flow<SessionData?>
}
