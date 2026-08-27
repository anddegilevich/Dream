package and.degilevich.dream.shared.core.service.api.session

import and.degilevich.dream.shared.core.service.api.model.SessionData
import kotlinx.coroutines.flow.Flow

interface SessionService {
    suspend fun login(): Result<SessionData>
    suspend fun logout()
    suspend fun getActiveSession(): Result<SessionData>
    fun observeSession(): Flow<SessionData?>
}
