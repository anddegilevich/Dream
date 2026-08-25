package and.degilevich.dream.shared.core.service.impl.session.storage

import and.degilevich.dream.shared.core.service.api.model.SessionData

internal interface SessionStorage {
    suspend fun save(value: SessionData)
    suspend fun read(): SessionData?
    suspend fun clear()
}
