package and.degilevich.dream.shared.feature.user.data.api.repository

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getCurrentUser(): Result<GetCurrentUserResult>
    suspend fun cacheUser(user: UserData)
    suspend fun getCachedUser(): Result<UserData>
    fun observeUser(): Flow<UserData?>
}
