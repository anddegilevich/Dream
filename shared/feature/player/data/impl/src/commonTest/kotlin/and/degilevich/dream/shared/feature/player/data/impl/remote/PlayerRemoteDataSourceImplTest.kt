package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CursorPagingPlayHistoryObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject
import and.degilevich.dream.shared.core.service.test.api.fakePlayerApi
import and.degilevich.dream.shared.core.service.test.model.cursorPagingPlayHistoryObject
import and.degilevich.dream.shared.core.service.test.model.playHistoryObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.test.remote.FakeRecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.model.core.test.data.playHistoryData
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

class PlayerRemoteDataSourceImplTest {

    @Test
    fun `getRecentlyPlayed - successful response - returns result mapped via injected mapper`() = runTest {
        val expected = GetRecentlyPlayedResult(items = listOf(playHistoryData(id = "track-1")))
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(content = encoded(items = listOf(playHistoryObject()))),
            recentlyPlayedResponseToResultMapper = FakeRecentlyPlayedResponseToResultMapper(onMap = { expected })
        )

        val result = dataSource.getRecentlyPlayed(params = params())

        assertTrue(result.isSuccess)
        result.getOrNull() shouldBe expected
    }

    @Test
    fun `getRecentlyPlayed - empty items - returns empty result`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(content = encoded(items = emptyList())),
            recentlyPlayedResponseToResultMapper = FakeRecentlyPlayedResponseToResultMapper(
                onMap = { GetRecentlyPlayedResult(items = emptyList()) }
            )
        )

        val result = dataSource.getRecentlyPlayed(params = params())

        assertTrue(result.isSuccess)
        result.getOrNull()?.items shouldBe emptyList()
    }

    @Test
    fun `getRecentlyPlayed - request - targets the recently played path with limit`() = runTest {
        val engine = respondingWith(content = encoded(items = emptyList()))
        val dataSource = playerRemoteDataSource(
            engine = engine,
            recentlyPlayedResponseToResultMapper = FakeRecentlyPlayedResponseToResultMapper(
                onMap = { GetRecentlyPlayedResult(items = emptyList()) }
            )
        )

        dataSource.getRecentlyPlayed(params = params(limit = 10))

        with(engine.requestHistory.first().url) {
            encodedPath shouldBe "/me/player/recently-played"
            parameters["limit"] shouldBe "10"
        }
    }

    @Test
    fun `getRecentlyPlayed - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(engine = respondingWith(content = "[]"))

        val result = dataSource.getRecentlyPlayed(params = params())

        assertTrue(result.isFailure)
    }

    @Test
    fun `getRecentlyPlayed - server responds with an error - returns failure`() = runTest {
        val engine = MockEngine { _ ->
            respond(
                content = "",
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val dataSource = playerRemoteDataSource(engine = engine)

        val result = dataSource.getRecentlyPlayed(params = params())

        assertTrue(result.isFailure)
    }

    private fun encoded(items: List<PlayHistoryObject>) = Json.encodeToString(
        serializer = CursorPagingPlayHistoryObject.serializer(),
        value = cursorPagingPlayHistoryObject(items = items)
    )

    private fun params(limit: Int = 10) = GetRecentlyPlayedParams(limit = limit)

    private fun playerRemoteDataSource(
        engine: MockEngine,
        recentlyPlayedResponseToResultMapper: RecentlyPlayedResponseToResultMapper =
            FakeRecentlyPlayedResponseToResultMapper()
    ): PlayerRemoteDataSourceImpl {
        val apiService = FakeApiService(onPlayerApi = { fakePlayerApi(engine = engine) })
        return PlayerRemoteDataSourceImpl(
            apiService = apiService,
            recentlyPlayedResponseToResultMapper = recentlyPlayedResponseToResultMapper
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
