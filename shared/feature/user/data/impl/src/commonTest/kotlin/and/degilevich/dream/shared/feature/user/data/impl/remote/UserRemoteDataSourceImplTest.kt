package and.degilevich.dream.shared.feature.user.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PrivateUserObject
import and.degilevich.dream.shared.core.service.test.api.fakeUsersApi
import and.degilevich.dream.shared.core.service.test.model.privateUserObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.user.data.mapper.api.remote.UserOutputToDataMapper
import and.degilevich.dream.shared.feature.user.data.mapper.test.remote.FakeUserOutputToDataMapper
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class UserRemoteDataSourceImplTest {

    @Test
    fun `getCurrentUser - successful response - returns mapped result via injected mapper`() = runTest {
        val userData = userData(id = "user-id")
        val content = Json.encodeToString(
            serializer = PrivateUserObject.serializer(),
            value = privateUserObject()
        )
        val dataSource = createDataSource(
            engine = respondingWith(content = content),
            userOutputToDataMapper = FakeUserOutputToDataMapper(onMap = { userData })
        )
        val result = dataSource.getCurrentUser()
        assertTrue(result.isSuccess)
        result.getOrNull()?.user shouldBe userData
    }

    @Test
    fun `getCurrentUser - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = createDataSource(engine = respondingWith(content = "not json"))
        val result = dataSource.getCurrentUser()
        assertTrue(result.isFailure)
    }

    private fun createDataSource(
        engine: MockEngine,
        userOutputToDataMapper: UserOutputToDataMapper = FakeUserOutputToDataMapper()
    ): UserRemoteDataSourceImpl {
        val apiService = FakeApiService(onUsersApi = { fakeUsersApi(engine = engine) })
        return UserRemoteDataSourceImpl(
            apiService = apiService,
            userOutputToDataMapper = userOutputToDataMapper
        )
    }

    private fun respondingWith(content: String): MockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
}
