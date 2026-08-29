package and.degilevich.dream.shared.feature.user.data.impl.repository

import and.degilevich.dream.shared.feature.user.data.impl.remote.FakeUserRemoteDataSource
import and.degilevich.dream.shared.feature.user.data.impl.storage.FakeUserDataStorage
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.flowOf
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
    fun `getCachedUser - storage holds a user - returns it as success`() = runTest {
        val user = userData(id = "user-1")
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(),
            userDataStorage = FakeUserDataStorage(onRead = { Result.success(user) })
        )
        val result = repository.getCachedUser()
        result shouldBe Result.success(user)
    }

    @Test
    fun `getCachedUser - storage read fails - returns the storage failure unchanged`() = runTest {
        val storageResult = Result.failure<UserData>(IllegalStateException("no cached user"))
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(),
            userDataStorage = FakeUserDataStorage(onRead = { storageResult })
        )
        val result = repository.getCachedUser()
        result shouldBe storageResult
    }

    @Test
    fun `observeUser - emits the values observed from the storage`() = runTest {
        val user = userData(id = "user-1")
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(),
            userDataStorage = FakeUserDataStorage(onObserve = { flowOf(user, null) })
        )
        repository.observeUser().test {
            awaitItem() shouldBe user
            awaitItem() shouldBe null
            awaitComplete()
        }
    }
}
