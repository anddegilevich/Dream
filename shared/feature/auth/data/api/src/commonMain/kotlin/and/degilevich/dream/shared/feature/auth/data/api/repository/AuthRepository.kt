package and.degilevich.dream.shared.feature.auth.data.api.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(): Result<Unit>
    suspend fun logout()
    suspend fun hasActiveSession(): Boolean
    fun observeHasActiveSession(): Flow<Boolean>
}
