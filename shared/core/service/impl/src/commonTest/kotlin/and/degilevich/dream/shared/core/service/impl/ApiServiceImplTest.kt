package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.network.fakeRemoteClient
import and.degilevich.dream.shared.core.service.impl.session.storage.FakeSessionStorage
import and.degilevich.dream.shared.core.service.impl.session.storage.SessionStorage
import and.degilevich.dream.shared.core.service.impl.token.client.FakeTokenService
import and.degilevich.dream.shared.core.service.impl.token.client.TokenService
import and.degilevich.dream.shared.core.service.impl.token.mapper.TokensDataToBearerMapperImpl
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertFailsWith

class ApiServiceImplTest {

    @Test
    fun `usersApi - stored access token is accepted - sends it as a bearer token`() = runTest {
        val engine = respondingWith(statuses = listOf(HttpStatusCode.OK))
        val apiService = createApiService(
            engine = engine,
            sessionStorage = FakeSessionStorage(onRead = { session(accessToken = "stored-access-token") })
        )

        apiService.usersApi.getCurrentUsersProfile()

        engine.requestHistory.single().headers[HttpHeaders.Authorization] shouldBe "Bearer stored-access-token"
    }

    @Test
    fun `usersApi - access token is rejected - refreshes and retries with the new token`() = runTest {
        val engine = respondingWith(statuses = listOf(HttpStatusCode.Unauthorized, HttpStatusCode.OK))
        val refreshedWith = mutableListOf<String>()
        val apiService = createApiService(
            engine = engine,
            sessionStorage = FakeSessionStorage(
                onRead = { session(accessToken = "expired-access-token") },
                onSave = { }
            ),
            tokenService = FakeTokenService(
                onRefresh = { refreshToken ->
                    refreshedWith.add(refreshToken)
                    Result.success(tokens(accessToken = "refreshed-access-token"))
                }
            )
        )

        apiService.usersApi.getCurrentUsersProfile()

        refreshedWith.single() shouldBe "stored-refresh-token"
        engine.requestHistory.size shouldBe 2
        engine.requestHistory.last().headers[HttpHeaders.Authorization] shouldBe "Bearer refreshed-access-token"
    }

    @Test
    fun `usersApi - refresh succeeds - persists the refreshed session`() = runTest {
        val savedSessions = mutableListOf<SessionData>()
        val apiService = createApiService(
            engine = respondingWith(statuses = listOf(HttpStatusCode.Unauthorized, HttpStatusCode.OK)),
            sessionStorage = FakeSessionStorage(
                onRead = { session(accessToken = "expired-access-token") },
                onSave = { session -> savedSessions.add(session) }
            ),
            tokenService = FakeTokenService(
                onRefresh = { Result.success(tokens(accessToken = "refreshed-access-token")) }
            )
        )

        apiService.usersApi.getCurrentUsersProfile()

        savedSessions.single() shouldBe SessionData(tokens = tokens(accessToken = "refreshed-access-token"))
    }

    @Test
    fun `usersApi - refresh fails - clears the stored session`() = runTest {
        var sessionCleared = false
        val apiService = createApiService(
            engine = respondingWith(statuses = listOf(HttpStatusCode.Unauthorized, HttpStatusCode.Unauthorized)),
            sessionStorage = FakeSessionStorage(
                onRead = { session(accessToken = "expired-access-token") },
                onClear = { sessionCleared = true }
            ),
            tokenService = FakeTokenService(
                onRefresh = { Result.failure(IllegalStateException("refresh rejected")) }
            )
        )

        assertFailsWith<Exception> {
            apiService.usersApi.getCurrentUsersProfile()
        }

        sessionCleared shouldBe true
    }

    private fun createApiService(
        engine: MockEngine,
        sessionStorage: SessionStorage = FakeSessionStorage(),
        tokenService: TokenService = FakeTokenService()
    ): ApiServiceImpl {
        return ApiServiceImpl(
            remoteClient = fakeRemoteClient(engine = engine),
            sessionStorage = sessionStorage,
            tokenService = tokenService,
            tokensDataToBearerMapper = TokensDataToBearerMapperImpl()
        )
    }

    private fun session(accessToken: String): SessionData {
        return SessionData(tokens = tokens(accessToken = accessToken))
    }

    private fun tokens(accessToken: String): TokensData {
        return TokensData(
            accessToken = accessToken,
            refreshToken = "stored-refresh-token"
        )
    }

    private fun respondingWith(statuses: List<HttpStatusCode>): MockEngine {
        var callIndex = 0
        return MockEngine { _ ->
            val status = statuses.getOrElse(callIndex) { statuses.last() }
            callIndex++
            if (status == HttpStatusCode.Unauthorized) {
                respondError(
                    status = status,
                    headers = headersOf(HttpHeaders.WWWAuthenticate, """Bearer realm="", error="invalid_token"""")
                )
            } else {
                respond(
                    content = "{}",
                    status = status,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
        }
    }
}
