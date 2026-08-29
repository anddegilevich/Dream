package and.degilevich.dream.shared.feature.user.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.UsersApi
import and.degilevich.dream.shared.feature.user.data.mapper.api.remote.UserOutputToDataMapper
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class UserRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val userOutputToDataMapper: UserOutputToDataMapper
) : UserRemoteDataSource {

    private val usersApi: UsersApi by lazy { apiService.usersApi }

    override suspend fun getCurrentUser(): Result<GetCurrentUserResult> = runCatching {
        usersApi.getCurrentUsersProfile().body()
    }.map { response ->
        GetCurrentUserResult(
            user = response.mapWith(userOutputToDataMapper)
        )
    }
}
