package and.degilevich.dream.shared.feature.user.data.impl.remote

import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult

internal interface UserRemoteDataSource {
    suspend fun getCurrentUser(): Result<GetCurrentUserResult>
}
