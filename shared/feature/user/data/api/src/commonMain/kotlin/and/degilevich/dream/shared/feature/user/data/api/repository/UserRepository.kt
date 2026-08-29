package and.degilevich.dream.shared.feature.user.data.api.repository

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult

interface UserRepository {
    suspend fun getCurrentUser(): Result<GetCurrentUserResult>
    suspend fun cacheUser(user: UserData)
    suspend fun getCachedUser(): UserData?
}
