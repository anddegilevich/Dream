package and.degilevich.dream.shared.feature.user.data.impl.repository

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.data.impl.remote.UserRemoteDataSource
import and.degilevich.dream.shared.feature.user.data.impl.storage.UserDataStorage
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult

internal class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userDataStorage: UserDataStorage
) : UserRepository {

    override suspend fun getCurrentUser(): Result<GetCurrentUserResult> {
        return userRemoteDataSource.getCurrentUser()
    }

    override suspend fun cacheUser(user: UserData) {
        userDataStorage.save(value = user)
    }

    override suspend fun getCachedUser(): UserData? {
        return userDataStorage.read()
    }
}
