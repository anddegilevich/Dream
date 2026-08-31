package and.degilevich.dream.shared.feature.auth.data.api.repository

interface AuthRepository {
    suspend fun login(): Result<Unit>
    suspend fun logout()
    suspend fun hasActiveSession(): Boolean
}
