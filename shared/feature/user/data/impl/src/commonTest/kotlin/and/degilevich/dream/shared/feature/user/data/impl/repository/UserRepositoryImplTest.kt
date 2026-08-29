package and.degilevich.dream.shared.feature.user.data.impl.repository

import and.degilevich.dream.shared.feature.user.data.impl.remote.FakeUserRemoteDataSource
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class UserRepositoryImplTest {

    @Test
    fun `getCurrentUser - delegates to remote data source and returns its result unchanged`() = runTest {
        val getCurrentUserResult = Result.success(GetCurrentUserResult(user = UserData.empty()))
        val repository = UserRepositoryImpl(
            userRemoteDataSource = FakeUserRemoteDataSource(onGetCurrentUser = { getCurrentUserResult })
        )
        val result = repository.getCurrentUser()
        result shouldBe getCurrentUserResult
    }
}
