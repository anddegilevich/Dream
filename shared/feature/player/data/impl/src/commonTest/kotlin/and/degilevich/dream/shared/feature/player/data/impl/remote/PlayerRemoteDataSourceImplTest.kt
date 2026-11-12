package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.core.service.api.generated.model.CursorPagingPlayHistoryObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject
import and.degilevich.dream.shared.core.service.test.api.fakePlayerApi
import and.degilevich.dream.shared.core.service.test.model.currentlyPlayingContextObject
import and.degilevich.dream.shared.core.service.test.model.cursorPagingPlayHistoryObject
import and.degilevich.dream.shared.core.service.test.model.playHistoryObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.test.remote.FakePlaybackStateResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.test.remote.FakeRecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playHistoryData
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playbackStateData
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.headersOf
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json

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

    @Test
    fun `getPlaybackState - playback present - returns result mapped via injected mapper`() = runTest {
        val expected = GetPlaybackStateResult.Value(playbackState = playbackStateData(trackId = "track-1"))
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(content = encodedPlaybackState()),
            playbackStateResponseToResultMapper = FakePlaybackStateResponseToResultMapper(onMap = { expected })
        )

        val result = dataSource.getPlaybackState()

        result.getOrNull() shouldBe expected
    }

    @Test
    fun `getPlaybackState - playback present - passes decoded response to injected mapper`() = runTest {
        val received = mutableListOf<CurrentlyPlayingContextObject>()
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(content = encodedPlaybackState()),
            playbackStateResponseToResultMapper = FakePlaybackStateResponseToResultMapper(
                onMap = { response ->
                    received.add(response)
                    GetPlaybackStateResult.None
                }
            )
        )

        dataSource.getPlaybackState()

        received shouldBe listOf(currentlyPlayingContextObject())
    }

    @Test
    fun `getPlaybackState - no content - returns none without calling injected mapper`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        )

        val result = dataSource.getPlaybackState()

        result.getOrNull() shouldBe GetPlaybackStateResult.None
    }

    @Test
    fun `getPlaybackState - forbidden - returns failure without calling injected mapper`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.Forbidden, content = ERROR_BODY)
        )

        val result = dataSource.getPlaybackState()

        assertTrue(result.isFailure)
    }

    @Test
    fun `getPlaybackState - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(engine = respondingWith(content = "[]"))

        val result = dataSource.getPlaybackState()

        assertTrue(result.isFailure)
    }

    @Test
    fun `getPlaybackState - request - targets the player path with GET`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.getPlaybackState()

        with(engine.requestHistory.first()) {
            method shouldBe HttpMethod.Get
            url.encodedPath shouldBe "/me/player"
        }
    }

    @Test
    fun `skipToNext - no content - returns success`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        )

        val result = dataSource.skipToNext()

        result shouldBe Result.success(Unit)
    }

    @Test
    fun `skipToNext - forbidden - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.Forbidden, content = ERROR_BODY)
        )

        val result = dataSource.skipToNext()

        assertTrue(result.isFailure)
    }

    @Test
    fun `skipToNext - request - targets the next path with POST`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.skipToNext()

        with(engine.requestHistory.first()) {
            method shouldBe HttpMethod.Post
            url.encodedPath shouldBe "/me/player/next"
        }
    }

    @Test
    fun `skipToPrevious - no content - returns success`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        )

        val result = dataSource.skipToPrevious()

        result shouldBe Result.success(Unit)
    }

    @Test
    fun `skipToPrevious - forbidden - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.Forbidden, content = ERROR_BODY)
        )

        val result = dataSource.skipToPrevious()

        assertTrue(result.isFailure)
    }

    @Test
    fun `skipToPrevious - request - targets the previous path with POST`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.skipToPrevious()

        with(engine.requestHistory.first()) {
            method shouldBe HttpMethod.Post
            url.encodedPath shouldBe "/me/player/previous"
        }
    }

    @Test
    fun `setShuffle - no content - returns success`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        )

        val result = dataSource.setShuffle(params = SetShuffleParams(isEnabled = true))

        result shouldBe Result.success(Unit)
    }

    @Test
    fun `setShuffle - forbidden - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.Forbidden, content = ERROR_BODY)
        )

        val result = dataSource.setShuffle(params = SetShuffleParams(isEnabled = true))

        assertTrue(result.isFailure)
    }

    @Test
    fun `setShuffle - request - targets the shuffle path with PUT and state`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.setShuffle(params = SetShuffleParams(isEnabled = false))

        with(engine.requestHistory.first()) {
            method shouldBe HttpMethod.Put
            url.encodedPath shouldBe "/me/player/shuffle"
            url.parameters["state"] shouldBe "false"
        }
    }

    @Test
    fun `pause - no content - returns success`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        )

        val result = dataSource.pause()

        result shouldBe Result.success(Unit)
    }

    @Test
    fun `pause - forbidden - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.Forbidden, content = ERROR_BODY)
        )

        val result = dataSource.pause()

        assertTrue(result.isFailure)
    }

    @Test
    fun `pause - request - targets the pause path with PUT`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.pause()

        with(engine.requestHistory.first()) {
            method shouldBe HttpMethod.Put
            url.encodedPath shouldBe "/me/player/pause"
        }
    }

    @Test
    fun `resume - no content - returns success`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        )

        val result = dataSource.resume()

        result shouldBe Result.success(Unit)
    }

    @Test
    fun `resume - forbidden - returns failure`() = runTest {
        val dataSource = playerRemoteDataSource(
            engine = respondingWith(status = HttpStatusCode.Forbidden, content = ERROR_BODY)
        )

        val result = dataSource.resume()

        assertTrue(result.isFailure)
    }

    @Test
    fun `resume - request - targets the play path with PUT`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.resume()

        with(engine.requestHistory.first()) {
            method shouldBe HttpMethod.Put
            url.encodedPath shouldBe "/me/player/play"
        }
    }

    @Test
    fun `resume - request - sends an empty json object body`() = runTest {
        val engine = respondingWith(status = HttpStatusCode.NoContent, content = "")
        val dataSource = playerRemoteDataSource(engine = engine)

        dataSource.resume()

        val body = engine.requestHistory.first().body as OutgoingContent.ByteArrayContent
        body.bytes().decodeToString() shouldBe "{}"
    }

    private fun encoded(items: List<PlayHistoryObject>) = Json.encodeToString(
        serializer = CursorPagingPlayHistoryObject.serializer(),
        value = cursorPagingPlayHistoryObject(items = items)
    )

    private fun encodedPlaybackState() = Json.encodeToString(
        serializer = CurrentlyPlayingContextObject.serializer(),
        value = currentlyPlayingContextObject()
    )

    private fun params(limit: Int = 10) = GetRecentlyPlayedParams(limit = limit)

    private fun playerRemoteDataSource(
        engine: MockEngine,
        recentlyPlayedResponseToResultMapper: RecentlyPlayedResponseToResultMapper =
            FakeRecentlyPlayedResponseToResultMapper(),
        playbackStateResponseToResultMapper: PlaybackStateResponseToResultMapper =
            FakePlaybackStateResponseToResultMapper()
    ): PlayerRemoteDataSourceImpl {
        val apiService = FakeApiService(onPlayerApi = { fakePlayerApi(engine = engine) })
        return PlayerRemoteDataSourceImpl(
            apiService = apiService,
            recentlyPlayedResponseToResultMapper = recentlyPlayedResponseToResultMapper,
            playbackStateResponseToResultMapper = playbackStateResponseToResultMapper
        )
    }

    private fun respondingWith(
        content: String,
        status: HttpStatusCode = HttpStatusCode.OK
    ): MockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = status,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private companion object {
        const val ERROR_BODY = """{"error":{"status":403,""" +
            """"message":"Player command failed: Premium required","reason":"PREMIUM_REQUIRED"}}"""
    }
}
