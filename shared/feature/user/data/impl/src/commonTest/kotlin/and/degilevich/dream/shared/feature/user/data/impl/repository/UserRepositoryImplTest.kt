package and.degilevich.dream.shared.feature.user.data.impl.repository

import and.degilevich.dream.shared.feature.user.data.impl.remote.FakeUserRemoteDataSource
import and.degilevich.dream.shared.feature.user.data.impl.storage.FakeUserDataStorage
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class UserRepositoryImplTest {

    @Test
    fun `getCurrentUser - delegates to remote data source and returns its result unchanged`() = runTest {
        val getCurrentUserResult = Result.success(GetCurrentUserResult(user = UserData.empty()))
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(onGetCurrentUser = { getCurrentUserResult }),
            userDataStorage = FakeUserDataStorage()
        )
        val result = repository.getCurrentUser()
        result shouldBe getCurrentUserResult
    }

    @Test
    fun `cacheUser - saves the user into the storage`() = runTest {
        val savedUsers = mutableListOf<UserData>()
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(),
            userDataStorage = FakeUserDataStorage(onSave = { savedUsers.add(it) })
        )
        val user = userData(id = "user-1")
        repository.cacheUser(user = user)
        savedUsers shouldBe listOf(user)
    }

    @Test
    fun `getCachedUser - returns the user read from the storage`() = runTest {
        val user = userData(id = "user-1")
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(),
            userDataStorage = FakeUserDataStorage(onRead = { user })
        )
        val result = repository.getCachedUser()
        result shouldBe user
    }
}
